package algorithm;

import java.util.ArrayList;

public abstract class Algorithm {
    //class fields
    char[][] board;
    int startX;
    int startY;
    // current data
    int current_num_occur = 0;
    ArrayList<Integer[]> curr_path = new ArrayList<Integer[]>();
    // data of best path
    int best_num_occur = Integer.MAX_VALUE;
    ArrayList<Integer[]> best_path = new ArrayList<Integer[]>();
    // constants
    final int DEAD_PATH = -1;
    final int PATH_FOUND = 1;
    //possible movements that can be enacted in each iteration.
    ArrayList<Integer[]> possibleMovements = getPossibleMovements();

    //constructor
    public Algorithm(char[][] board, int startX, int startY){
        this.board = board;
        this.startX = startX;
        this.startY = startY;
    }
    
    public int calculate(){

        return 0;
    }

    //abstract method to get all possible movements in the current board being tested.
    abstract ArrayList<Integer[]> getPossibleMovements();
    //abstract method to check if the end condition is reached
    abstract boolean reachedEnd(int currX, int currY);

}
