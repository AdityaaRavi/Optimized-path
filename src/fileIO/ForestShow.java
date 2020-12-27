package fileIO;

import java.util.ArrayList;

import algorithm.Algorithm;

public class ForestShow extends Show {

    public ForestShow(String fileName) {
        super(fileName);
    }

    @Override
    public int formatAndPrint(Algorithm a, boolean printToStdout) {
        String printme = "";
        ArrayList<Integer[]> coordinates = new ArrayList<Integer[]>();
        coordinates.add(new Integer[]{a.getStartX(), a.getStartY()});
        int i = 0;
        for(Integer[] arr : a.getBestPathCopy()) 
            coordinates.add(new Integer[]{coordinates.get(i)[0] + arr[0], 
                coordinates.get(i++)[1] + arr[1]});
        char[][] board = a.getBoardCopy();
        for(Integer[] e : coordinates) board[e[1]][e[0]] = 'V';
        printme += "Legend:\n'V' = Visited\n'#' = obstacle\n'=' = empty space\n";
        printme += "In the best path found:\n"
            + "Number of places visited: " + coordinates.size() + "\n";
        printme += "Number of obstacles encountered: " + a.getBestNumOccur();
        printme += "Coordinates visited: ";
        for(Integer[] e : coordinates) printme += " (x=" + e[0] + ", y=" + e[1] + ")";
        printme += "\nThe whole board:\n\n";
        for(int j = 0; j < board.length; j++) printme += board[j].toString() + "\n";

        if(printToStdout) System.out.println(printme);
        
        return printToFile(printme); 
    }
    
}
