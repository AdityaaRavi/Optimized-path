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
            this.speed = speed;
            System.out.println(speed);
            return (this.speed = speed);
        }
        else throw new IllegalArgumentException("Speed must be at least 2."); 
    }

    @Override
    ArrayList<Integer[]> getPossibleMovements() {
        ArrayList<Integer[]> movements = new ArrayList<Integer[]>();
        setSpeed(5);
        for(int dy = 1; dy < this.speed; dy++){
            movements.add(new Integer[]{this.speed - dy, dy});
            //System.out.println("NextX=" + (this.speed-dy) + ", nextY=" + dy);
        }
        //System.out.println("==================================================");
        //for(Integer[] w : movements) System.out.println("movement: X=" + w[0] + ", nextY=" + w[1]); 
        return movements;
    }

    @Override
    boolean reachedEnd(int currX, int currY) {
        //System.out.printf("============ Y: %d, HEIGHT: %d\n", currY, boardHeight);
        return currY >= boardHeight;
    }

    @Override
    boolean isBranchDead(int current_num_occur) {
       // System.out.printf("============ CURR: %d, BEST: %d\n", current_num_occur, getBestNumOccur());
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
        System.out.println("==============================    CHAR: " + current_char + ", NUM_OCC: " + current_num_occur);
        if(current_char == OBSTACLE_CHAR){
            ++current_num_occur;
            System.out.println("==============================   NUM_OCC: " + current_num_occur);
            return current_num_occur; // ++current_num_occur;
        } 
        return current_num_occur;
    }

    @Override
    boolean outOfBounds(int currX, int currY) {
        if(currX >= boardWidth /*|| currY >= boardHeight*/) return true;
        return false;
    }

}
