import java.util.Scanner;

public class GameInputHandler {
    private final Scanner scanner;

    public GameInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getGameLevel() {
        int level = 0;
        while (level < 1 || level > 4) {
            System.out.println("Enter your Game Level:");
            try {
                level = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
            if (level < 1 || level > 4) {
                System.out.println("Invalid Level, choose a level between 1 and 4");
            }
        }
        return level;
    }

    public int getGuessingNumber() {
        System.out.println("Guess the number");
        int guessingNumber = -1;
        try {
            guessingNumber = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.nextLine();
        }
        return guessingNumber;
    }
}
