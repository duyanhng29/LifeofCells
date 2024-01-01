import java.util.List;
/**
 * Duy Anh Pham Nguyen
 * @PID: A16558043
 * @email : dan014@ucsd.edu
 * Sources used: Tutors helped me with my logics and debugging
 * The purpose of this file is to create the child
 * CellMoveDiagonal class of the parent class. Then, 
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
public class CellMoveDiagonal extends CellMoveUp {
   // Constant variables used to check for apoptosis
   private static final int MOVEDIAGONAL_NEIGHBORS   = 3;
   // String representation of the cell types
   private static final String MOVEDIAGONAL_STRING_1 = "/";
   private static final String MOVEDIAGONAL_STRING_2 = "\\";
   // Instant variables 
   public boolean orientedRight;     // Checking whether the cell is
                                     // oriented right
   public int diagonalMoves;         // Counting the number of moves
   /**
    * Construct a CellMoveDiagonal object. This constructor 
    * invokes the parent's class in order to 
    * initialize the instance variables with the values 
    * passed in as arguments
    * @param  int currRow:
    * @param  int currCol:
    * @param  int mass:
    * @retrun no return
    */  
   public CellMoveDiagonal(int currRow, int currCol, int mass){
      // Invoking parents'class
      super(currRow, currCol, mass);   
      // Setting orientedRight to true
      orientedRight = true;
      // Setting diagonalMoves to 0
      diagonalMoves = 0;      
   }
   /**
    * This is the copy of the CellMoveDiagonal constructor.
    * This constructor invokes the parent's class copy constructor
    * in order to intialize the instance variables with the instance
    * variables of the CellMoveDiagonal object passed in as an argument. 
    * @param  otherCellMoveDiagonal
    * @return no return 
    */
   public CellMoveDiagonal(CellMoveDiagonal otherCellMoveDiagonal){
      // Inovking parents'class
      super(otherCellMoveDiagonal);  
      orientedRight = otherCellMoveDiagonal.orientedRight;
      diagonalMoves = otherCellMoveDiagonal.diagonalMoves;
   }
   /**
    * This method returns the String which represents 
    * the CellMoveDiagonal object. 
    * @param  no param
    * @return "/" representation of the object
    *         if orientedRight = true
    *         "\" otherwise
    */   
   public String toString(){
      // If the cell is oriented right
      if(orientedRight == true){
         // return the appropriate string representation
         return MOVEDIAGONAL_STRING_1; 
      }
      else{
         return MOVEDIAGONAL_STRING_2;
      }
   }
   /**
    * This method checks the conditions for apoptosis
    * Specifically, this method checks if this cell have
    * more than 3 neighbors
    * @param  List<Cell>neighbors
    * @return true if the condition is satisfied
    *         false otherwise
    */
   @Override
   public boolean checkApoptosis(List<Cell>neighbors){    
      return neighbors.size() > MOVEDIAGONAL_NEIGHBORS ; 
   }
   /**
    * This method makes a deep copy of the 
    * calling object
    * @param  no param
    * @return return the deep copy of the calling object 
    */ 
   @Override
   public Cell newCellCopy(){
      Cell cell = new CellMoveDiagonal(this);
      return cell;
   }
   /**
    * This method defines how CellMoveDiagonal should move
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
      // If oriented is right
      if(orientedRight == true){
         // Moving right then up
         array[1] = currCol + 1;
         array[0] = currRow - 1;   
      }
      // If oriented is not right
      else{
         // Moving left and up
         array[1] = currCol - 1;
         array[0] = currRow - 1;
      }
      // Incrementing diagonalMoves by 1
      diagonalMoves += 1;
      // If diagonalMoves is a multiple of 4
      if(diagonalMoves % 4 == 0){
         // Switching the orientation
         orientedRight = !orientedRight;  
      }
      return array;
   }   
}
