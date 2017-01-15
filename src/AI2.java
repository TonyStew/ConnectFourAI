import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by birch_000 on 1/15/2017.
 */
public class AI2 {

    public AI2() {

    }

    public int getMove(Board board) {
        int[] solutions = new int[7];
        for (int i = 0; i < 7; i++) {
            Node root = new Node(board.getBoard(), 0);
            root.board.place(i, false);
            solutions[i] = firstSolution(root);
        }
        return choose(solutions);
    }

    private int firstSolution(Node root) {
        boolean solutionFound = false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current.board.gameOver())
                return current.depth % 2 == 0 ? current.depth : -current.depth;
            for (int i = 0; i < 7; i++) {
                Node next = new Node(current.board.getBoard(), current.depth + 1);
                q.add(next);
            }
        }
        return -420;
    }

    private int choose(int[] solutions) {
        int choseIndex = 0;
        boolean containsPositive = false;
        for(int i: solutions){
            if(i >= 0) containsPositive = true;
        }
        if(containsPositive) {
            for (int i = 0; i < solutions.length; i++) {
                if (solutions[i] < solutions[choseIndex] && solutions[i] >= 0) choseIndex = i;
            }
        }
        else {
            for(int i = 0; i < solutions.length; i++){
                if(solutions[i] < solutions[choseIndex]) choseIndex = 1;
            }
        }
        return choseIndex;
    }

}
