/**
 * Created by birch_000 on 1/14/2017.
 */
public class AI {

    public AI() {

    }

    public int getAIMove(Board board, int depth) {
        //depth is even = AI's move
        for (int col = 0; col <= 6; col++) {
            board.place(col, depth % 2 == 1);
            //TODO: recursion
            board.
        }
    }
}
