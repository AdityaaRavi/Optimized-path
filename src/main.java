// importing relevant files and libraries

import fileIO.*;
import algorithm.*;

public class Main{

    public static void main(String[] args){
        // get the board as a char[][] using the ingest class.
        char[][] board;

        // use try/catch to use the file name given as a parameter or call the default constructor for the ingest class.
        try{
            board = (new IngestForest(args[0])).getBoard();
        }catch(IndexOutOfBoundsException e){
            board = (new IngestForest()).getBoard();
        }
        
        // Creating an object of the algorithm class
        


    }
}