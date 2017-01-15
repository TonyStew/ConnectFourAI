/**
 * Created by root on 1/14/17.
 */
public class Board {
    int[][] board = new int[6][7]; //row then column
    String blue = (char)27 + "[31m";
    String red = (char)27 + "[34m";
    String white = (char)27 + "[38m";

    public Board(){

    }

    public void place(int col, boolean player){
        try {
            for (int i = 0; i < 7; i++) {
                if(player) {
                    if (i == 6) board[6][col] = 1;
                    else if (board[i][col] != 0) board[i - 1][col] = 1;
                }
                else{
                    if (i == 6) board[6][col] = 2;
                    else if (board[i][col] != 0) board[i - 1][col] = 2;
                }
            }
        }
        catch (Exception e){
            System.out.println("you can't move there");
        }
    }

    //public boolean gameOver(){

    //}

    public void draw(){
        for(int[] row: board){
            for(int piece: row){
                System.out.print("[");
                if(piece == 1) System.out.print(blue + "O");
                else if(piece == 2) System.out.print(red + "O");
                else System.out.print(" ");
                System.out.print("] ");
            }
            System.out.println();
        }
        System.out.println(" 1   2   3   4   5   6   7");
    }
}
