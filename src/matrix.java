/**
 * Matrix is a class that represents each of the matrices as a 2D array and
 * provides useful methods for operations
 */
public class matrix {
    //Size of the matrix
    private int rows, columns;

    //Matrix as a 2D array
    private int[][] array;

    /**
     * matrix is the constructor for the matrix class; sets the row and column
     * values and initializes the array
     * @param rows the amount of rows in the matrix
     * @param columns the amount of columns in the matrix
     */
    public matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        array = new int[rows][columns];
    }

    /**
     * setArray sets a value for the array at location r,c
     * @param r the row in which to place the value
     * @param c the column in which to place the value
     * @param value the value to be placed at r,c
     * @throws IndexOutOfBoundsException exception if r,c is outside of the
     * size of the array
     */
    public void setArray(int r, int c, int value) throws IndexOutOfBoundsException{
        try{
            this.array[r][c] = value;
        } catch (IndexOutOfBoundsException e){
            System.out.println("Cannot set value " + value + " at coordinates" +
                    " " + r + "," + c);
        }
    }

    /**
     * getRows is a get method for the private variable rows
     * @return the amount of rows as an int
     */
    public int getRows(){
        return rows;
    }

    /**
     * getColumns is a get method for the private variable columns
     * @return the amount of columns as an int
     */
    public int getColumns(){
        return columns;
    }

    /**
     * toString overrides matrix's toString to make the output look better
     * to the console
     * @return the string formatted
     */
    @Override
    public String toString() {
        //TODO: Finish toString
        String print, row;
        for (int r = 0; r < this.rows; r++){
            for (int c = 0; c < this.columns; c++)
        }
    }
}
