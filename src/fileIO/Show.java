package fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import algorithm.Algorithm;

public abstract class Show {
    //fields
    private Path fileHandler;

    public Show(String fileName){
        this.fileHandler = Path.of(fileName);
    }
    
    abstract int formatAndPrint(Algorithm a, boolean printToStdout);

    public int printToFile(String s){
        try{
            Files.writeString(fileHandler, s);
            return 0;
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }
}
