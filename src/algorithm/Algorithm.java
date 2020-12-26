package algorithm;

import java.util.ArrayList;

public abstract class Algorithm {
    //class fields
    private char[][] board;
    private int startX;
    private int startY;
    private boolean calcRan;
    // (DON'T NEED THIS ANYMORE) /////////////////////////////////////////////////////////// current data CHANGE ------ ALL MUST BE LOCAL VARIABLES!!!!
    // int current_num_occur = 0;
    // ArrayList<Integer[]> curr_path = new ArrayList<Integer[]>();
    
    ////////////////////////////////////////////////////////// data of best path
    private int best_num_occur = Integer.MAX_VALUE;
    private ArrayList<Integer[]> best_path = new ArrayList<Integer[]>();
    ////////////////////////////////////////////////////////// constants
    private final int DEAD_PATH = -1;
    private final int PATH_FOUND = 1;
    ///////////////////////////////////////////////possible movements that can be enacted in each iteration.
    ArrayList<Integer[]> possibleMovements = getPossibleMovements();

    /////////////////constructor
    public Algorithm(char[][] board, int startX, int startY){
        this.board = board;
        this.startX = startX;
        this.startY = startY;
        this.calcRan = false;
    }
    /**
     *  The actual recursive method that carries out all the iterations.
     * @param current_num_occur 0 for first call, number of steps till now for recursive calls
     * @param curr_path empty ArrayList<Integer[]> in first call, an ArrayList of the same type 
     *                  will all movements taken till now for recursive calls.
     * @return dead_path or path_found token
     */
    public int calculate(int currX, int currY, int current_num_occur, ArrayList<Integer[]> curr_path){
        //Base case 1
        if(reachedEnd(currX, currY)){
            updateIfBetterPathFound(current_num_occur, curr_path);
            return PATH_FOUND;
        }
        //Base case 2
        if(isBranchDead(current_num_occur)){
            return DEAD_PATH;
        }
        
        //main case
        for(Integer[] pos : possibleMovements) calculate(pos[0], pos[1], updateNumOccur(current_num_occur, board[currY][currX]), curr_path);

        return PATH_FOUND;
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
    abstract boolean isBranchDead(int current_num_occur);
    
    /** update best_num_occur and best_path if a better path is found.
     * @return true/false to denote if a better path was found or not respectively.
    */
    abstract boolean updateIfBetterPathFound(int current_num_occur, ArrayList<Integer[]> curr_path);
    /**
     * Update num_occur
     * @return returns the updated num_occur value based on the current character.
     */
    abstract int updateNumOccur(int current_num_occur, char current_char);
    /////////////////////////////////////////////////// getters and setters.
    /**
     * Returns the value of the best path.
     * @return null if calcute() was never called, ArrayList<Integer[]> best_path if it was run.
     */
    public ArrayList<Integer[]> getBestPath(){
        if(calcRan) return best_path;
        else return null;
    }
    /**
     * Gets the number of occurances of the variable you wanted to optimize for in the best path
     * @return Best path num occurances/ -1 if calculate() was never run.
     */
    public int getBestNumOccur(){
        if(calcRan) return best_num_occur;
        else return -1;
    }
    /**
     * Gets the start X value of this instance of the algorithm.
     * @return Start X value
     */
        public int getStartX() {
		return startX;
    }
    /**
     * Gets the start Y value of this instance of algorithm
     * @return Start Y value
     */
	public int getStartY() {
		return startY;
    }

    /**
     * Returns a copy of the board.
     * @return char[][] copy of the board.
     */
    public char[][] getBoardCopy(){
        return board.clone();
    }

}
