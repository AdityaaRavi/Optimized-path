package algorithm;

import java.util.ArrayList;

public abstract class Algorithm {
    //class fields
    char[][] board;
    // current data
    int current_num_occur;
    ArrayList<Integer[]> curr_path;
    // data of best path
    int best_num_occur;
    ArrayList<Integer[]> best_path;
    // constants
    final int DEAD_PATH = -1;
    final int PATH_FOUND = 1;

    //constructor
    public Algorithm(char[][] board){
        this.board = board;
        
    }
    
    public int calculate(){

        return 0;
    }



}
