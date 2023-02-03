/*
 * Mad libs are a simple game where you create a story template with blanks for words. You, or another player,
then construct a list of words and place them into the story, creating an often silly or funny story as a result.
Create a simple mad-lib program that prompts for a noun, a verb, an adverb, and an adjective and injects those into a story that you create.

Example Output
Enter a noun: dog
Enter a verb: walk
Enter an adjective: blue
Enter an adverb: quickly
Do you walk your blue dog quickly? That's hilarious!

Constraints
• Use a single output statement for this program.
• If your language supports string interpolation or string substitution, use it to build up the output.

Challenges
• Add more inputs to the program to expand the story.
• Implement a branching story, where the answers to questions determine how the story is constructed.

 */

package Mad_Lib;

import java.util.Scanner;

public class Mad_lib {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a noun: ");
        String noun = input.nextLine();
        System.out.print("Enter a verb: ");
        String verb = input.nextLine();
        System.out.print("Enter an adjective: ");
        String adjective = input.nextLine();
        System.out.print("Enter an adverb: ");
        String adverb = input.nextLine();
        System.out.println("Do you " + verb + " your " + adjective + " " + noun + " " + adverb + "? That's hilarious!");
    }


}
