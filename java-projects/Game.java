import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter your choice (rock, paper, or scissors): ");
        String Choice = sc.nextLine().toLowerCase();

        int Num = rand.nextInt(3); 
        String opponent = "";

        if (Num == 0)
            opponent = "rock";
        else if (Num == 1)
            opponent = "paper";
        else
            opponent = "scissors";

        System.out.println("opponent chose: " + opponent);

        switch (Choice) {
    case "rock":
        if (opponent.equals("scissors")) {
            System.out.println("You win!");
        } else if (opponent.equals("paper")) {
            System.out.println("You lose!");
        } else {
            System.out.println("It's a tie!");
        }
        break;

    case "paper":
        if (opponent.equals("rock")) {
            System.out.println("You win!");
        } else if (opponent.equals("scissors")) {
            System.out.println("You lose!");
        } else {
            System.out.println("It's a tie!");
        }
        break;

    case "scissors":
        if (opponent.equals("paper")) {
            System.out.println("You win!");
        } else if (opponent.equals("rock")) {
            System.out.println("You lose!");
        } else {
            System.out.println("It's a tie!");
        }
        break;

    default:
        System.out.println("Invalid input!");
}


        sc.close();
    }
}
