import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = keyboard.nextLine();
        Player user = new Player(name);
        System.out.print("What would you like to name your opponent? ");
        String compName = keyboard.nextLine();
        Player computer = new Player(compName);
        GoFishGame game = new GoFishGame(user, computer);
        game.startGame();
        int newGame = 1;
        while (newGame == 1){
            game.startGame();
            System.out.print("Do you want to play again? (1 - Yes, 2 - No");
            keyboard.nextInt();
            keyboard.nextLine();
        }
        System.out.println("Good bye!");
    }
}