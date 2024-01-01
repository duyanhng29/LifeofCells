import java.util.List;
/**
 * Duy Anh Pham Nguyen
 * @PID: A16558043
 * @email : dan014@ucsd.edu
 * Sources used: Tutors helped me with my logics and debugging
 * The purpose of this file is to create the child
 * CellMoveToggleChild class of the parent class. Then, 
 * this class will also implement the abstract
 * method from the parent class based on this class's 
 * behaviors
 */
/**
 * This class includes 2 constructors and 1 method.  
 * The two constructors initialize the instance variables 
 * and make a copy of it by invoking the parent class.
 * The method checks the conditions
 * for apoptosis for the cell.
 */
public class CellMoveToggleChild extends CellMoveToggle{
   // Constant variables used to check for apoptosis
   private static final int NUM_ALIVE_VALUE = 10;
   private static final int NEIGHBORS_UPPER = 2;
   private static final int NEIGHBORS_LOWER = 5;
   // Instance variable
   public static int numAlive;     // stores the number of alive cells
   /**
    * Construct a CellMoveToggleChild object. This constructor 
    * invokes the parent's class in order to 
    * initialize the instance variables with the values 
    * passed in as arguments
    * @param  int currRow:
    * @param  int currCol:
    * @param  int mass:
    * @retrun no return
    */ 
   public CellMoveToggleChild(int currRow, int currCol, int mass){
      // Invoking parents'class
      super(currRow, currCol, mass); 
      // Incrementing numAlive by 1
      numAlive += 1;
   }
   /**
    * This is the copy of the CellMoveToggleChild constructor.
    * This constructor invokes the parent's class copy constructor
    * in order to intialize the instance variables with the instance
    * variables of the CellMoveToggleChild object passed in as an argument. 
    * @param  otherCellMoveToggleChild
    * @return no return 
    */
   public CellMoveToggleChild(CellMoveToggleChild otherCellMoveToggleChild){
      // Invoking parents' class
      super(otherCellMoveToggleChild); 
      // Incrementing numAlive by 1
      numAlive += 1;
   }
   @Override
   public void apoptosis(){
      // Invoking parent's class
      super.apoptosis();
      // Decrementing numAlive by 1      
      numAlive -= 1;
   }
   /**
    * This method checks the conditions for apoptosis
    * Specifically, this method checks the conditions
    * of CellMoveToggle and if there are fewer than 
    * 10 numAlive alive
    * @param  List<Cell>neighbors
    * @return true if the condition is satisfied
    *         false otherwise
    */ 
   @Override
   public boolean checkApoptosis(List<Cell>neighbors){    
      return (neighbors.size() < NEIGHBORS_UPPER 
          || neighbors.size() > NEIGHBORS_LOWER)
      //super.checkApoptosis(neighbors)
             && numAlive < NUM_ALIVE_VALUE; 
   }
   /**
    * This method makes a deep copy of the 
    * calling object
    * @param  no param
    * @return return the deep copy of the calling object 
    */ 
   @Override
   public Cell newCellCopy(){
      Cell cell = new CellMoveToggleChild(this);
      return cell;
   }   
}
