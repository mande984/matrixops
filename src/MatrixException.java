/**
 * MatrixException is a class that allows the program to send specialized
 * error messages for inoperable matrices
 */
public class MatrixException extends Exception{
    public MatrixException(String message){
        super(message);
    }
}
