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

        //while (!board.gameOver()) {
        while (true) {
            //player turn
            if (playersTurn) {
                board.draw();
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
            }
            /*/ai turn
            else {
                board.place(ai.getMove(), false);
                playersTurn = true;
            }
            */
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
            }
        }
    }
}