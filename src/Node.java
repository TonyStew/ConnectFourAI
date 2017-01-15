/**
 * Created by root on 1/15/17.
 */
public class Node {
    public Board board;
    public int depth;

    public Node(int[][] board, int depth){
        this.board = new Board(board);
        this.depth = depth;
    }
}
