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
        Matrix m = new Matrix(2,2);
        Matrix m2 = new Matrix(2, 2);
        m.randomPopulate();
        m2.randomPopulate();
        try {
            Matrix m3 = m.matrixMultiply(m2);
            System.out.println("1st Array: \n" + m.toString());
            System.out.println("2nd Array: \n" + m2.toString());
            System.out.println("Solution: \n" + m3.toString());
        } catch (MatrixException e){
            System.out.println(e.getMessage());
        }

    }
}
