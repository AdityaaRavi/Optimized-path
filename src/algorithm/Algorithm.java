package algorithm;

import java.util.ArrayList;

public abstract class Algorithm {
    //class fields
    char[][] board;
    int startX;
    int startY;
    boolean calcRan;
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
        this.calcRan = false;
    }
    /**
     *  The actual recursive method that carries out all the iterations.
     * @return dead_path or path_found token
     */
    public int calculate(){

        return 0;
    }

    /**
     * Returns the value of the best path.
     * @return null if calcute() was never called, ArrayList<Integer[]> best_path if it was run.
     */
    public ArrayList<Integer[]> getBestPath(){
        if(calcRan) return best_path;
        else return null;
    }

    /** abstract method to get all possible movements in the current board being tested.
     * @return Array<Integer[]> of all possible movements
    */
    abstract ArrayList<Integer[]> getPossibleMovements();
   
    /**abstract method to check if the end condition is reached
     * @param currX The X position of the current recursive call
     * @param currY The Y positon of the current recursive call
     * @return true/false to denote if the end of the board is reached or not respectively.
     */
    abstract boolean reachedEnd(int currX, int currY);
    
    /** abstract method to check if a branch is dead
     * @return true/false to denote if a branch is dead or not respectively as described in the README.md file.
     */
    abstract boolean isBranchDead(int current_num_occur, int best_num_occur);
    
    /** update best_num_occur and best_path if a better path is found.
     * @return true/false to denote if a better path was found or not respectively.
    */
    abstract boolean updateIfBetterPathFound(int current_num_occur, int best_num_occur, 
        ArrayList<Integer[]> curr_path, ArrayList<Integer[]> best_path);
    

}
