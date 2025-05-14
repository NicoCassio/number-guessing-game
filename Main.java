import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Random random = new Random();

    while (true) {
      int numberToGuess = random.nextInt(100) + 1;

      System.out.println("Welcome to the Number Guessing Game!");
      System.out.println("I'm thinking of a number between 1 and 100.");
      System.out.println("You have 5 chances to guess the correct number.");

      System.out.println("Please select the difficulty level:");
      System.out.println("1. Easy (10 chances)");
      System.out.println("2. Medium (5 chances)");
      System.out.println("3. Hard (3 chances)");

      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();

      String[] difficulties = { "Easy", "Medium", "Hard" };

      System.out.println("Great! You have selected the " + difficulties[choice - 1] + " difficulty level.");
      System.out.println("Let's start the game!");
      Instant start = Instant.now();

      int[] chances = { 10, 5, 3 };

      for (int i = 0; i < chances[choice - 1]; i++) {
        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt();

        if (guess == numberToGuess) {
          Instant end = Instant.now();
          String attemptPlural = i > 0 ? "attempts" : "attempt";
          System.out
              .println("Congratulations! You guessed the correct number in " + (i + 1) + " " + attemptPlural + ".");
          System.out.println("You took " + Duration.between(start, end).getSeconds() + " seconds.");
          break;
        }

        String comparativeStatement = guess < numberToGuess ? "greater" : "less";

        System.out.println("Incorrect! The number is " + comparativeStatement + " than " + guess + ".");
      }

      System.out.println("Do you want to play again?");
      System.out.println("1. Yes");
      System.out.println("2. No");

      System.out.print("Enter your choice: ");
      boolean again = scanner.nextInt() == 1 ? true : false;

      if (!again) {
        break;
      }
    }

    scanner.close();
  }
}
