public class Main {
    public static void main(String[] args) {
        System.out.println("1- Easy");
        System.out.println("2- Medium");
        System.out.println("3- Hard");
        System.out.println("4- Impossible");

        GameInputHandler inputHandler = new GameInputHandler();
        int level = inputHandler.getGameLevel();

        GuessingGame guessingGame = new GuessingGame(level);
        guessingGame.startGame();
    }
}