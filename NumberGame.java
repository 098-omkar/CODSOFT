import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;               //minimum range of number initialized.
        int maxRange = 100;            //Maximum range of number initialized.
        int maxAttempts = 10;
        int score = 0;

        // print the game name.
        System.out.printf("\n|              |-------------------> NUMBER GAME<----------------------|\n");

        // loops for applying condition.
        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int guess;

            System.out.println("  \n\n|- * New Round |\n");
            System.out.println("_____________________________________________________________________________________");
            System.out.println( "\n\n I have generated a number between " + minRange + " and " + maxRange +
                    " You have " + maxAttempts + " attempts to guess it. \n");
            System.out.println( "______________________________________________________________________________________");
            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");

                guess = scanner.nextInt();
                attempts++;

                //use if-else condition for results.
                if (guess == targetNumber) {
                    System.out.println("Great!!!! , The Correct Number Guessed :  " + attempts + " attempts");
                    score++;
                    break;   // break statement declared.
                } else if (guess < targetNumber) {
                    System.out.println("to low! Try again.");
                } else {
                    System.out.println("to high! Try again.");
                }
            }

            System.out.println("________________________________________________________________________________\n");

            if (attempts == maxAttempts) {
                System.out.println("Oops! You ran out of attempts. The correct number was: " + targetNumber);
                System.out.println("\n_____________________________________________________________________________");
            }

            System.out.print("\n Do you want to play again? (yes/no):");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your score: " + score);


    }
}
