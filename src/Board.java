/**
 * Created by root on 1/14/17.
 */
public class Board {
    int[][] board = new int[6][7]; //row then column
    String blue = (char)27 + "[31m";
    String red = (char)27 + "[34m";
    String white = (char)27 + "[38m";

    public Board(int[][] board){
        this.board = board;
    }

    public Board(){
    }

    public int[][] getBoard(){ return board; }

    public void removePiece(int col){
        for (int i = 0; i < 6; i++) {
                if(board[i][col] != 0) {
                    board[i][col] = 0;
                    return;
                }
        }
    }

    public void place(int col, boolean player){
        try {
            for (int i = 5; i >= 0; i--) {
                if(player) {
                    if(board[i][col] == 0){
                        board[i][col] = 1;
                        return;
                    }
                }
                else{
                    if(board[i][col] == 0){
                        board[i][col] = 2;
                        return;
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("you can't move there");
        }
    }

    public boolean gameOver(){
        int series = 0;
        for(int height = 0; height <= 5; height++) {
            for (int col = 0; col <= 6; col++) {//for every piece
                if (board[height][col] != 0) {
                    for (int i = -3; i <= 3; i++) {//starts at 3 to the left and goes to three to the right
                        if (height + i >= 0 && height + i <= 5 && col + i >= 0 && col + i <= 6) {//checks if it is out of bounds
                            if (board[height + i][col + i] == board[height][col]) series++;
                            if (series == 4) return true;
                            if (board[height + i][col + i] != board[height][col]) series = 0;
                        }
                    }

                    series = 0;

                    for (int i = -3; i <= 3; i++) {
                        if (height - i >= 0 && height - i <= 5 && col + i >= 0 && col + i <= 6) {
                            if (board[height - i][col + i] == board[height][col]) series++;
                            if (series == 4) return true;
                            if (board[height - i][col + i] != board[height][col]) series = 0;
                        }
                    }

                    series = 0;

                    for (int i = -3; i <= 3; i++) {
                        if (height + i >= 0 && height + i <= 5) {
                            if (board[height + i][col] == board[height][col]) series++;
                            if (series == 4) return true;
                            if (board[height + i][col] != board[height][col]) series = 0;
                        }
                    }

                    series = 0;

                    for (int i = -3; i <= 3; i++) {
                        if (col + i >= 0 && col + i <= 6) {
                            if (board[height][col + i] == board[height][col]) series++;
                            if (series == 4) return true;
                            if (board[height][col + i] != board[height][col]) series = 0;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void draw(){
        for(int[] row: board){
            for(int piece: row){
                System.out.print(white + "[");
                if(piece == 1) System.out.print(blue + "O");
                else if(piece == 2) System.out.print(red + "O");
                else System.out.print(" ");
                System.out.print(white + "] ");
            }
            System.out.println();
        }
        System.out.println(" 1   2   3   4   5   6   7");
    }

    public String toString() {
        String temp = "";
        for (int[] row : board) {
            for (int piece : row) {
                temp += (white + "[");
                if (piece == 1) temp += (blue + "O");
                else if (piece == 2) temp += (red + "O");
                else temp += (" ");
                temp += (white + "] ");
            }
            temp += "\n";
        }
        temp += (" 1   2   3   4   5   6   7");
        return temp;
    }
}
