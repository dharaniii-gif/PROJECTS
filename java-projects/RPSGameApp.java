import java.util.*;

enum Choice {
    ROCK, PAPER, SCISSORS;

    // Method to convert enum names to lowercase for display
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

class Game {
    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();

    // Method to get user's choice
    public Choice getUserChoice() {
        System.out.print("Enter your choice (rock, paper, scissors): ");
        String input = sc.nextLine().trim().toLowerCase();

        switch (input) {
            case "rock": return Choice.ROCK;
            case "paper": return Choice.PAPER;
            case "scissors": return Choice.SCISSORS;
            default:
                System.out.println("Invalid input! Try again.");
                return getUserChoice();  // recursive call
        }
    }

    // Method to get computer's choice
    public Choice getComputerChoice() {
        int num = rand.nextInt(3);
        return Choice.values()[num];
    }

    // Method to decide winner
    public String determineWinner(Choice user, Choice computer) {
        if (user == computer) {
            return "It's a tie!";
        }

        switch (user) {
            case ROCK:
                return (computer == Choice.SCISSORS) ? "You win!" : "You lose!";

            case PAPER:
                return (computer == Choice.ROCK) ? "You win!" : "You lose!";

            case SCISSORS:
                return (computer == Choice.PAPER) ? "You win!" : "You lose!";
        }

        return "Error!";
    }

    // Method to start the game
    public void start() {
        Choice userChoice = getUserChoice();
        Choice computerChoice = getComputerChoice();

        System.out.println("Opponent chose: " + computerChoice);
        System.out.println(determineWinner(userChoice, computerChoice));
    }
}

// Updated main class name
public class RPSGameApp {
    public static void main(String[] args) {
        Game rpsGame = new Game();
        rpsGame.start();
    }
}
