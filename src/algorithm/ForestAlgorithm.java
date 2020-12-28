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
        super.setPossibleMovements(this.getPossibleMovements());
    }

    public int setSpeed(int speed){
        if(speed > 1){
            calcRan = false;
            return this.speed = speed;
        }
        else throw new IllegalArgumentException("Speed must be at least 2."); 
    }

    @Override
    ArrayList<Integer[]> getPossibleMovements() {
        ArrayList<Integer[]> movements = new ArrayList<Integer[]>();
        
        for(int dy = 1; dy < this.speed; dy++){
            movements.add(new Integer[]{this.speed - dy, dy});
            movements.add(new Integer[]{-(this.speed - dy), dy});
        }
        //for(Integer[] w : movements) System.out.println("possible movements: dx=" + w[0] + ", dy=" + w[1]); 
        return movements;
    }

    @Override
    boolean reachedEnd(int currX, int currY) {
        return currY >= boardHeight - 1;
    }

    @Override
    boolean isBranchDead(int current_num_occur) {
        return current_num_occur > getBestNumOccur();
    }

    @Override
    boolean updateIfBetterPathFound(int current_num_occur, ArrayList<Integer[]> curr_path) {
        if(getBestPathCopy().size() == 0 || current_num_occur < getBestNumOccur()){
            super.setBestPath(curr_path);
            super.setBestNumOccur(current_num_occur);
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
        if(currX >= boardWidth || currX < 0) return true;
        return false;
    }

}
