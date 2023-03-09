import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private int randomNumber;
    private int attempts;
    private int level = 0;
    private LocalDateTime beginLocalDate;
    private LocalDateTime finalLocalDate;
    private Duration duration;
    private final static int EASY_MAX_NUMBER = 10;
    private final static int MEDIUM_MAX_NUMBER = 50;
    private final static int HARD_MAX_NUMBER = 100;
    private final static int IMPOSSIBLE_MAX_NUMBER = 1000;
    private final static int MAX_ATTEMPTS = 5;
    private Scanner scanner = new Scanner(System.in);

    GuessingGame() {
        System.out.println("1- Easy");
        System.out.println("2- Medium");
        System.out.println("3- Hard");
        System.out.println("4- Impossible");
        while (level < 1 || level > 4) {
            System.out.println("Enter you Game Level:");
            try {
                level = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
                continue;
            }
            if (level < 1 || level > 4) {
                System.out.println("Invalid Level, choose a level between 1 and 4");
            } else {
                startGame();
            }
        }
    }

    private void startGame() {
        generateNumber(level);
        beginLocalDate = LocalDateTime.now();
        game();
    }

    private void generateNumber(int level) {
        int maxNumber;
        switch (level) {
            case 1:
                maxNumber = EASY_MAX_NUMBER;
                break;
            case 2:
                maxNumber = MEDIUM_MAX_NUMBER;
                break;
            case 3:
                maxNumber = HARD_MAX_NUMBER;
                break;
            case 4:
                maxNumber = IMPOSSIBLE_MAX_NUMBER;
                break;
            default:
                return;
        }
        randomNumber = new Random().nextInt(maxNumber + 1);
    }

    private void game() {
        int guessingNumber = -1;
        while (guessingNumber != randomNumber && attempts < MAX_ATTEMPTS) {
            System.out.println("Guess the number");
            try {
                guessingNumber = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
                continue;
            }
            attempts++;
            if (guessingNumber > randomNumber) {
                System.out.println("Lower");
                System.out.println("Attempt N: " + attempts);
            }
            if (guessingNumber < randomNumber) {
                System.out.println("Attempt N: " + attempts);
                System.out.println("Higher");
            }
        }
        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Looser");
            System.out.println("Guessing Number was: " + randomNumber);
            System.out.println("Time: " + gameDuration().getSeconds() + " seconds");
        } else {
            System.out.println("Congrats you got the Guessing Number: " + randomNumber + "\nTook: " + attempts + " attempts");
            System.out.println("Time: " + gameDuration().getSeconds() + " seconds");
        }
    }

    private Duration gameDuration() {
        finalLocalDate = LocalDateTime.now();
        duration = Duration.between(beginLocalDate, finalLocalDate);
        return duration;
    }
}