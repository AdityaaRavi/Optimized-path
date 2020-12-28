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
        
        //finding out the coordinates visited based on the dx and dy taken in each step 
        //ArrayList<Integer[]> coordinates = new ArrayList<Integer[]>();
        //coordinates.add(new Integer[]{a.getStartX(), a.getStartY()});
        //int i = 0;
        //System.out.println(a + ", coordinates: x="  + coordinates.get(0)[0] + ", y=" + coordinates.get(0)[1]);
        // for(Integer[] arr : a.getBestPathCopy()){ 
        //     coordinates.add(new Integer[]{coordinates.get(i)[0] + arr[0], coordinates.get(i++)[1] + arr[1]});
        //     System.out.println("coordinates: x="  + coordinates.get(coordinates.size() - 1)[0] + ", y=" + coordinates.get(coordinates.size() - 1)[1]);
        // }
                
        char[][] board = a.getBoardCopy();
        
        /////////////////////////// steping through each of the coordinates thus found and marking it up on a copy of the board.
        //for(Integer[] e : coordinates) board[e[1]][e[0]] = 'V';
        for(Integer[] e : a.getBestPathCopy()) board[e[1]][e[0]] = 'V';
        //////////////////////////////////////////////////////////////// printing out some useful data
        printme += "Legend:\n\n'V' = Visited\n'#' = obstacle\n'=' = empty space\n\n";
        printme += "In the best path found:\n\n"
            + "Number of places visited: " + a.getBestPathCopy().size() + "\n";
        printme += "Number of obstacles encountered: " + a.getBestNumOccur();
        
        //////////////////////////////////////////////////////// printing out the actual number of all the coordinates visited.
        printme += "\nCoordinates visited: ";
        int i = 0;
        for(Integer[] e : a.getBestPathCopy()) printme += " (x=" + e[0] + ", y=" + e[1] + ")" + (i++ % 5 == 0 ? "\n" : "");
        
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
