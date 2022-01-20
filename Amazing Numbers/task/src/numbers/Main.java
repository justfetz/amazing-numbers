package numbers;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static boolean isBuzz(long x) {
        long y = x % 10;
        if( y == 7 || x % 7 == 0) {
            return true;
        }
        return false;
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

    public static void printMenu() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");
        System.out.println(" ");
        System.out.println("Enter a request:");
    }

    public static void main(String[] args) {
//        write your code here
        Scanner s = new Scanner(System.in);
        long x = 0;
        printMenu();
        while(true) {
            x = s.nextLong();
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