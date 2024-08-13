import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Get the number of rounds from the user
        System.out.print("Enter the number of rounds you want to play: ");
        int maxRounds = scanner.nextInt();

        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        for (int round = 1; round <= maxRounds; round++) {
            int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100

            // Get the maximum number of attempts from the user
            System.out.print("\nRound " + round + ": Enter the maximum number of attempts: ");
            int maxAttempts = scanner.nextInt();

            int attempts = 0;
            boolean hasGuessed = false;

            System.out.println("I have selected a number between 1 and 100. Can you guess it?");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    totalScore += (maxAttempts - attempts + 1) * 10; // Points based on attempts left
                    hasGuessed = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("The number is higher than " + userGuess + ".");
                } else {
                    System.out.println("The number is lower than " + userGuess + ".");
                }
            }

            if (!hasGuessed) {
                System.out.println("Sorry! You've used all attempts. The correct number was " + randomNumber + ".");
            }

            System.out.println("Score after round " + round + ": " + totalScore);
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
        scanner.close();

}}