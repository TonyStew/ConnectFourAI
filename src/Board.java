/**
 * Created by root on 1/14/17.
 */
public class Board {
    int[][] board = new int[6][7];
    String blue = (char)27 + "[31m";
    String red = (char)27 + "[34m";
    String white = (char)27 + "[38m";

    public Board(){
        setup();
    }

    private void setup(){
        for(int[] row: board){
            for(int piece: row){
                piece = 0;
            }
        }
    }

    /*public boolean place(int cord, boolean player){
        for(int[] row: board){

        }
    }

    public boolean gameOver(){

    } */

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
    }
}
