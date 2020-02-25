import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.util.Pair;

public class main {
    public static void main(String[] args) {
        Matrix m = new Matrix(2, 2);
        Matrix m2 = new Matrix(3, 2);
        m.randomPopulate();
        m2.randomPopulate();
        try {
            Matrix m3 = m.matrixMultiply(m2);
            System.out.println("1st Array: \n" + m.toString());
            System.out.println("2nd Array: \n" + m2.toString());
            System.out.println("Solution: \n" + m3.toString());
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }

    }
}
