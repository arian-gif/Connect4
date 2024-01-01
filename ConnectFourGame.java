public class ConnectFourGame {
    
    // Array used to represent the 6 (row) x 7 (col) game board.
    private int[][] grid;
    // The player whose turn it is (1 or 2).
    private int currentPlayer;
    static int turn = 0;
    
    // Create and initialize the grid for our game.
    public ConnectFourGame() {
        // create the 6 row x 7 col grid of integers (0 default)
        this.grid = new int[6][7];

        // set the first move to Player 1
        this.currentPlayer = 1;
    } // ends constructor

// Drop a checker into the specified column, and 
    // return the row that the checker lands on.
    // (invalid move returns -1)
    public int drop( int column ) {
        // Exit if someone has already won, or column out of range.
      
        if ( column >= 7 ||column<0 ||this.hasWon() ) {
            return -1;
        }
        
        // Find the first empty row in the column
        int row;

		
        for (row=5 ; row >= 0 && grid[row][column]!=0; row--) { // nothing to do here since I exit when i find the empty row
		
			
			};
        
        // Exit if there are no free rows in the column left
        if ( row == -1 ) {
            return -1;
        }

		// if all is good, 
        // Fill the row of that column with a checker.
        grid[row][column] = currentPlayer;
        
        // Alternate the players
        currentPlayer = (currentPlayer%2)+1;
        return row;
    }
    

// This method returns true if one of the players has won the game.
    public boolean hasWon() {
        boolean status = false;
        
        // Check for a horizontal win
        for ( int row=0; row<6; row++ ) {
            for ( int column=0; column<4; column++ ) { // because we would overshoot
                if (grid[row][column] != 0 &&
                    grid[row][column] == grid[row][column+1] &&
                    grid[row][column] == grid[row][column+2] &&
                    grid[row][column] == grid[row][column+3]) {
                    status = true;
                }
            }
        }

      // Check for a vertical win
      // MISSING CODE…  YOU need to write this!
      
      for ( int column = 0; column < 7; column++){
        for (int row = 0; row < 3; row++){
          if (grid[row][column] != 0 &&
                    grid[row][column] == grid[row+1][column] &&
                    grid[row][column] == grid[row+2][column] &&
                    grid[row][column] == grid[row+3][column]) {
                    status = true;
        }
      }
      }
        //upward diagnol
        for (int column = 0; column <4;column++){
          for (int row =5;row>2;row--){
            if(grid[row][column] != 0 &&
                    grid[row][column] == grid[row-1][column+1] &&
                    grid[row][column] == grid[row-2][column+2] &&
                    grid[row][column] == grid[row-3][column+3]) {
                    status = true;
          }
            
        }
          
        }
        //other side diagnol
        for (int column = 6; column >2;column--){
          for (int row =5;row>2;row--){
            if(grid[row][column] != 0 &&
                    grid[row][column] == grid[row-1][column-1] &&
                    grid[row][column] == grid[row-2][column-2] &&
                    grid[row][column] == grid[row-3][column-3]) {
                    status = true;
          }
          }  
        }
       // Check for a diagonal win (negative slope)
       // MISSING CODE…  YOU need to write this!

       // Check for a diagonal win (positive slope)
       // MISSING CODE…  YOU need to write this!
        
        
      return status;
    }
        
    public int getCurrentPlayer(){
      return this.currentPlayer;
    }
        
 // Returns a String representation of the Connect Four game board.
    public String toString () {
     
      turn++;
      
        String returnString = "col: 0 1 2 3 4 5 6\n     -------------\n    ";
        for ( int row=0; row<6; row++ ) {
            for ( int column=0; column<7; column++ ) {
                returnString = returnString + " " + grid[row][column];
            }
            returnString = returnString + "\n    ";
        } 
    
        return returnString;
      
     
    } // ends toString()
        } // ends connectFourGame class
