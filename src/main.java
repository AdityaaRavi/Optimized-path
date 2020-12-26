// importing relevant files and libraries

import fileIO.*;

import java.util.ArrayList;

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
        Algorithm forest = new ForestAlgorithm(board, 0, 0);
        //run the algorithm
        forest.calculate();
        //getting the results of the algorithm.
        ArrayList<Integer[]> result = forest.getBestPath();
        //Create a new Show class object that prints out the path as both the (dx, dy) and on the map as well.
        



    }
}