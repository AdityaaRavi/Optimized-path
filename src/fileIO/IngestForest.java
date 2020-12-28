package fileIO;

import java.util.Scanner;

public class IngestForest extends Ingest{

    public IngestForest(){
        super();
    }

    public IngestForest(String fileName){
        super(fileName);
    }

    @Override
    public char[][] getBoard() {
        if(!fileScanner.hasNextLine()) throw new IllegalArgumentException("The given file is empty!");
        
        // getting the meta data from the first two lines of the input text file.
        Scanner line1 = new Scanner(fileScanner.nextLine()).useDelimiter(":");
        line1.close();
        Scanner line2 = new Scanner(fileScanner.nextLine()).useDelimiter(":");
        //System.out.println(line2.next());
        String l2s = line2.next();
        line2.close();
        line2 = new Scanner(l2s);
        // width and height of the board 
        int width = line2.nextInt();
        int height = line2.nextInt();
        line2.close();

        // processing each line of the file to get all parts of the board.
        char[][] board = new char[height][width];
        int j = 0;
        while(fileScanner.hasNextLine()){
            Scanner line = new Scanner(fileScanner.nextLine());
            for(int i = 0; i < width; i++) board[j][i] = line.next().charAt(0);
            j++;
            line.close();
        }
        fileScanner.close();
        return board;
    }
    
}
