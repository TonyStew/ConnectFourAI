import java.util.LinkedList;
import java.util.Queue;

import static sun.audio.AudioPlayer.player;

/**
 * Created by birch_000 on 1/15/2017.
 */
public class AI2 {

    public AI2() {

    }

    public int getMove(Board board) {
        int[] solutions = new int[7];
        for (int i = 0; i < 7; i++) {
            Node root = new Node(board.getBoard(), 0, false);
            root.board.place(i, root.player);
            solutions[i] = firstSolution(root);
        }
        return choose(solutions, board);
    }

    private int firstSolution(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            //poll temp from queue
            Node temp = q.poll();
            //check if solved
            if (temp.board.gameOver()) {
                return temp.player ? -temp.depth : temp.depth;
                //return temp.depth;
            }
            //for loop
            for (int i = 0; i < 7; i++) {
                //create Node next
                Node next = new Node(temp.board.getBoard(), temp.depth, !temp.player);
                if(next.player) next.depth++;
                //next.place()
                next.board.place(i, next.player);
                //add next to q
                q.add(next);
            }
        }
        return -1;
    }

    private int choose(int[] solutions, Board board) {
        int choseIndex = 0;
        boolean containsPositive = false;
        for(int n: solutions){
            if(n >= 0) containsPositive = true;
        }
        if(containsPositive) {
            for (int i = 0; i < solutions.length; i++) {
                if (solutions[i] == solutions[choseIndex]) choseIndex = spaceEvaluator(i, board) > spaceEvaluator(choseIndex, board) ? i : choseIndex;
                else if(solutions[choseIndex] < 0 && solutions[i] >= 0) choseIndex = i;
                else if (solutions[i] >= 0 && solutions[i] < solutions[choseIndex]) choseIndex = i;
            }
        }
        else {
            for(int i = 0; i < solutions.length; i++){
                if (solutions[i] == solutions[choseIndex]) choseIndex = spaceEvaluator(i, board) > spaceEvaluator(choseIndex, board) ? i : choseIndex;
                else if(solutions[i] < solutions[choseIndex]) choseIndex = i;
            }
        }
        return choseIndex;
    }


    public int spaceEvaluator(int col, Board board){
        int count = 0;
        int height = 0;
        for (int i = 5; i >= 0; i--) {
            if(board.getBoard()[i][col] == 0){
                height = i;
            }
        }
        for(int row = -3; row <= 3; row++){
            for(int column = -3; column <= 3; column++){
                if(height + row >= 0 && height + row <= 5 && col + column >= 0 && col + column <= 6 && board.getBoard()[height + row][col + column] == 0) count++;
            }
        }
        return count;
    }
}
