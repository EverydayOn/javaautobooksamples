package com.everydayon;

/**
 * 567.	Write a program to print words for given number.
 *  Description: Converting numbers to Words (as in dollar check)
 *  Example: 123456789
 *  Given number 1,234,567 is in WORDS:
 * ***  ONE  MILLION  TWO  HUNDRED THIRTY FOUR  THOUSAND   FIVE  HUNDRED SIXTY SEVEN  ***
 * @author jmunta
 */
public class NumberText {

    static String [] ONES = { "ZERO","ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", 
        "SEVEN", "EIGHT", "NINE","TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FORTEEN",
        "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN", "TWENTY"};
    static String [] TENS = { "ZERO","TEN","TWENTY","THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};
    //static String [] HUNDREDS = { "ZERO","HUNDRED", "THOUSAND", "MILLION", "TRILLION"};
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = 156;
        String ns = String.valueOf(n);
        // Take the input
        if (args.length>0) {
            ns = args[0]; 
        }
        String result = " ";
        String s = null;
        int l = ns.length();
        if (ns.length()>3) {            
              s=ns.substring(l-3, l);
              result+=convert3digits(s);
              l = l-3;
              if (l<=3) { // 6 digits
                s=ns.substring(0, l);
                result=convert6digits(s)+result;                  
              }
              if (l>3) { // 9 digits
                s=ns.substring(l-3, l);
                result=convert6digits(s)+result;
                l = l-3;
                if (l<=3) {
                  s=ns.substring(0, l);
                  result=convert9digits(s)+result;                  
                }
              }
        } else {
            result+=convert3digits(ns);
        }
        System.out.printf("Given number %,d is in WORDS: \n*** %s ***",Integer.valueOf(ns),result);
                
    }
    
    /*
     * Process 3 digits
     */
    static String convert3digits(String ns) {
        String text = " ";
        
        // conver to number
        int n = Integer.valueOf(ns);
        
        // Basic numbers
        if (n<=20) {
            text+=ONES[n]+" ";
        } 
        
        if ((n>20) && (n<=99)) {
            text+=TENS[n/10]+" ";
            if (n%10!=0){
                text+=ONES[n%10]+" ";
            }
        }
        
        int n1 = 0;
        if (n>99) {
            n1 = n/100;
            if (n1<=20) {
                text+=ONES[n1]+" ";
            } 
            if ((n1>20) && (n1<=99)) {
                text+=TENS[n1/10]+" ";
                if (n1%10!=0){
                    text+=ONES[n1%10]+" ";
                }
            }
            text+=" HUNDRED ";
            n1 = (n-(n/100)*100);
            if (n%100!=0) {
                text+=TENS[n1/10]+ " ";
            }
            if (n%10!=0){
                text+=ONES[n1%10]+" ";
            }
        }
        return text;
    }

    /*
     * Process 6 digits
     */
    static String convert6digits(String ns) {
        String t3 = convert3digits(ns);
        return t3+" THOUSAND ";
    }

    /*
     * Process 9 digits
     */
    static String convert9digits(String ns) {
        String t6 = convert3digits(ns);
        return t6+" MILLION ";
    }
    
}

