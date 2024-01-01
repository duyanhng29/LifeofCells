/**
 * Duy Anh Pham Nguyen
 * @PID: A16558043
 * @email: dan014@ucsd.edu
 * Sources used: Tutors helped me with my logics and debugging
 * The purpose of this file is to make an interface class
 * with one abstract method. This class will be implemented
 * by the class which has the functionality of moving the cell
 */
/**
 * This interface class contains an abstract class.
 * This abstract class will define how a cell should
 * be moved based on the behavior of the subclass
 */
public interface Movable {
   /**
    * This method defines where the cell should move to
    * @param  no param
    * @return return an array of size 2, the first index
    *         will be the row on the 2D array board, and 
    *         the second index will be the column
    */
   public abstract int[] getMove();   
}
