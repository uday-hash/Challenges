/*
 * Quotation marks are often used to denote the start and end of a string. But sometimes
we need to print out the quotation marks themselves by using escape characters.
Create a program that prompts for a quote and an author. Display the quotation and author
as shown in the example output.

Example Output​ 
What is the quote? 
These aren't the droids you're looking for.​ 
Who said it? 
Obi-Wan Kenobi​ Obi-Wan Kenobi says, "These aren't the droids​ you're looking for

Constraints​
• Use a single output statement to produce this output, using appropriate string-escaping
techniques for quotes.
• If your language supports string interpolation or string substitution, don’t use it for this
exercise. Use string concatenation instead.

 */

package Printing_quotes;

import java.util.Scanner;

public class Quotes {
    public static void main(String[] args) {
        String quote = "These aren't the droids you're looking for.";
        String author = "Obi-Wan Kenobi";
        System.out.println(author + " says, \"" + quote + "\"");
    }    
}
