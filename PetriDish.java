import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Duy Anh Pham Nguyen
 * @PID: A16558043
 * @email : dan014@ucsd.edu
 * Sources used: Tutors helped me with my logics and debugging
 * The purpose of this file is to create a 2D
 * array board. This board will represent the board
 * of the game and show the type of cell with its mass
 */
/**
 * This class only contains a constructor. 
 * This will help outputting the cell types and its 
 * mass appropriately in the Cell 2D array
 */
public class PetriDish {
   // String names of each cells in the board
   
   private final static String NULL  
                                                   = "null";
   private final static String CELLSTATIONARY 
                                                   = "CellStationary ";
   private final static String CELLDIVIDE 
                                                   = "CellDivide ";
   private final static String CELLMOVEUP 
                                                   = "CellMoveUp ";
   private final static String CELLMOVETOGGLE 
                                                   = "CellMoveToggle ";
   private final static String CELLMOVEDIAGONAL 
                                                   = "CellMoveDiagonal ";
   private final static String CELLMOVETOGGLECHILD 
                                                   = "CellMoveToggleChild "; 
   private final static int WRAPPING               = 2;                                                
   // Instance variable:
   // dish represnets the petri dish in the current iteration.
   public Cell[][] dish;    
   // List of movable cells
   public List<Movable>movables     = new ArrayList<Movable>();
   // List of divisible cells
   public List<Divisible>divisibles = new ArrayList<Divisible>();
   /**
    * Construct a PetriDish object. 
    * The constructor will go through each position
    * of the String 2D array board and match each string
    * properly to the Cell 2D array dish with each cell type
    * and its mass
    * @param  String[][] board
    *         the 2D array of type String
    * @return no return
    */
   public PetriDish(String[][] board){
      // Initializing the instance variable with 
      // the size of the String[][] board
      dish = new Cell[board.length][board[0].length];   
      // Using for loop to run through each position
      // of the String[][] board
      for(int k = 0; k < board.length; k++){
         for(int m = 0; m < board[k].length; m++){
            // If at the specific location string is "null"
            if(board[k][m] == NULL) {
               // That location at the Cell[][] dish will
               // be null
               dish[k][m] = null;   
            }
            // If at the specific location string is != "null"
            if(board[k][m] != "null"){
               // Finding the index of the space in the string
               int spaceIndex    = board[k][m].indexOf(" ");
               // Getting the string of mass after the space
               String stringMass = board[k][m].substring(spaceIndex + 1);
               // Converting string of mass to integer mass
               int mass          = Integer.valueOf(stringMass);   
               // If at the specific location of board, the string 
               // equals to the specific cell types and mass tring
               if(board[k][m].equals(CELLSTATIONARY + stringMass)){
                  // Setting the Cell[][] dish at that location
                  // by calling the appropriate cell type methods
                  dish[k][m] = new CellStationary(k,m,mass); 
               }
               // Similarly, we will check for all of the cell types
               if(board[k][m].equals(CELLDIVIDE + stringMass)){
                  dish[k][m] = new CellDivide(k,m,mass); 
                  // CellDivide is divisible, so we add CellDivide
                  // to divisibles list. The dish is of type Cell,
                  // we also need to cast it to type Divisible
                  // in order to add it to the list of type Divisible                  
                  divisibles.add((Divisible) dish[k][m]);
               }
               if(board[k][m].equals(CELLMOVEUP + stringMass)){
                  dish[k][m] = new CellMoveUp(k,m,mass);
                  // CellMoveUp is movable, so we add CellMoveUp
                  // to movable list. The dish is of type Cell,
                  // we also need to cast it to type Movable in 
                  // order to add it to the list of type Movable                  
                  movables.add((Movable) dish[k][m]);
               }
               if(board[k][m].equals(CELLMOVETOGGLE + stringMass)){
                  dish[k][m] = new CellMoveToggle(k,m,mass); 
                  // CellMoveToggle is movable, so we add it
                  // to movable list. The dish is of type Cell,
                  // we also need to cast it to type Movable in 
                  // order to add it to the list of type Movable                   
                  movables.add((Movable) dish[k][m]);                  
               }   
               if(board[k][m].equals(CELLMOVEDIAGONAL + stringMass)){
                  // CellMoveDiagonal is movable, so we add it
                  // to movable list. The dish is of type Cell,
                  // we also need to cast it to type Movable in 
                  // order to add it to the list of type Movable                    
                  dish[k][m] = new CellMoveDiagonal(k,m,mass); 
                  movables.add((Movable) dish[k][m]);                  
               }   
               if(board[k][m].equals(CELLMOVETOGGLECHILD + stringMass)){
                  // CellMoveToggleChild is movable, so we add it
                  // to movable list. The dish is of type Cell,
                  // we also need to cast it to type Movable in 
                  // order to add it to the list of type Movable                    
                  dish[k][m] = new CellMoveToggleChild(k,m,mass);
                  movables.add((Movable) dish[k][m]);                  
               }               
            }           
         }
      }         
   }
   /**
    * This helper method will wrap around the the board
    * if the row is out of bound
    * @param  the original row
    * @return the new row after wrapping around       
    */
   private int rowWrapped(int row){
      // If index of row is less than 0
      if(row < 0){
         // Finding the remainder
         int remainder = row % dish.length;
         // then adding the remainder to dish.length
         // in order to wrap it
         row = remainder + dish.length;
      }
      // If index of row is larger than or equal to 
      // the dish.length
      else if(row >= dish.length){
         // Finding the modulo, which is the wrapped row
         row = row % dish.length;  
      }
      return row;
   }
   /**
    * This helper method will wrap around the the board
    * if the column is out of bound
    * @param  the original column
    * @return the new column after wrapping around       
    */   
   private int colWrapped(int col){
      // If index of col is less than 0
      if(col < 0){
         // Finding the remainder
         int remainder = col % dish[0].length;
         // then adding the remainder to dish[0].length
         // in order to wrap it
         col = remainder + dish[0].length;
      }
      // If index of col is larger than or equal to 
      // the dish.length
      else if(col >= dish[0].length){
         // Finding the modulo, which is the wrapped col
         col = col % dish[0].length;  
      }
      return col;
   }
   /**
    * This method finds the neighbors of a specific
    * position on the board (up to 8 neighbors). These
    * neighbors are the cells that are around the 
    * position we want to find the neighbors
    * @param  int row: index of the row
    *         int col: index of the column
    * @return a non-null list of neighbors at that position
    */
   public List<Cell>getNeighborsOf(int row, int col){
      // Initializing the list of neighbors
      List<Cell>neighbors = new ArrayList<Cell>();   
      // If row and column are out of bound
      if(row < 0 || col < 0){
         // return null
         return null;  
      }
      // Using nested for loop to run through both row and column
      // The for loops with start at index -1 and up to 1. 
      // This is because we want to add the neighbors in
      // the order of northwest, north, northeast, west, east,
      // southwest, south, and southeast.
      for(int i = -1; i < WRAPPING; i++){
         for(int j = -1; j < WRAPPING; j++){
            // Calling rowWrapped and colWrapped to make sure that
            // the row and column are wrapped when finding 
            // the neighbors. We want a list of non-null, we 
            // will check the condition if the positions around
            // the finding cell is not null first
            if(dish[rowWrapped(row+i)][colWrapped(col+j)] != null){
               // We exclude the case where i and j are both equal to 0
               // If we don't exclude this, this means the list will add
               // the cell we need to find neighbors to the list as well
               if(i != 0 || j != 0){
                  // If the conditions above are satisfied, we add 
                  // that cell to the neighbor list
                  neighbors.add(dish[rowWrapped(row+i)][colWrapped(col+j)]);
               }
            }
         } 
      }
      return neighbors;
   }
   /**
    * This method will actually move the cell based on
    * the cell's getMove() behavior
    * @param  no param
    * @return no return 
    */
   public void move(){
      Cell[][] next = new Cell[dish.length][dish[0].length];
      boolean[][] ties = new boolean[dish.length][dish[0].length];
      List<Movable> movablesToRemove = new ArrayList<>();

      for(int i = 0; i < movables.size(); i++)
      {
         Cell currCell = (Cell)(movables.get(i));
         int[] pos = ((Movable)currCell).getMove();

         int newRow = rowWrapped(pos[0]);
         int newCol = colWrapped(pos[1]);

         if(next[newRow][newCol] == null)
         {
            next[newRow][newCol] = currCell;
            currCell.updatePosition(pos);
         }
         else if(currCell.compareTo(next[newRow][newCol]) > 0 ||
                  !(next[newRow][newCol] instanceof Movable))
         {
            if(next[newRow][newCol] instanceof Movable)
            {
               movablesToRemove.add((Movable)next[newRow][newCol]);
            }

            next[newRow][newCol].apoptosis();
            next[newRow][newCol] = currCell;
            currCell.updatePosition(pos);
         }
         else if(currCell.compareTo(next[newRow][newCol]) == 0)
         {
            ties[newRow][newCol] = true;
            next[newRow][newCol].apoptosis();
            currCell.apoptosis();

            next[newRow][newCol] = null;
            movablesToRemove.add((Movable)currCell);
            movablesToRemove.add((Movable)next[newRow][newCol]);

         }
         else 
         {
            currCell.apoptosis();
            movablesToRemove.add((Movable)currCell);
         }
      }

      for(Movable cell : movablesToRemove)
      {
         movables.remove(cell);
      }

      for(int i = 0; i < ties.length; i++)
      {
         for(int j = 0; j < ties[0].length; j++)
         {
            if(ties[i][j])
            {
               movables.remove((Movable)next[i][j]);
               next[i][j].apoptosis();
               next[i][j] = null;
            }
         }
      }
      
      dish = next;

   }
   /**
    * This method will actually divide the cell based on
    * the cell's getDivision() behavior
    * @param  no param
    * @return no return 
    */   
   public void divide(){
      Cell[][] next = new Cell[dish.length][dish[0].length];
      boolean[][] ties = new boolean[dish.length][dish[0].length];

      for(int i = 0; i < divisibles.size(); i++)
      {
         Cell newCell = (Cell)divisibles.get(i);
         int[] pos = ((Divisible)newCell).getDivision();

         int row = rowWrapped(pos[0]);
         int col = colWrapped(pos[1]);
         Cell oldCell = next[row][col];
         if(dish[row][col] == null && (oldCell == null ||
               newCell.compareTo(oldCell) > 0))
         {
            next[row][col] = newCell.newCellCopy();
            next[row][col].updatePosition(pos);
            ties[row][col] = false;

         }
         else if(oldCell != null && newCell.compareTo(oldCell) == 0)
         {
            ties[row][col] = true;
         }
      }

      for(int r = 0; r < dish.length; r++)
      {
         for(int c  = 0; c < dish[0].length; c++)
         {
            if(next[r][c] != null && !ties[r][c])
            {
               dish[r][c] = next[r][c];

               divisibles.add((Divisible)dish[r][c]);
            }
         }
      }
   }
   /**
    * This method will update the cells on the board
    * if the cells are eligible to do so. The cells
    * are eligible if they pass the condition of
    * checkApoptosis() method. We also 
    * spawn new cell for the eligible empty spaces.
    * @param  no param
    * @return no return 
    */   
   public void update(){
      Cell[][] next = new Cell[dish.length][dish[0].length];
      movables = new ArrayList<>();
      divisibles = new  ArrayList<>();

      for(int i = 0; i < dish.length; i++)
      {
         for(int j = 0; j < dish[0].length; j++)
         {
            List<Cell> neighbors = getNeighborsOf(i, j);
            if(dish[i][j] != null && dish[i][j].checkApoptosis(neighbors))
            {
               dish[i][j].apoptosis();
               if(dish[i][j] instanceof Movable)
               {
                  movables.remove((Movable)dish[i][j]);
               }
               if(dish[i][j] instanceof Divisible)
               {
                  divisibles.remove((Divisible)dish[i][j]);
               }
            }
            else if (dish[i][j] == null)
            {
               if(neighbors.size() == 2 || neighbors.size() == 3)
               {
                  next[i][j] = neighbors.get(0).newCellCopy();
               }
            }
            else
            {
               next[i][j] = dish[i][j];
            }

            if(next[i][j] instanceof Movable)
            {
               movables.add((Movable)next[i][j]);
            }
            else if(next[i][j] instanceof Divisible)
            {
               divisibles.add((Divisible)dish[i][j]);
            }         
         }
      }
      dish = next;
   }
   /**
    * This method makes iteration on the board,
    * where move happens first, then divide, and update()
    * @param  no param
    * @return no return 
    */
   public void iterate(){
      move();
      divide();
      update();
   }
     public void simulate(){
      Scanner sc = new Scanner(System.in);
      System.out.println(this);
      while(sc.hasNextLine()){
        String line = sc.nextLine();
         if(line.equals("a")){
            break;
        } 
         switch(line){
            case "m":
            move();
            break;
            case "d":
            divide();
            break;
            case "u":
            update();
            break;
            case "i":
            iterate();
            break;
            default:
            System.out.println("Invalid");
            break;
        }
        System.out.println(this);
      }     
      sc.close();
   }

   public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("---------\n"); //typically 2*board.length+3 would display the board nicely
     for(int i = 0; i < dish.length; i++){ 
      sb.append("|");
      for(int j = 0; j < dish[0].length; j++){
      sb.append(dish[i][j] == null ? " " : dish[i][j].toString());
      sb.append("|");
     }
     sb.append("\n");
      sb.append("---------\n");
     }
   return sb.toString();
   }
   public static void main (String[] args){
    String[][] petri = new String[][]{ 
        
    {"null", "null", "null","null","null" },
    {"null", "CellStationary 2", "CellDivide 5", "CellStationary 11", "null"},
    {"null", "CellMoveDiagonal 4", "CellMoveToggle 3", "CellMoveToggle 10", "CellStationary 4"},
     {"null", "null", "CellDivide 2", "CellMoveUp 4", "null"}};

      PetriDish petrii = new PetriDish(petri);

     System.out.println(petrii.toString());
     petrii.simulate();
     System.out.println(Arrays.deepToString(petri));
   }
}