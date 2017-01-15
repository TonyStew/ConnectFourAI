/**
 * Created by birch_000 on 1/15/2017.
 */
public class AI2 {

    public AI2() {

    }

    public int getMove(Board board) {

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
