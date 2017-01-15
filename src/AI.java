import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Created by birch_000 on 1/14/2017.
 */
public class AI {

    public AI() {

    }

    private int evaluateMove(int col, int[][] board){
        int height = 0;
        int series = 0;
        int total = 0;
        for (int i = 0; i < 6; i++) {
            if(board[i][col] != 0) {
                height = i;
                break;
            }
        }

        for(int i = -3; i <= 3; i++){
            if(height + i >= 0 && height + i <= 5 && col + i >= 0 && col + i <= 6) {
                if (board[height + i][col + i] == 2) series++;
                //if (board[height + i][col + i] == 2) total++;
                if (series == 4) total += Integer.MAX_VALUE;
                if (board[height + i][col + i] == 1) series = 0;
            }
        }


        total += series * 3;
        series = 0;

        for(int i = -3; i <= 3; i++){
            if(height - i >= 0 && height - i <= 5 && col + i >= 0 && col + i <= 6) {
                if (board[height - i][col + i] == 2) series++;
                //if (board[height - i][col + i] == 2) total++;
                if (series == 4) total += Integer.MAX_VALUE;
                if (board[height - i][col + i] == 1) series = 0;
            }
        }

        total += series * 3;
        series = 0;

        for(int i = -3; i <= 3; i++){
            if(height + i >= 0 && height + i <= 5) {
                if (board[height + i][col] == 2) series++;
                //if (board[height + i][col] == 2) total++;
                if (series == 4) total += Integer.MAX_VALUE;
                if (board[height + i][col] == 1) series = 0;
            }
        }

        total += series * 3;
        series = 0;

        for(int i = -3; i <= 3; i++){
            if(col + i >= 0 && col + i <= 6) {
                if (board[height][col + i] == 2) series++;
                //if (board[height][col + i] == 2) total++;
                if (series == 4) total += Integer.MAX_VALUE;
                if (board[height][col + i] == 1) series = 0;
            }
        }

        total += series * 3;

        return total;
    }

    //RECURSION:

    public int getMove(Board board) {
        int[] solutions = new int[7];
        outerLoop:
        for (int col = 0; col <= 6; col++) {
            Node root = new Node(board.getBoard(), 0);
            root.board.place(col, root.depth % 2 == 1);
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            while (!q.isEmpty()) {
                Node temp = q.poll();
                for(int i = 0; i < 7; i++) {
                    if (temp.board.getBoard()[0][col] == 0) {
                        temp.board.place(i, temp.depth % 2 == 1);
                        if (temp.board.gameOver()) {
                            solutions[col] = temp.depth % 2 == 1 ? -temp.depth : temp.depth;
                            continue outerLoop;
                        }
                        q.add(new Node(temp.board.getBoard(), temp.depth + 1));
                        temp.board.removePiece(i);
                    } else
                        solutions[col] = - Integer.MAX_VALUE;
                }
            }
        }
        int choice = Integer.MAX_VALUE;
        boolean atLeastOneHigh = false;
        for (int i = 0; i < solutions.length; i++) {
            if (solutions[i] > 0) atLeastOneHigh = true;
        }
        for(int i = 0; i < solutions.length; i++){
            if(solutions[i] < choice) {
                if (atLeastOneHigh && solutions[i] > 0)
                    choice = i;

                else if (!atLeastOneHigh)
                    choice = i;
            }
        }
        return choice;

        /*
        int choice = Integer.MAX_VALUE;
        boolean atLeastOnePositive = false;
        for (n :)
        */
    }

    /* OLD CODE

    //returns the ShallowRed's choice of movie (0-6)
        //depth is even = AI's move
    public int getMove(Board board, int depth) {
        //m maps col to it's total score
        Map<Integer, Integer> m = new HashMap<>();
        //loops over each of 7 choices to find their max score
        for (int col = 0; col <= 6; col++) {
            //places potential move, evaluates, and removes it
            board.place(col, depth % 2 == 1);
            m.put(col, getMaxValue(board, depth - 1));
            board.removePiece(col);
        }
        //finds key with highest value (score for that move) and returns it
        int maxKey = 0;
        for (int key : m.keySet()) {
            if (m.get(key) >= m.get(maxKey))
                maxKey = key;
        }
        return maxKey;
    }

    private int getMaxValue(Board board, int depth) {
        //max = max value of any particular move
        int max = 0;
        for (int col = 0; col <= 6; col++) {
            board.place(col, depth % 2 == 1);
            if (depth == 0)
                max = Math.max(max, evaluateMove(col, board.getBoard()));
            else
                max = Math.max(max, evaluateMove(col, board.getBoard()) + getMaxValue(board, depth - 1));
            board.removePiece(col);
        }
        return max;
    }

    */
}
