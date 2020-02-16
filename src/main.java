import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.util.Pair;

public class main {

    /**
     * Option for inputting the matrix or matrices through file input. File
     * must be in format:
     *  Number of Arrays
     *  Array 1 Size
     *  Array 2 Size (if none, size = 0)
     *  Array 1, separated by spaces
     *  Array 2, seperated by spaces
     * @param fname the name of the input file
     * @return the created 2d arrays from the file
     */
    private Pair<int[][], int[][]> readInputFile(String fname){
        //TODO: Insert functionality to read through a file in correct format
        try{
            BufferedReader read = new BufferedReader(new FileReader(fname));
            String line = read.readLine();
            while (line != null){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) {
    }
}
