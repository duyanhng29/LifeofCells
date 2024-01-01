import java.util.List;
/**
 * Duy Anh Pham Nguyen
 * @PID: A16558043
 * @email : dan014@ucsd.edu
 * Sources used: Tutors helped me with my logics and debugging
 * The purpose of this file is to create the child
 * CellDivide class of the parent Cell class. Then, 
 * this class will also implement the abstract
 * method from the parent class based on this class's 
 * behaviors
 */
/**
 * This class includes 2 constructors and 2 methods.  
 * The two constructors initialize the instance variables 
 * and make a copy of it by invoking the parent class.
 * This class also implements Divisible class in order to
 * define where the cell is divided into
 * One of the method has the representation string for 
 * the cell type and the other checks the conditions
 * for apoptosis for the cell.
 */
public class CellDivide extends Cell implements Divisible {
   // Constant variable used to check for apoptosis
   private static final int DIVIDE_NEIGHBORS = 3;
   // String representation of the cell types   
   private static final String DIVIDE_STRING = "+";
   // Instance variable, represents the 
   // direction the cell will divide into
   public int direction;
   /**
    * Construct a CellDivide object. This constructor 
    * invokes the parent's class (Cell) in order to 
    * initialize the instance variables with the values 
    * passed in as arguments
    * @param  int currRow:
    * @param  int currCol:
    * @param  int mass:
    * @retrun no return
    */
   public CellDivide(int currRow, int currCol, int mass){
      // Invoking parent's class
      super(currRow, currCol, mass);   
      // Setting the instance variable to 1
      this.direction = 1;
   }
   /**
    * This is the copy of the CellDivide constructor.
    * This constructor invokes the parent's class copy constructor
    * in order to intialize the instance variables with the instance
    * variables of the CellDivide object passed in as an argument. 
    * @param  otherCell
    * @return no return 
    */  
   public CellDivide(CellDivide otherCellDivide){
      // Invoking parent's class
      super(otherCellDivide);
      direction = otherCellDivide.direction;
   }
   /**
    * This method returns the String which represents 
    * the CellDivide object. 
    * @param  no param
    * @return "+" representation of the object
    */   
   public String toString(){
      return DIVIDE_STRING;
   }
   /**
    * This method checks the conditions for apoptosis
    * Specifically, this method checks if this cell does
    * have exactly 3 neighbors
    * @param  List<Cell>neighbors
    * @return true if the condition is satisfied
    *         false otherwise
    */ 
   @Override
   public boolean checkApoptosis(List<Cell>neighbors){    
      return neighbors.size() == DIVIDE_NEIGHBORS; 
   }
   /**
    * This method makes a deep copy of the 
    * calling object
    * @param  no param
    * @return return the deep copy of the calling object 
    */
   @Override
   public Cell newCellCopy(){
      Cell cell = new CellDivide(this);
      return cell;
   }
   /**
    * This method defines how CellDivide should move
    * (divide) to a new position.
    * @param  no param
    * @return return an array storing the new
    *         position that the cell will move to
    */
   @Override
   public int[] getDivision(){
      // Initializing the array of size 2, first element
      // is the index of row on the board, and second
      // element is the index of column on the board
      int[] array = new int[2];
      // Cycling (wrapping) around the direction after
      // each call, so that the cell will move base on
      // these directions only
      int directionWrapped = direction % 4;
      // Going down if direction = 0
      if(directionWrapped == 0){
         array[0] = currRow + 1;
         array[1] = currCol;
      }
      // Going up if direction = 1
      else if(directionWrapped == 1){
         array[0] = currRow - 1;
         array[1] = currCol;
      }
      // Going left if direction = 2
      else if(directionWrapped == 2){
         array[0] = currRow;
         array[1] = currCol - 1;
      }
      // Going up if direction = 3
      else if(directionWrapped == 3){
         array[0] = currRow - 1;
         array[1] = currCol;
      }
      // Incrementing direction by 1 after each call
      direction += 1;
      return array;
   }
}