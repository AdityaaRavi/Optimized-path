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
        return 0;
    }
    
}
