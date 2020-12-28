package fileIO;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public abstract class Ingest {
    //fields
    protected String fileName;
    protected File fileHandler;
    protected Scanner fileScanner;

    public Ingest(){
        this.fileName = "data/ignore.txt"; //"data/non-human-friendly-1.txt";
        fileHandler = new File(fileName);
        try{
            fileScanner = new Scanner(fileHandler);
        }catch(FileNotFoundException e){
            System.out.println("The file\" "+ this.fileName +"\" was not found!");
            System.exit(1);
        }
    }

    public Ingest(String fileName){
        this.fileName = fileName;
        fileHandler = new File(fileName);
        try{
            fileScanner = new Scanner(fileHandler);
        }catch(FileNotFoundException e){
            System.out.println("The file\" "+ this.fileName +"\" was not found!");
            System.exit(1);
        }
    }

    public abstract char[][] getBoard();
}
