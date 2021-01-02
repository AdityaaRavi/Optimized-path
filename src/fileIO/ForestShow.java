package fileIO;

import java.util.ArrayList;

import algorithm.Algorithm;

public class ForestShow extends Show<Character> {

    public ForestShow(String fileName) {
        super(fileName);
    }

    @Override
    public int formatAndPrint(Algorithm<Character> a, boolean printToStdout) {
        String printme = "";
                
        Character[][] board = (Character[][]) (a.getBoardCopy());
        
        /////////////////////////// steping through each of the coordinates thus found and marking it up on a copy of the board.

        for(Integer[] e : a.getBestPathCopy()) board[e[1]][e[0]] = board[e[1]][e[0]] == '#' ? 'B' : 'V';
        
        //////////////////////////////////////////////////////////////// printing out some useful data
        
        printme += "Legend:\n\n'V' = Visited empty space\n'B' = Visited obstacle\n'#' = obstacle, but not visited\n'=' = empty space not visited\n\n";
        printme += "In the best path found:\n\n"
            + "Number of places visited: " + a.getBestPathCopy().size() + "\n";
        printme += "Number of obstacles encountered: " + a.getBestNumOccur();
        printme += "\n\nCoordinates visited: ";
        int i = 0;
        for(Integer[] e : a.getBestPathCopy()) printme += (i++ % 5 == 0 ? "\n" : "") + " (x=" + e[0] + ", y=" + e[1] + ")";
        
        /////////////////////////////////////////////////////////printing out the whole board
        printme += "\n\nThe whole board:\n\n";
        for(int j = 0; j < board.length; j++) {
            for(int k = 0; k < board[j].length; k++) printme += board[j][k] + " ";
            printme += "\n";
        } 

        // printing to stdin too if requested.
        if(printToStdout) System.out.println(printme);
        
        return printToFile(printme); 
    }
    
}
