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
            }
        }
        for(int i = -3; i <= 3; i++){
            if(board[height + i][col + i] == 2) series++;
            if (series == 4) total += series * 3;
            if(board[height + i][col + i] == 1) series = 0;
        }

        total += series * 3;
        series = 0;

        for(int i = -3; i <= 3; i++){
            if(board[height - i][col + i] == 2) series++;
            if (series == 4) total += series * 3;
            if(board[height - i][col + i] == 1) series = 0;
        }

        total += series * 3;
        series = 0;

        for(int i = -3; i <= 3; i++){
            if(board[height + i][col] == 2) series++;
            if (series == 4) total += series * 3;
            if(board[height + i][col] == 1) series = 0;
        }

        total += series * 3;
        series = 0;

        for(int i = -3; i <= 3; i++){
            if(board[height][col + i] == 2) series++;
            if (series == 4) total += series * 3;
            if(board[height][col + i] == 1) series = 0;
        }

        total += series * 3;

        return total;
        }

    }

}
