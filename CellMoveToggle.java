import java.util.List;
/**
 * Duy Anh Pham Nguyen
 * @PID: A16558043
 * @email : dan014@ucsd.edu
 * Sources used: Tutors helped me with my logics and debugging
 * The purpose of this file is to create the child
 * CellMoveToggle class of the parent class. Then, 
 * this class will also implement the abstract
 * method from the parent class based on this class's 
 * behaviors
 */
/**
 * This class includes 2 constructors and 2 methods.  
 * The two constructors initialize the instance variables 
 * and make a copy of it by invoking the parent class.
 * One of the method has the representation string for 
 * the cell type and the other checks the conditions
 * for apoptosis for the cell.
 */
public class CellMoveToggle extends CellMoveUp {
   // Constant variables used to check for apoptosis
   private static final int MOVETOGGLE_NEIGHBORS_UPPER = 2;
   private static final int MOVETOGGLE_NEIGHBORS_LOWER = 5;
   // String representation of the cell types
   private static final String MOVETOGGLE_STRING_T = "T";
   private static final String MOVETOGGLE_STRING_t = "t";
   // Instant varibale 
   public boolean toggled;     // Checking whether the cells is toggled
   /**
    * Construct a CellMoveToggle object. This constructor 
    * invokes the parent's class in order to 
    * initialize the instance variables with the values 
    * passed in as arguments
    * @param  int currRow:
    * @param  int currCol:
    * @param  int mass:
    * @retrun no return
    */
   public CellMoveToggle(int currRow, int currCol, int mass){
      // Invoking parents' class
      super(currRow, currCol, mass);   
      // Setting toggled to true
      toggled = true;
   }  
   /**
    * This is the copy of the CellMoveToggle constructor.
    * This constructor invokes the parent's class copy constructor
    * in order to intialize the instance variables with the instance
    * variables of the CellMoveToggle object passed in as an argument. 
    * @param  otherCellMoveTiggle
    * @return no return 
    */
   public CellMoveToggle(CellMoveToggle otherCellMoveToggle){
      //Invoking parents' class
      super(otherCellMoveToggle);              
   }
   /**
    * This method returns the String which represents 
    * the CellMoveToggle object. 
    * @param  no param
    * @return "T" representation of the object
    *         if toggled is true
    *         "t" owtherwise
    */
   public String toString(){              
      // If the cell is toggled
      if(toggled == true){
         // return the appropriate string representation
         return MOVETOGGLE_STRING_T; 
      }
      else{
         return MOVETOGGLE_STRING_t;
      }
   }
   /**
    * This method checks the conditions for apoptosis
    * Specifically, this method checks if this cell have 
    * less than 2 or more than 5 neighbors
    * @param  List<Cell>neighbors
    * @return true if the condition is satisfied
    *         false otherwise
    */
   @Override
   public boolean checkApoptosis(List<Cell>neighbors){    
      return neighbors.size() < MOVETOGGLE_NEIGHBORS_UPPER 
          || neighbors.size() > MOVETOGGLE_NEIGHBORS_LOWER; 
   }
   /**
    * This method makes a deep copy of the 
    * calling object
    * @param  no param
    * @return return the deep copy of the calling object 
    */ 
   @Override
   public Cell newCellCopy(){
      Cell cell = new CellMoveToggle(this);
      return cell;
   }
   /**
    * This method defines how CellMoveToggle should move
    * @param  no param
    * @return return an array storing the new position
    *         that the cell will move to
    */
   @Override
   public int[] getMove(){
      // Initializing the array of size 2, first element
      // is the index of row on the board, and second
      // element is the index of column on the board
      int[] array = new int[2];
      // If toggled is true     
      if(toggled == true){
         // Moving up by 1 row
         array[0] = currRow - 1;
         array[1] = currCol;
      }
      // If toggled is false
      else{
         // Stay the same
         array[0] = currRow;
         array[1] = currCol;
      }
      // Flipping the value of toggle after each call
      toggled = !toggled;   
      return array;
   }   
}
