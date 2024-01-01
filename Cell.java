import java.util.List;
/**
 * Duy Anh Pham Nguyen
 * @PID: A16558043
 * @email: dan014@ucsd.edu
 * Sources used: Tutors helped me with my logics and debugging
 * The purpose of this file is to make the 
 * superclass for other subclasses. The superclass
 * is an abstract one with an abstract method. The abstract
 * method will be implemented by subclasses with its own behaviors
 */
/**
 * This class includes 2 constructors and 7 methods
 * with different functionalities. This clas also 
 * implements Comparable in order to compare
 * the masses of two cells.
 * The two constructors initialize the instance variables 
 * and make a copy of it. The methods will set the values
 * of the instance varibales based on the purpose and use
 * getters method for instance varibales to get its value.
 * This class also has two abstract methods. They will be 
 * implemented by the subclasses with its own behaviors.
 */
public abstract class Cell implements Comparable<Cell>  {
   // Instant variables
   public int currRow;      // Stores the row value of the cell
   public int currCol;      // Stores the column value of the cell
   public int mass;         // Stores the mass of the cell   
   /**
    * Construct a Cell object. This constructor 
    * initializes instance variables with the values
    * in its parameters
    * @param  int currRow: the row values 
    * @param  int currCol: the column values
    * @param  int mass:    the mass values
    * @retrun no return
    */
   public Cell(int currRow, int currCol, int mass){
      // Checking if arguments are valid,
      // if they are not, set these arguments to 0
      if(currRow < 0){
         currRow = 0;
      }
      if(currCol < 0){
         currCol = 0;  
      }
      if(mass < 0){
         mass = 0;  
      }
      // Initializing all instance variables
      this.currRow  = currRow;
      this.currCol  = currCol;
      this.mass     = mass;           
   }  
   /**
    * This is the copy of the Cell constructor.
    * This constructor initializes the instance variables
    * with the instance variables of the Cell object in the 
    * parameter
    * @param  otherCell
    * @return no return 
    */
   public Cell(Cell otherCell){
      // Initializing instance variables with the instance
      // variables of the Cell object passed in as argument
      this.currRow = otherCell.currRow;
      this.currCol = otherCell.currCol;
      this.mass    = otherCell.mass;              
   }
   /**
    * This method sets currRow, currCol, mass to 
    * -1 to indicate cell death. 
    * @param  no parameter
    * @return no return
    */
   public void apoptosis(){
      currRow = -1;
      currCol = -1;
      mass    = -1;
   }
   /**
    * This is the getter method of curRow which
    * returns the value of currRow
    * @param  no param
    * @return currRow
    */
   public int getCurrRow(){
      return this.currRow;     
   }
   /**
    * This is the getter method of curCol which
    * returns the value of currCol
    * @param  no param
    * @return currCol
    */
   public int getCurrCol(){
      return this.currCol;
   }
   /**
    * This is the getter method of mass which
    * returns the value of mass
    * @param  no param
    * @return mass
    */   
   public int getMass(){
      return this.mass; 
   }
   /**
    * This is an abstract method that other subclasses
    * will implement with its own behavior. 
    * @param  List<Cell>neighbors:
    *         a list of cells determine whether the cell should
    *         initiate apoptosis or not. 
    * @return true if the condition is sastisfied
    *         false otherwise
    */
   public abstract boolean checkApoptosis(List<Cell>neighbors);
   /**
    * This method compares the masses of the two cells
    * @param  otherCell
    * @return return 0 if masses equal
    *         return positive number  if the
    *         comparable mass is larger than the otherCell
    *         return negative otherwise.
    */
   @Override
   public int compareTo(Cell otherCell){
      return this.getMass() -  otherCell.mass;
   }
   /**
    * This abstract method creates a deep copy of the cell.
    * This will be implemented by the behaviors of each
    * subclass
    * @param  no param
    * @return return the deep copy of the calling object
    */
   public abstract Cell newCellCopy();

   public void updatePosition(int[] newPosition)
   {
      currRow = newPosition[0];
      currCol = newPosition[1];
   }
}