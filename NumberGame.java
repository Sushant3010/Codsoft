import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    // Constants
    static final int MAX_ATTEMPTS = 5;
    static final int MIN = 1;
    static final int MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int roundsWon = 0;

        System.out.println(" Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + MIN + " and " + MAX + ".");

        boolean playAgain = true;

        while (playAgain) {
            totalRounds++;
            int targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n Round " + totalRounds + " - You have " + MAX_ATTEMPTS + " attempts!");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print(" Enter your guess: ");
                int guess = getValidInteger(scanner);

                attempts++;

                if (guess == targetNumber) {
                    System.out.println(" Correct! You've guessed the number in " + attempts + " attempt(s).");
                    roundsWon++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println(" Too low!");
                } else {
                    System.out.println(" Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The number was: " + targetNumber);
            }

            // Ask user if they want to play again
            System.out.print("\n Do you want to play another round? (yes/no): ");
            String userInput = scanner.next().toLowerCase();

            playAgain = userInput.equals("yes") || userInput.equals("y");
        }

        // Show final score
        System.out.println("\n Game Over!");
        System.out.println(" Rounds Played: " + totalRounds);
        System.out.println(" Rounds Won: " + roundsWon);
        System.out.println("Thanks for playing!");

        scanner.close();
    }

    // Helper method to validate integer input
    private static int getValidInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print(" Invalid input. Please enter a number: ");
            scanner.next(); // clear invalid input
        }
        return scanner.nextInt();
    }
}
