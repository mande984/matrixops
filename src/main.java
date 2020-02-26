import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.util.Pair;

public class main {
    public static void main(String[] args) {
        Matrix empty = new Matrix(4,4);
        empty.emptyArray();

        //Randomly populated arrays will be populated by integers from 0-10
        Matrix [] oneRow = new Matrix[4];
        Matrix [] twoRow = new Matrix[4];
        Matrix [] threeRow = new Matrix[4];
        Matrix [] fourRow = new Matrix[4];

        oneRow = populateMatrices(oneRow, 1);
        twoRow = populateMatrices(twoRow, 2);
        threeRow = populateMatrices(threeRow, 3);
        fourRow = populateMatrices(fourRow, 4);

        //TODO: Write tests for Matrix functions
    }

    public static Matrix[] populateMatrices(Matrix [] m, int row){
        for (int col = 0; col < 4; col++){
            m[col] = new Matrix(row, col+1);
            m[col].randomPopulate();
        }
        return m;
    }
}
