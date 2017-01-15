import java.util.HashMap;
import java.util.Map;

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
                if (series == 4) total += series * 3;
                if (board[height + i][col + i] == 1) series = 0;
            }
        }

        total += series * 3;
        series = 0;

        for(int i = -3; i <= 3; i++){
            if(height - i >= 0 && height - i <= 5 && col + i >= 0 && col + i <= 6) {
                if (board[height - i][col + i] == 2) series++;
                if (series == 4) total += series * 3;
                if (board[height - i][col + i] == 1) series = 0;
            }
        }

        total += series * 3;
        series = 0;

        for(int i = -3; i <= 3; i++){
            if(height + i >= 0 && height + i <= 5) {
                if (board[height + i][col] == 2) series++;
                if (series == 4) total += series * 3;
                if (board[height + i][col] == 1) series = 0;
            }
        }

        total += series * 3;
        series = 0;

        for(int i = -3; i <= 3; i++){
            if(col + i >= 0 && col + i <= 6) {
                if (board[height][col + i] == 2) series++;
                if (series == 4) total += series * 3;
                if (board[height][col + i] == 1) series = 0;
            }
        }

        total += series * 3;

        return total;
    }

    public int getMove(Board board, int depth) {
        //depth is even = AI's move
        Map<Integer, Integer> m = new HashMap<>();
        for (int col = 0; col <= 6; col++) {
            board.place(col, depth % 2 == 1);
            m.put(col, getMaxValue(board, depth - 1));
            board.removePiece(col);
        }
        int maxKey = 0;
        for (int key : m.keySet()) {
            if (m.get(key) >= m.get(maxKey))
                maxKey = key;
        }
        return maxKey;
    }

    private int getMaxValue(Board board, int depth) {
        int max = 0;
        for (int col = 0; col <= 6; col++) {
            board.place(col, depth % 2 == 1);
            if (depth == 0)
                max = Math.max(max, evaluateMove(col, board.getBoard()));
            else {
                max = Math.max(max, evaluateMove(col, board.getBoard()) + getMaxValue(board, depth - 1));
            }
            board.removePiece(col);
        }
        return max;
    }

}
