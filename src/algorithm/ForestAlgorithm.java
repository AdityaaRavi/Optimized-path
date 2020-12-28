package algorithm;

import java.util.ArrayList;

public class ForestAlgorithm extends Algorithm {

    final char OBSTACLE_CHAR = '#';
    int boardWidth;
    int boardHeight;
    int speed = 5; // The number of boxes that MUST be traversed at anytime.
    
    public ForestAlgorithm(char[][] board, int startX, int startY, int speed) {
        super(board, startX, startY);
        this.boardHeight = board.length;
        this.boardWidth = board[0].length;
        setSpeed(speed);
    }

    public int setSpeed(int speed){
        if(speed > 1){
            calcRan = false;
            //System.out.println("Speed set to: " + speed);
            return (this.speed = speed);
        }
        else throw new IllegalArgumentException("Speed must be at least 2."); 
    }

    @Override
    ArrayList<Integer[]> getPossibleMovements() {
        ArrayList<Integer[]> movements = new ArrayList<Integer[]>();
        System.out.println("Speed:" + speed);
        for(int dy = 1; dy <= this.speed; dy++){
            movements.add(new Integer[]{this.speed - dy, dy});
            System.out.println("NextX=" + (this.speed-dy) + ", nextY=" + dy);
        }
        //for(Integer[] w : movements) System.out.println("movement: X=" + w[0] + ", nextY=" + w[1]); 
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
        if(getBestPathCopy().size() == 0 || current_num_occur < getBestNumOccur()){
            setBestPath(curr_path);
            setBestNumOccur(current_num_occur);
            return true;
        }

        return false;
    }

    @Override
    int updateNumOccur(int current_num_occur, char current_char) {
        if(current_char == OBSTACLE_CHAR) return ++current_num_occur;
        return current_num_occur;
    }

    @Override
    boolean outOfBounds(int currX, int currY) {
        if(currX >= boardWidth || currY >= boardHeight) return true;
        return false;
    }

}
