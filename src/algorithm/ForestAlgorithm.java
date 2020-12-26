package algorithm;

import java.util.ArrayList;

public class ForestAlgorithm extends Algorithm {

    int boardWidth;
    int boardHeight;
    int speed; // The number of boxes that MUST be traversed at anytime.
    public ForestAlgorithm(char[][] board, int startX, int startY, int speed) {
        super(board, startX, startY);
        this.boardHeight = board.length;
        this.boardWidth = board[0].length;
        setSpeed(speed);
    }

    public int setSpeed(int speed){
        if(speed > 0){
            calcRan = false;
            return (this.speed = speed);
        }
        else throw new IllegalArgumentException("Speed must be at least 1."); 
    }

    @Override
    ArrayList<Integer[]> getPossibleMovements() {
        ArrayList<Integer[]> movements = new ArrayList<Integer[]>();
        for(int dy = 1, dx = speed - dy; dy <= speed; dy++, dx = speed - dy) movements.add(new Integer[]{dx, dy}); 
        return movements;
    }

    @Override
    boolean reachedEnd(int currX, int currY) {
        return currY >= boardHeight;
    }

    @Override
    boolean isBranchDead(int current_num_occur) {
        return current_num_occur > getBestNumOccur();
    }

    @Override
    boolean updateIfBetterPathFound(int current_num_occur, ArrayList<Integer[]> curr_path) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    int updateNumOccur(int current_num_occur, char current_char) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    boolean outOfBounds(int currX, int currY) {
        if(currX >= boardWidth || currY >= boardHeight) return true;
        return false;
    }

}
