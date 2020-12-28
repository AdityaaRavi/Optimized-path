// importing relevant files and libraries

import fileIO.*;

import java.util.ArrayList;

import algorithm.*;

public class Runner{

    public static void main(String[] args){
        // get the board as a char[][] using the ingest class.
        char[][] board;
        String outputPath = "data/output.txt";
        // use try/catch to use the file name given as a parameter or call the default constructor for the ingest class.
        try{
            board = (new IngestForest(args[0])).getBoard();
            outputPath = args[1];
        }catch(IndexOutOfBoundsException e){
            board = (new IngestForest()).getBoard();
        }
        
        // Creating an object of the algorithm class
        Algorithm forest = new ForestAlgorithm(board, 0, 0, 3);
        
        //run the algorithm
        forest.calculate(forest.getStartX(), forest.getStartY(), 0, new ArrayList<Integer[]>());
        
        //getting the results of the algorithm. (Not needed if you use a class that extends the Show class)
        //ArrayList<Integer[]> result = forest.getBestPath();
        
        //Create a new Show class object that prints out the path as both the (dx, dy) and on the map as well.
        (new ForestShow(outputPath)).formatAndPrint(forest, true);


    }
}