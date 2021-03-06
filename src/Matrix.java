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
     */
    public void setArray(int r, int c, int value) {
        this.array[r][c] = value;
    }

    /**
     * emptyArray is a method for testing that sets a matrix's contents to 0
     */
    public void emptyArray() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.setArray(i, j, 0);
            }
        }
    }

    /**
     * randomPopulate is a method used for testing that uses Math.random() to
     * populate the matrix with numbers from 0-10
     */
    public void randomPopulate() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.setArray(i, j, ((int) (Math.random() * (10))));
            }
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
     * getValue is a get method for the value at location (r,c)
     *
     * @param row    the row of the value
     * @param column the column of the value
     * @return the value as an int
     */
    public int getValue(int row, int column) {
        return this.array[row][column];
    }

    /**
     * scalarMultiply is a method that allows a matrix to be multiplied by a
     * scalar by multiplying each entry by the scalar
     *
     * @param scal the scalar to multiply with, as an int
     * @return the matrix multiplied by the scalar
     */
    public Matrix scalarMultiply(int scal) {
        Matrix solution = new Matrix(this.rows, this.columns);
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.columns; c++) {
                int val = this.getValue(r, c);
                solution.setArray(r, c, val * scal);
            }
        }
        return solution;
    }

    /**
     * matrixMultiply is a method that allows the matrix to be multiplied by
     * another matrix
     *
     * @param m the matrix to multiply with
     * @return the product as a matrix
     * @throws MatrixException if the matrices cannot be multiplied together
     */
    public Matrix matrixMultiply(Matrix m) throws MatrixException {
        //Checking if the matrices can be multiplied
        if (this.columns != m.rows) {
            throw new MatrixException("Matrices cannot be multiplied! The " +
                    "amount of columns in the first matrix must be equal to " +
                    "the amount of rows in the second!");
        }
        Matrix solution = new Matrix(this.rows, m.columns);
        int sum = 0;
        //Loop through the first matrix's rows
        for (int i = 0; i < this.rows; i++) {
            //Loop through the second matrix's columns
            for (int j = 0; j < m.columns; j++) {
                //Loop through the second matrix's rows
                for (int k = 0; k < m.rows; k++) {
                    sum += this.getValue(i, k) * m.getValue(k, j);
                }
                solution.setArray(i, j, sum);
                sum = 0;
            }
        }

        return solution;
    }

    /**
     * transpose is a method to allow the matrix to be transposed by flipping
     * it over its diagonal
     *
     * @return the transpose as a matrix
     */
    public Matrix transpose() {
        Matrix solution = new Matrix(this.columns, this.rows);
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                solution.setArray(col, row, this.getValue(row, col));
            }
        }
        return solution;
    }

    /**
     * matrixAddition is a method that allows the matrix to be added to
     * another matrix
     *
     * @param m the matrix to be added
     * @return the sum as a matrix
     * @throws MatrixException if the matrices cannot be added together
     */
    public Matrix matrixAddition(Matrix m) throws MatrixException {
        //Checking if the matrices can be added
        if (m.rows != this.rows || m.columns != this.columns) {
            throw new MatrixException("To add matrices, they must be the same" +
                    " size.");
        }

        Matrix solution = new Matrix(this.rows, this.columns);
        int value;
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                value = this.getValue(row, col) + m.getValue(row, col);
                solution.setArray(row, col, value);
            }
        }

        return solution;
    }

    /**
     * det is a method that finds the determinant of the matrix
     *
     * @return the determinant of the matrix
     * @throws MatrixException if the matrix is not square
     */
    public int det() throws MatrixException {
        if (this.rows != this.columns) {
            throw new MatrixException("Cannot find the determinant of this " +
                    "matrix! To find the determinant, the matrix must be " +
                    "square (rows = columns!");
        }
        if (this.rows == 2) {
            return leibniz(this);
        }
        if (this.rows == 3) {
            return laplace(this);
        }
        //TODO: Create recursive way to get matrices down to 4x4 and then
        // throw them back up using laplace function
        return 0;
    }

    /**
     * leibniz is a method that returns the determinant of a 2x2 matrix using
     * the form ad-bc
     *
     * @param m the matrix to find the determinant of
     * @return the determinant
     */
    public int leibniz(Matrix m) {
        int ad = (m.getValue(0, 0) * m.getValue(1, 1));
        int bc = (m.getValue(0, 1) * m.getValue(1, 0));
        return ad - bc;
    }

    /**
     * laplace is a method that returns the determinant of a 3x3 matrix using
     * the form aei + bfg + cdh - ceg - bdi - afh
     *
     * @param m the matrix to find the determinant of
     * @return the determinant
     */
    public int laplace(Matrix m) {
        int a = m.getValue(0, 0);
        int b = m.getValue(0, 1);
        int c = m.getValue(0, 2);
        int d = m.getValue(1, 0);
        int e = m.getValue(1, 1);
        int f = m.getValue(1, 2);
        int g = m.getValue(2, 0);
        int h = m.getValue(2, 1);
        int i = m.getValue(2, 2);

        return (a * e * i) + (b * f * g) + (c * d * h) - (c * e * g) - (b * d * i) - (a * f * h);
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
            print.append(row + "\n");
        }
        assert print.length() != 0 : "Matrix is empty";
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
