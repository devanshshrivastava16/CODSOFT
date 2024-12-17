import java.util.*;

class Taskfirst {

    int generateRandom() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    void playGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to the Number Guessing Game!");
        System.out.println("You have 8 attempts to guess the correct number.");

        int attempts = 0;
        int targetnumber = generateRandom();

        while (attempts < 8) {
            System.out.print("\nEnter your guess (1-100): ");
            int userGuess = sc.nextInt();

            if (userGuess == targetnumber) {
                attempts++;
                System.out.println("Hurray! You guessed the number in " + attempts + " attempts!");
                return;
            } else if (userGuess > targetnumber) {
                System.out.println("Too high! Try a smaller number.");
            } else {
                System.out.println("Too low! Try a larger number.");
            }
            attempts++;
            System.out.println("Attempts remaining: " + (8 - attempts));
        }

        System.out.println("\nYou've used all 8 attempts! The correct number was: " + targetnumber);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Taskfirst game = new Taskfirst();
        int again;

        do {
            game.playGame();
            System.out.print("\nDo you want to play again? Enter 1 for Yes, 0 for No: ");
            again = sc.nextInt();
        } while (again == 1);

        System.out.println("Thanks for playing! Goodbye!");
    }
}
