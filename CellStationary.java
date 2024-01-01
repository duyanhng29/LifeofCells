import java.util.List;
/**
 * Duy Anh Pham Nguyen
 * @PID: A16558043
 * @email : dan014@ucsd.edu
 * Sources used: Tutors helped me with my logics and debugging
 * The purpose of this file is to create the child
 * CellStationary class of the parent Cell class. Then, 
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
public class CellStationary extends Cell {
   // Constant variables used to check for apoptosis
   private static final int STATIONARY_NEIGHBORS_UPPER = 7;
   private static final int STATIONARY_NEIGHBORS_LOWER = 3;
   // String representation of the cell types
   private static final String STATIONARY_STRING       = ".";
   /**
    * Construct a CellStationary object. This constructor 
    * invokes the parent's class (Cell) in order to 
    * initialize the instance variables with the value 
    * in its parameters
    * @param  int currRow:
    * @param  int currCol:
    * @param  int mass:
    * @retrun no return
    */   
   public CellStationary(int currRow, int currCol, int mass){
      // Invoking parent's class            
      super(currRow, currCol, mass);         
   }  
   /**
    * This is the copy of the CellStationary constructor.
    * This constructor invokes the parent's class copy constructor
    * in order to intialize the instance variables with the instance
    * variables of the CellStationary object passed in as an argument. 
    * @param  otherCellStationary
    * @return no return 
    */
   public CellStationary(CellStationary otherCellStationary){
      // Invoking parent's class
      super(otherCellStationary);              
   }
   /**
    * This method returns the String which represents 
    * the CellStationary object. 
    * @param  no param
    * @return "." representation of the object
    */   
   public String toString(){
      return STATIONARY_STRING;
   }
   /**
    * This method checks the conditions for apoptosis
    * Specifically, this method checks if this cell have less than
    * or equal to 7 and greater than or equal to 3 neighbors
    * @param  List<Cell>neighbors
    * @return true if the condition is satisfied
    *         false otherwise
    */   
   public boolean checkApoptosis(List<Cell>neighbors){    
      return neighbors.size() <= STATIONARY_NEIGHBORS_UPPER 
          && neighbors.size() >= STATIONARY_NEIGHBORS_LOWER; 
   }
   /**
    * This method makes a deep copy of the 
    * calling object
    * @param  no param
    * @return return the deep copy of the calling object 
    */
   public Cell newCellCopy(){
      Cell cell = new CellStationary(this);
      return cell;
   }
}