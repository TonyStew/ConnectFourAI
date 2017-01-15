/**
 * Created by birch_000 on 1/14/2017.
 */
import java.util.Scanner;

public class Main {

    private static Board board;
    private static AI ai;

    public static void main(String[] args) {
        //initialization
        board = new Board();
        ai = new AI();
        //run main loop
        run();
    }

    public static void run() {
        //ture = player's turn, false = ai's turn
        boolean playersTurn = true;

        //while (!Board.gameOver()) {
        while (true) {
            board.draw();
            //player turn
            if (playersTurn) {
                boolean incorrectInput = false;
                while (!incorrectInput) {
                    System.out.print("What row would you like to play in? (1-7): ");
                    Scanner input = new Scanner(System.in);
                    try {
                        board.place(input.nextInt(), true);
                        incorrectInput = false;
                    } catch (Exception e) {
                        incorrectInput = true;
                        System.out.println("Invalid input.");
                    }
                }
                playersTurn = false;
            }
            //ai turn
            else {
                board.place(ai.getMove(), false);
                playersTurn = true;
            }
        }
    }
}