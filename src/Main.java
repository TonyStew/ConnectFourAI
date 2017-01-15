/**
 * Created by birch_000 on 1/14/2017.
 */
import java.util.Scanner;

public class Main {

    private static Board board;
    private static AI2 ai;

    public static void main(String[] args) {
        //initialization
        board = new Board();
        ai = new AI2();
        //run main loop
        run();
    }

    public static void run() {
        //true = player's turn, false = ai's turn
        boolean playersTurn = true;

        //testing int
        int turn = 0;

        board.draw();
        while (!board.gameOver()) {
            //player turn
            if (playersTurn) {
                //test
                turn++;
                System.out.println("turn: " + turn);
                //test
                boolean validInput = false;
                while (!validInput) {
                    System.out.print("What row would you like to play in? (1-7): ");
                    Scanner input = new Scanner(System.in);
                    try {
                        board.place(input.nextInt() - 1, true);
                        validInput = true;
                    } catch (Exception e) {
                        validInput = false;
                        System.out.println("Invalid input.");
                        System.out.println(e);
                    }
                }
                playersTurn = false;
                board.draw();
                System.out.println();
            }
            //ai turn
            else {
                //test
                turn++;
                System.out.println("turn: " + turn);
                //test
                System.out.println("AI move: ");
                board.place(ai.getMove(board), false);
                playersTurn = true;
                board.draw();
                System.out.println();
            }
            /*
            else {
                board.draw();
                boolean validInput = false;
                while (!validInput) {
                    System.out.print("(AI)What row would you like to play in? (1-7): ");
                    Scanner input = new Scanner(System.in);
                    try {
                        board.place(input.nextInt() - 1, false);
                        validInput = true;
                    } catch (Exception e) {
                        validInput = false;
                        System.out.println("Invalid input.");
                        System.out.println(e);
                    }
                }
                playersTurn = true;
                board.draw();
                System.out.println();
            }
            */
        }
    }
}