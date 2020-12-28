package algorithm;

import java.util.ArrayList;

public abstract class Algorithm {
    //class fields
    private char[][] board;
    private int startX;
    private int startY;
    protected boolean calcRan;
    
    
    ////////////////////////////////////////////////////////// data of best path
    private int best_num_occur = Integer.MAX_VALUE;
    private ArrayList<Integer[]> best_path = new ArrayList<Integer[]>();
    ////////////////////////////////////////////////////////// constants
    private final int DEAD_PATH = -1;
    private final int PATH_FOUND = 1;
    ///////////////////////////////////////////////possible movements that can be enacted in each iteration.
    ArrayList<Integer[]> possibleMovements;

    /////////////////constructor
    public Algorithm(char[][] board, int startX, int startY){
        this.board = board;
        this.startX = startX;
        this.startY = startY;
        this.calcRan = false;
    }
    protected void setPossibleMovements(ArrayList<Integer[]> poss){
        possibleMovements = poss;
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
        this.calcRan = true;
        if(reachedEnd(currX, currY)){
            updateIfBetterPathFound(current_num_occur, curr_path);
           // System.out.println(PATH_FOUND);
            //System.out.println("Reached end");
            return PATH_FOUND;
        }
        //Base case 2
        if(isBranchDead(current_num_occur)){
            // System.out.println(DEAD_PATH);
            //System.out.println("Dead branch");
            return DEAD_PATH;
        }
        //Base case 3 ////////////////////////// UPDATE README.md ABOUT THIS!!!!!!!
        if(best_num_occur == 0) return PATH_FOUND;
        
        
        //main case
        curr_path.add(new Integer[]{currX, currY});
        for(Integer[] pos : possibleMovements){
            int toPassNumOccur = updateNumOccur(current_num_occur, board[currY][currX]);
            int nextX = currX + pos[0];
            int nextY = currY + pos[1];
            if(!outOfBounds(nextX, nextY)){
                calculate(nextX, nextY, toPassNumOccur, curr_path);
                //System.out.println("NextX=" + nextX + ", nextY=" + nextY + ", curr num occur: " + current_num_occur + 
                  //  ", Best num occur: " + best_num_occur);
            }
        }
        //System.out.println("==================================================");
        return PATH_FOUND;
    }

    /**
     * Out of bounds check to be performed by the child class.
     * @param currX The X position to check
     * @param currY The Y position to check
     * @return true if outOfBounds, false otherwise
     */
    abstract boolean outOfBounds(int currX, int currY);

    /**
     * abstract method to get all possible movements in the current board being
     * tested.
     * 
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
     * Returns the a copy of the best path.
     * @return null if calcute() was never called, copy of ArrayList<Integer[]> best_path if it was run.
     */
    public ArrayList<Integer[]> getBestPathCopy(){
        if(calcRan) return (ArrayList<Integer[]>) best_path.clone();
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
     * Sets the number of occurances of the variable you wanted to optimize for in the best path
     * @param occur The number to set the value of best path too.
     * @return the value set to best num occur.
     */
    protected int setBestNumOccur(int occur){
        return best_num_occur = occur; 
    }

    /**
     * Use method to change the path that best path refers to.
     * @param path The path that best path must be changed to.
     * @return The path that was just set as the best path.
     */
    protected ArrayList<Integer[]> setBestPath(ArrayList<Integer[]> path) {
        return best_path = path;
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
