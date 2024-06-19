import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            char moveA = getMove(scanner, "Player A");

            char moveB = getMove(scanner, "Player B");

            determineWinner(moveA, moveB);

            playAgain = askToPlayAgain(scanner);



        }
        scanner.close();
    }

    private static char getMove(Scanner scanner, String player) {
        char move;
        while (true) {
            System.out.print(player + ", enter your move (R,P,S): ");
            move = scanner.next().toUpperCase().charAt(0);
            if (move == 'R' || move == 'P' || move == 'S') {
                break;
            }
            System.out.println("Please enter a valid move: R, P, S. ");
        }
        return move;
    }

    private static void printResult(char winnerMove, char loserMove, String winner) {
        if (winnerMove == 'R' && loserMove == 'S') {
            System.out.println("Rock breaks Scissors! " + winner + " wins!");
        } else if (winnerMove == 'P' && loserMove == 'R') {
            System.out.println("Paper covers Rock! " + winner + " wins!");
        } else if (winnerMove == 'S' && loserMove == 'P') {
            System.out.println("Scissors cuts Paper! " + winner + " wins!");
        }
    }

    private static void determineWinner(char moveA, char moveB) {
        if (moveA == moveB) {
            System.out.println("It's a tie!");
        } else if (moveA == 'R' && moveB == 'S' || moveA == 'P' && moveB == 'R' || moveA == 'S' && moveB == 'P') {
            printResult(moveA, moveB, "Player A");
        } else {
            printResult(moveB, moveA, "Player B");
        }
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Do you want to play again? [Y/N]: ");
            String response = scanner.next().trim().toUpperCase();

            if (response.equals("Y")) {
                return true;
            } else if (response.equals("N")) {
                return false;
            }
            System.out.println("Invalid input. Please enter Y or N. ");
        }

    }
}