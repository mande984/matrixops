import java.util.Arrays;

/**
 * Matrix is a class that represents each of the matrices as a 2D array and
 * provides useful methods for operations
 */
public class Matrix {
    //Size of the Matrix
    private int rows, columns;

    //Matrix as a 2D array
    private int[][] array;

    /**
     * Matrix is the constructor for the Matrix class; sets the row and column
     * values and initializes the array
     *
     * @param rows    the amount of rows in the Matrix
     * @param columns the amount of columns in the Matrix
     */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        array = new int[rows][columns];
    }

    /**
     * setArray sets a value for the array at location r,c
     *
     * @param r     the row in which to place the value
     * @param c     the column in which to place the value
     * @param value the value to be placed at r,c
     * @throws IndexOutOfBoundsException exception if r,c is outside of the
     *                                   size of the array
     */
    public void setArray(int r, int c, int value) throws IndexOutOfBoundsException {
        try {
            this.array[r][c] = value;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Cannot set value " + value + " at coordinates" +
                    " " + r + "," + c);
        }
    }

    /**
     * getRows is a get method for the private variable rows
     *
     * @return the amount of rows as an int
     */
    public int getRows() {
        return rows;
    }

    /**
     * getColumns is a get method for the private variable columns
     *
     * @return the amount of columns as an int
     */
    public int getColumns() {
        return columns;
    }

    /**
     * scalarMultiply is a method that allows a matrix to be multiplied by a
     * scalar by multiplying each entry by the scalar
     * @param scal the scalar to multiply with, as an int
     * @return the matrix multiplied by the scalar
     */
    //TODO
    public int[][] scalarMultiply(int scal){
        return null;
    }

    /**
     * matrixMultiply is a method that allows the matrix to be multiplied by
     * another matrix
     * @param m the matrix to multiply with
     * @return the product as a matrix
     */
    //TODO
    public int[][] matrixMultiply(Matrix m){
        return null;
    }

    /**
     * transpose is a method to allow the matrix to be transposed by flipping
     * it over its diagonal
     * @return the transpose as a matrix
     */
    //TODO
    public int[][] transpose(){
        return null;
    }

    /**
     * matrixAddition is a method that allows the matrix to be added to
     * another matrix
     * @param m the matrix to be added
     * @return the sum as a matrix
     */
    //TODO
    public int[][] matrixAddition(Matrix m){
        return null;
    }


    /**
     * toString overrides Matrix's toString to make the output look better
     * to the console
     *
     * @return the string formatted
     */
    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        String row;
        for (int[] r : this.array) {
            row = Arrays.toString(r);
            print.append(row);
        }
        assert print.length() != 0: "Matrix is empty";
        return print.toString();
    }

    /**
     * equals overrides Matrix's equals to check for matrix equality,
     * specifically that they are the same size and contain the same members
     *
     * @param o the object to check against
     * @return whether the matrices are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Matrix)) {
            return false;
        }
        Matrix m = (Matrix) o;
        if (m.columns != this.columns || m.rows != this.rows) {
            return false;
        }
        for (int i = 0; i < this.rows; i++) {
            if (m.array[i] != this.array[i]) {
                return false;
            }
        }
        return true;
    }
}
