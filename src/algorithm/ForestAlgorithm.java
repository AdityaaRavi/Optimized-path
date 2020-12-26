package algorithm;

import java.util.ArrayList;

public class ForestAlgorithm extends Algorithm {

    int boardWidth;
    int boardHeight;
    public ForestAlgorithm(char[][] board, int startX, int startY) {
        super(board, startX, startY);
        this.boardHeight = board.length;
        this.boardWidth = board[0].length;
    }

    @Override
    ArrayList<Integer[]> getPossibleMovements() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    boolean reachedEnd(int currX, int currY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    boolean isBranchDead(int current_num_occur) {
        // TODO Auto-generated method stub
        return false;
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
