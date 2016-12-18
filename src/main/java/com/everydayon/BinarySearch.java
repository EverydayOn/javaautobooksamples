package com.everydayon;

import java.util.Arrays;

/**
 * 551. Write a binary search program.
 * Binary search method
 * User: jmunta
 */
public class BinarySearch {


    /* Driver program to check above functions */
    public static void main(String []args)
    {
        System.out.println("Searching...");
        int arr[] = {3, 4, 5, 1, 2};
        Arrays.sort(arr); // {1, 2, 3, 4,5}
        int no = 1;
        System.out.println(binarySearch(arr, 0, arr.length, no));
        System.out.println("Searching...done");
    }

    /* Standard Binary Search function*/
    public static int binarySearch(int arr[], int low, int high, int no)
    {
        if (high < low)
            return -1;

        int mid = (low + high)/2;  /*low + (high - low)/2;*/

        if (no == arr[mid])
            return mid;
        if (no > arr[mid])
            return binarySearch(arr, (mid + 1), high, no);
        else
            return binarySearch(arr, low, (mid -1), no);
    }
}

