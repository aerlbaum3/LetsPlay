import java.util.Scanner;



public class GameOfLife {

	// A simple Java program to implement Game of Life
	    public static void main(String[] args)
	    {    
	    	int row;
            int col;
            Scanner keyboard = new Scanner(System.in);
            //asking the user to choose the board size to maintain configuration to allow board sizes from 20 * 20 - 30 * 30
 	        System.out.println("Choose a board size from 20 - 30: ");
 	        row = col = keyboard.nextInt();
	    
	    	Organism[][] grid = new Organism[row][col];
	    	CircularQueue cQueue = new CircularQueue(row * col);
	    	
	    	//To demonstrate using the glider pattern
	    	//start off making all the organism state to be dead(0) 
	  	    for (int i = 0; i < row; i++) {
	    	   for(int j = 0; j < col; j++) {
	    		   grid[i][j] = new Organism(i, j, 0);

	    		   }
	    		}
	        //besides for these specific organisms setting them to be alive(1)
	  	    grid[0][1] = new Organism(0, 1, 1);;
	        grid[1][2] = new Organism(1, 2, 1);;
	        grid[2][0] = new Organism(2, 0, 1);;
	        grid[2][1] = new Organism(2, 1, 1);;
	        grid[2][2] = new Organism(2, 2, 1);;

	  	       printGrid(grid);
	  	       //having the game only reiterate and play 100 times
	  	       for (int i = 0; i < 100; i++) {
	  	    	   updateGrid(grid,cQueue);
	  	    	   printGrid(grid);
	  	       }
	    }
	  	       
	      //go through each row of the grid if the state is 1 print *(alive) and if 0 print -(dead)
	       public static void printGrid(Organism[][] grid) {
	    		   for(Organism[] row : grid){
		 	    	   for(Organism organism : row) {
		 	    		   if (organism.getState() == 1) {
		 	    			   //makes the heart red
		 	    			   System.out.print( "\u001B[31m❤️\u001B[0m  " );//alive
		 	    		   } else if (organism.getState() == 0) {
		 	    			   System.out.print("💀  " );//dead
		 	    		   } 
		 	    	   }
		 	    	   System.out.println();
		 	       }
	    		   System.out.println();
	       }
	    
	  //updates grid based on the rules of the game of life
	   public static void updateGrid(Organism[][] grid,CircularQueue cQueue) {
	        //create a temp grid to store next state
	        Organism[][] nextGrid = new Organism[grid.length][grid[0].length];

	        //iterate through each cell in grid and counts the LiveNeighbors
	        //to see if they should stay alive or die.
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[0].length; j++) {
	                int liveNeighbors = countLiveNeighbors(grid, i, j);

	                //applies game of life rules
	                if (grid[i][j].getState() == 1) {
	                    if (liveNeighbors < 2 || liveNeighbors > 3) {
	                        //underpopulation or overpopulation - cell dies
	                        cQueue.enQueue(grid[i][j]);
	                    }
	                } else {
	                    if (liveNeighbors == 3) {
	                        //reproduction - cell becomes alive, 3 neighbors
	                    	cQueue.enQueue(grid[i][j]);//add all organisms that need to be changed onto the queue but don't print it out yet
	                    }
	                }
	            }
	        }

	        //update the grid based on the changes recorded in the queue
	        while (!cQueue.isEmpty()) {
	            Organism cell = cQueue.deQueue();//dequeue everything than reverse the state
	            cell.reverseState();
	            
	            grid[cell.getRow()][cell.getCol()] = cell; 
	            
	        }
	    }

	    //counts number of live neighbors for a given cell
	    static int countLiveNeighbors(Organism[][] grid, int row, int col) {
	        int liveNeighbors = 0;
	        int numRows = grid.length;
	        int numCols = grid[0].length;

	        //checks all neighbor cells in a toroidal manner
	        for (int i = -1; i <= 1; i++) {
	            for (int j = -1; j <= 1; j++) {
	                if (i == 0 && j == 0) 
	                	continue; // Skip the current cell
	                int newRow = (row + i + numRows) % numRows; // Toroidal grid
	                int newCol = (col + j + numCols) % numCols; // Toroidal grid
	                liveNeighbors += grid[newRow][newCol].getState();
	            }
	        }

	        return liveNeighbors;
	    }
	 }

