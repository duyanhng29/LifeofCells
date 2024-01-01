import java.util.List;
/**
 * Duy Anh Pham Nguyen
 * @PID: A16558043
 * @email : dan014@ucsd.edu
 * Sources used: Tutors helped me with my logics and debugging
 * The purpose of this file is to create the child
 * CellMoveUp class of the parent Cell class. Then, 
 * this class will also implement the abstract
 * method from the parent class based on this class's 
 * behaviors
 */
/**
 * This class includes 2 constructors and 2 methods.  
 * The two constructors initialize the instance variables 
 * and make a copy of it by invoking the parent class.
 * This class also implements Movable class in order to 
 * define where the cell should move to
 * One of the method has the representation string for 
 * the cell type and the other checks the conditions
 * for apoptosis for the cell.
 */
public class CellMoveUp extends Cell implements Movable {
   // Constant variable used to check for apoptosis   
   private static final int MOVEUP_NEIGHBORS = 4;
   // String representation of the cell types   
   private static final String MOVEUP_STRING = "^";
   /**
    * Construct a CellMoveUp object. This constructor 
    * invokes the parent's class (Cell) in order to 
    * initialize the instance variables with the value 
    * in its parameters
    * @param  int currRow:
    * @param  int currCol:
    * @param  int mass:
    * @retrun no return
    */
   public CellMoveUp(int currRow, int currCol, int mass){
      // Invoking parent's class
      super(currRow, currCol, mass);   
   }  
   /**
    * This is the copy of the CellMoveUp constructor.
    * This constructor invokes the parent's class copy constructor
    * in order to intialize the instance variables with the instance
    * variables of the CellMoveUp object passed in as an argument. 
    * @param  otherCellMoveUp
    * @return no return 
    */
   public CellMoveUp(CellMoveUp otherCellMoveUp){
      // Invoking parent's class
      super(otherCellMoveUp);              
   }
   /**
    * This method returns the String which represents 
    * the CellMoveUp object. 
    * @param  no param
    * @return "^" representation of the object
    */
   public String toString(){
      return MOVEUP_STRING;
   }
   /**
    * This method checks the conditions for apoptosis
    * Specifically, this method checks if this cell does
    * not have exactly 4 neighbors
    * @param  List<Cell>neighbors
    * @return true if the condition is satisfied
    *         false otherwise
    */
   @Override
   public boolean checkApoptosis(List<Cell>neighbors){    
      return neighbors.size() != MOVEUP_NEIGHBORS ; 
   }
   /**
    * This method makes a deep copy of the 
    * calling object
    * @param  no param
    * @return return the deep copy of the calling object 
    */
   @Override
   public Cell newCellCopy(){
      Cell cell = new CellMoveUp(this);
      return cell;
   }   
   /**
    * This method defines how CellMoveUp should move
    * @param  no param
    * @return return an array storing the new position
    *         that the cell will move to
    */
   @Override
   public int[] getMove(){
      // Move up by one row
      int[] array = {currRow - 1,currCol};
      return array;
   }
}