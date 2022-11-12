// importing important libraries to be used
import java.util.Scanner;
import java.io.*; 

class ISBNNumber {

   // method to check if ISBNum is an ISBN 
    public static boolean checkISBN(String ISBNum) {

        // declare variable
        int length = 0;

        // testing if ISBNum is an long integer or not
        try {
            // except for the case where it ends with X or x
            char ch = ISBNum.charAt(9);
            ch = Character.toUpperCase(ch);
            if( ch != 'X') {
                Long.parseLong(ISBNum);
            }
        }   // catching other formats exceptions
            catch(NumberFormatException nfe) {
                return false;
            }

        // testing the length of ISBNum
        length = ISBNum.length();
        if(length == 13)
            return checkISBN13(ISBNum);
        else if(length == 10)
            return checkISBN10(ISBNum);
        else return false;
    }
   
    // method to check for ISBN-10
    private static boolean checkISBN10(String ISBNum) {

        // declaration
        int sum = 0;
        int digit = 0;
        char ch = '\0';

        // add upto 9th digit
        for(int i=1; i<=9; i++) {
            ch = ISBNum.charAt(i-1);
            digit = Character.getNumericValue(ch);
            sum += (i* digit);
        }

        // catching the last digit exception
        ch = ISBNum.charAt(9);
        ch = Character.toUpperCase(ch);
        if(ch =='X')
            sum += (10*10);
        else {
            digit = Character.getNumericValue(ch);
            sum += (digit * 10);
        }

        // checking if sum is divisible by 11
        if(sum % 11 == 0)
            return true;

        return false;
    }

    // method to check for ISBN-13
    private static boolean checkISBN13(String ISBNum) {
        // declaration
        int sum = 0;
        int multiple = 0;
        char ch = '\0';
        int digit = 0;

        // craeting products
        for(int i=1; i<=13; i++) {
            if(i % 2 == 0)
                multiple = 3;
            else multiple = 1;

            // breakdown of ISBNum
            ch = ISBNum.charAt(i-1);
            // converting to integers
            digit = Character.getNumericValue(ch);
            // addition of products
            sum += (multiple*digit);
        }

        // checking if sum is divisible by 10
        if(sum%10 == 0)
            return true;
        return false;
    }

    // the main method
    public static void main(String[] args) {

        // declaration of variables
        String ISBNum = null;
        boolean result = false;

        //create Scanner class object to take input from the console
        Scanner scan = new Scanner(System.in);
        // number of times the ISBN can be tested
        // while within bounds
        int count = 5;

        try {
            while(count > 0) {
                // take input from end-user
                System.out.println("Please enter an ISBN (only numbers allowed): ");
                ISBNum = scan.nextLine();
                // check number is isbn number or not
                result = checkISBN(ISBNum);

                // validity of ISBN
                if(result)
                    System.out.println("Valid");
                else
                    System.out.println("Invalid");
                count--;
            }
            // close Scanner class object
            scan.close();
        }   // // to handle exceptions
            catch (Exception e) {
                System.out.println("Invalid");
            }
    }
}