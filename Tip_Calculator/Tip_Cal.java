/*
 * Create a simple tip calculator. The program should prompt for a bill amount and a tip rate.
 *  The program must compute the tip and then display both the tip and the total amount of the bill.
 * 
Example output:​ 
What is the bill? 
$200
​What is the tip percentage?
15
​The tip is $30.00
The total is $230.00

Test cases:
Ensure that the user can enter only numbers for the bill amount and
the tip rate. If the user enters non-numeric values, display an appropriate message and exit the program. Here’s a test plan as an
example:
​ Input:
​   bill amount: abcd
​   tip rate: 15
​ Expected result: Please enter a valid number for the bill amount.

Instead of displaying an error message and exiting the program, keep asking the user for correct input until it is provided.
Don’t allow the user to enter a negative number.

Break the program into functions that do the computations.

Implement this program as a GUI program that automatically updates the values when any value changes.

Instead of the user entering the value of the tip as a percentage, have the user drag a slider that rates satisfaction with the server, using a range between 5% and 20%.
 */

package Tip_Calculator;

import java.util.*;

public class Tip_Cal {
    public static void main(String[] args) {
        /*
         * Ensure that the user can enter only numbers for the bill amount and
         * the tip rate. If the user enters non-numeric values, display an appropriate
         * message and exit the program
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the bill?");
        String bill = sc.nextLine();
        // loop to keep asking for correct input until it is provided
        while (bill.matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid number for the bill amount");
            System.out.println("What is the bill?");
            bill = sc.nextLine();
        }
        System.out.println("What is the tip percentage?");
        String tip = sc.nextLine();
        while (tip.matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid number for the bill amount.");
            System.out.println("What is the tip percentage?");
            tip = sc.nextLine();
        }
        try {
            double billAmount = Double.parseDouble(bill);
            double tipRate = Double.parseDouble(tip);
            if (billAmount < 0 || tipRate < 0) {
                System.out.println("Please enter a valid number for the bill amount.");
            } else {
                double tipAmount = billAmount * (tipRate / 100);
                double totalAmount = billAmount + tipAmount;
                System.out.println("The tip is $" + tipAmount);
                System.out.println("The total is $" + totalAmount);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number for the bill amount.");
        }

    }
}