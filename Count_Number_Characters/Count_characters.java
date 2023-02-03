/*
 * Counting the Number of Characters
Create a program that prompts for an input string and displays output that shows the input string and the number of characters the string
contains.

Example Output​ What is the input string? 
takes 500 characters as input

Constraints:
Be sure the output contains the original string.Use a single output statement to construct the output.
Use a built-in function of the programming language to determine the length of the string.

Challenges
If the user enters nothing, state that the user must enter something into the program.

 */

package Count_Number_Characters;

import java.util.*;

public class Count_characters {
    public static void main(String[] args) {
        /*
         * Create a program that prompts for an input string and displays output that
         * shows the input string and the number of characters the string contains.
         */
        // import Scanner
        Scanner sc = new Scanner(System.in);
        // prompt for input string
        System.out.println("What is the input string?");
        // store input string
        String input = sc.nextLine();
        // display output that shows the input string and the number of characters the
        // string contains
        System.out.println("your string has " + input.length() + " characters.");
    }
}
