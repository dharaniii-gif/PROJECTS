import java.util.*;

enum Choice {
    ROCK, PAPER, SCISSORS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

class InvalidChoiceException extends Exception {
    public InvalidChoiceException(String message) {
        super(message);
    }
}

class Game {
    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();

    // Validate user input
    private Choice validateChoice(String input) throws InvalidChoiceException {
        input = input.toLowerCase().trim();

        switch (input) {
            case "rock": return Choice.ROCK;
            case "paper": return Choice.PAPER;
            case "scissors": return Choice.SCISSORS;
            default:
                throw new InvalidChoiceException("Invalid choice: " + input);
        }
    }

    // Get user input with exception handling
    public Choice getUserChoice() {
        while (true) {
            try {
                System.out.print("Enter your choice (rock, paper, scissors): ");
                String input = sc.nextLine();

                if (input == null || input.isEmpty()) {
                    throw new InvalidChoiceException("Input cannot be empty!");
                }

                return validateChoice(input);  // may throw exception

            } catch (InvalidChoiceException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.\n");
            } catch (Exception e) {
                System.out.println("Unexpected error! " + e.getMessage());
            }
        }
    }

    public Choice getComputerChoice() {
        int num = rand.nextInt(3);
        return Choice.values()[num];
    }

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
        return "Error determining winner!";
    }

    public void start() {
        try {
            Choice userChoice = getUserChoice();
            Choice computerChoice = getComputerChoice();

            System.out.println("Opponent chose: " + computerChoice);
            System.out.println(determineWinner(userChoice, computerChoice));

        } catch (Exception e) {
            System.out.println("Game crashed due to unexpected error: " + e.getMessage());
        }
    }
}


public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Game rpsGame = new Game();
        rpsGame.start();
    }
}
