# javaautobooksamples
Source code files as in the book - "Software Quality and Java Automation Survival Guide".

To compile the main java samples, run the following after setting up maven:

mvn compile

Run programs based on the inputs (check the book/source code for required parameters).
Example:

 java -classpath target/classes com.everydayon.PrimeNumber 5 20
 
(or)
 mvn exec:java -Dexec.mainClass=com.everydayon.PrimeNumber -Dexec.args="5 20"

To compile the test java samples:
 mvn test-compile
