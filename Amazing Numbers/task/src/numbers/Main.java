package numbers;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static boolean isBuzz(long x) {
        long y = x % 10;
        return y == 7 || x % 7 == 0;
    }

    public static boolean isEven(long x) {
        return x % 2 == 0;
    }

    public static boolean isOdd(long x) {
        return x % 2 != 0;
    }

    public static boolean isDuck(long x) {
        return String.valueOf(x).contains("0");
    }

    public static boolean isPalindome(long x) {
        long palindrome = x;
        long reverse = 0;
        // Compute the reverse
        while (palindrome != 0) {
            long remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        return x == reverse;
    }

    public static boolean isGapful(long x) {
        return false;
    }

    public static void printMenu() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("    * the first parameter represents a starting number;");
        System.out.println("    * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }


    public static void main(String[] args) {
//        write your code here
        Scanner s = new Scanner(System.in);
        int number = 534;
        int firstDigit = Integer.parseInt(Integer.toString(number).substring(1,2));
        System.out.println(firstDigit);
        String toParse = "";
        long x;
        printMenu();
        while(true) {
            x = s.nextLong();
            //toParse = s.nextLine();
        if (x == 0 ) {
            System.exit(0);
        } else if (x < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            printMenu();
        } else {
            boolean truthTeller = isBuzz(x);
            boolean duckTeller = isDuck(x);
            boolean parityTeller = isEven(x);
            boolean paliTeller = isPalindome(x);

            System.out.println("Properties of " + x);
            System.out.print("\t even: ");
            System.out.println(parityTeller);
            System.out.print("\t odd: ");
            System.out.println(isOdd(x));
            System.out.print("\t buzz: ");
            System.out.println(truthTeller);
            System.out.print("\t duck: ");
            System.out.println(duckTeller);
            System.out.print("\t palindromic: ");
            System.out.println(paliTeller);
            printMenu();
            //System.exit(0);
        }
        }
    }
}