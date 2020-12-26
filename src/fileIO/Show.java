package fileIO;

import java.io.File;

import algorithm.Algorithm;

public abstract class Show {
    //fields
    private String fileName;
    private File fileHandler;

    public Show(String fileName){
        this.fileName = fileName;
        this.fileHandler = new File(fileName);
    }
    
    abstract int formatAndPrint(Algorithm a, boolean printToStdout);

    public int printToFile(String s){
        return -1;
    }
}
