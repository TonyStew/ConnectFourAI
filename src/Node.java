/**
 * Created by root on 1/15/17.
 */
public class Node {
    public Board board;
    public int depth;
    public boolean player;

    public Node(int[][] board, int depth, boolean player){
        this.board = new Board(board);
        this.depth = depth;
        this.player = player;
    }
}
