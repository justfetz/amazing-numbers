package numbers;

import java.math.BigInteger;
import java.util.Objects;
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

    public static boolean isPalindrome(long x) {
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
        //cant parse long value
        String firstDigit = Integer.toString((int)x).substring(0,1);
        String lastDigit = Integer.toString((int)x).substring(Integer.toString((int)x).length()-1);
        String combined = firstDigit + lastDigit;
        int combinedInt = Integer.parseInt(combined);
        if(firstDigit.equals("1")) {
            return false;
        }
        return (int)x % combinedInt == 0;
    }

    public static String printNumberInformation(long x) {
        boolean[] rep = new boolean[6];
        rep[0] = isBuzz(x);
        //duck, palindrome, gapful, even, odd
        rep[1] = isDuck(x);
        rep[2] = isPalindrome(x);
        rep[3] = isGapful(x);

        rep[4] = isEven(x);
        rep[5] = isOdd(x);
        String[] repper = new String[] {"buzz,","duck,","gapful,","palindromic,","even,","odd"};
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < rep.length; i++) {
            if(rep[i]==true) {
                s.append(repper[i]);
            }
        }
        return s.toString();
    }

    public static boolean checkInputs(long[] joe) {
        if(Objects.isNull(joe[0]) || Objects.isNull(joe[1])) {
            return false;
        }
        return true;
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
        System.out.println("");
        System.out.println("Enter a request:");
    }


    public static void main(String[] args) {
//        write your code here
        Scanner s = new Scanner(System.in);
        String toParse = "";
        long x;
        long y;
        printMenu();
        while(true) {
            String input = s.nextLine();
            //case is 1, no second number
            if (input.equals("0") ) {
                System.exit(0);
            }  else if (input.isBlank()) {
                printMenu();
            }
            else {
                String[] testArray = (input.split(" "));
                long[] numbers = new long[testArray.length];
                for(int i = 0;i < testArray.length;i++) {
                    numbers[i] = Long.parseLong(testArray[i]);
                }

                x = numbers[0];
                y = 0;
                if (numbers.length == 2) {
                    y = numbers[1];
                }
                if (x < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    printMenu();
                } else if ((y <= 0 || Objects.isNull(y)) && numbers.length == 2) { //bug here executes case
                    System.out.println("The second parameter should be a natural number.");
                    printMenu();
                }
                else if (y > 0) {
                    for (long i = x; i < x + y; i ++) {
                        System.out.print(i + " is ");
                        System.out.println(printNumberInformation(i));
                    }
                } else {
                    boolean truthTeller = isBuzz(x);
                    boolean duckTeller = isDuck(x);
                    boolean parityTeller = isEven(x);
                    boolean paliTeller = isPalindrome(x);
                    boolean gapTeller = isGapful(x);

                    System.out.println("Properties of " + x);
                    System.out.print("\t buzz: ");
                    System.out.println(truthTeller);
                    System.out.print("\t duck: ");
                    System.out.println(duckTeller);
                    System.out.print("\t palindromic: ");
                    System.out.println(paliTeller);
                    System.out.print("\t gapful: ");
                    System.out.println(gapTeller);
                    System.out.print("\t even: ");
                    System.out.println(parityTeller);
                    System.out.print("\t odd: ");
                    System.out.println(isOdd(x));

                }

            printMenu();
            //System.exit(0);
        }
        }
    }
}