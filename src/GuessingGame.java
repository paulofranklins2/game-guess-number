// GuessingGame.java
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class GuessingGame {
    private int randomNumber;
    private int attempts;
    private final int level;
    private LocalDateTime beginLocalDate;

    public GuessingGame(int level) {
        this.level = level;
    }

    public void startGame() {
        generateNumber();
        beginLocalDate = LocalDateTime.now();
        game();
    }

    private void generateNumber() {
        int maxNumber;
        switch (level) {
            case 1:
                maxNumber = GameConfiguration.EASY_MAX_NUMBER;
                break;
            case 2:
                maxNumber = GameConfiguration.MEDIUM_MAX_NUMBER;
                break;
            case 3:
                maxNumber = GameConfiguration.HARD_MAX_NUMBER;
                break;
            case 4:
                maxNumber = GameConfiguration.IMPOSSIBLE_MAX_NUMBER;
                break;
            default:
                return;
        }
        randomNumber = new Random().nextInt(maxNumber + 1);
    }

    private void game() {
        GameInputHandler inputHandler = new GameInputHandler();
        int guessingNumber = -1;

        while (guessingNumber != randomNumber && attempts < GameConfiguration.MAX_ATTEMPTS) {
            guessingNumber = inputHandler.getGuessingNumber();
            attempts++;

            if (guessingNumber > randomNumber) {
                System.out.println("Lower");
                System.out.println("Attempt N: " + attempts);
            } else if (guessingNumber < randomNumber) {
                System.out.println("Attempt N: " + attempts);
                System.out.println("Higher");
            }
        }

        displayResult();
    }

    private void displayResult() {
        if (attempts == GameConfiguration.MAX_ATTEMPTS) {
            System.out.println("Looser");
            System.out.println("Guessing Number was: " + randomNumber);
        } else {
            System.out.println("Congrats you got the Guessing Number: " + randomNumber + "\nTook: " + attempts + " attempts");
        }
        System.out.println("Time taken: " + gameDuration().getSeconds() + " seconds");
    }

    private Duration gameDuration() {
        LocalDateTime finalLocalDate = LocalDateTime.now();
        return Duration.between(beginLocalDate, finalLocalDate);
    }
}