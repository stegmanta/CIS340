// This class must have the code in the run() method to solve the maze
// It searches for the Java logo based on the provided path/direction algorithm in Part II

public class Direction extends Thread{

	Maze maze;
	Position location;
	
	Direction(Maze maze, Position location) {
		
		this.maze = maze;
		this.location = location;
	}
	
	// This is the code part that needs to be programmed by students to solve the maze 
	// using the provided path/direction algorithm
	
	public void run(){

	// This is a SAMPLE code for moving the student image in the maze
	// and updates the information in Position.java GUI class, append text into the JTextArea object
	// you should delete/update this code and start your solution, you may just keep the part of updating the information
	// in the Position.java class, appending information into the JTextArea object
		
//		while(!maze.isDone()) {
//			
//		if(this.maze.moveDown())
//		location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
//				
//		}	
//		
//		location.textArea.append("Logo Found \n");
		
		while(!maze.isDone()) {
			//if the column is even
			if(maze.getCurrCol() %2 == 0) {
					//if its at the top break
					if(maze.getCurrRow() == maze.getHeight()-1) {
						break;
					}
					//try several movements
					if(this.maze.moveDown())
					appendText();
					if(maze.isDone()) {
						break;
					}
					//if an obstacle is hit perform the required move corrections (RDDL)
					if(!this.maze.moveDown()) {
						appendText();
						if(maze.isDone()) {
							break;
						}
						if(this.maze.moveRight())
						appendText();
						if(maze.isDone()) {
							break;
						}
						if(this.maze.moveDown())
						appendText();
						if(maze.isDone()) {
							break;
						}
						if(this.maze.moveDown())
						appendText();
						if(maze.isDone()) {
							break;
						}
						if(this.maze.moveLeft())
						appendText();
						if(maze.isDone()) {
							break;
						}
					}
					//see if the maze was solved from having to move (RDDL)
				if(maze.isDone())
					break;
				//finally try and move right
				if(this.maze.moveRight())
					appendText();
				if(maze.isDone()) {
					break;
				}
			}//end if column is even
			else {
				//else column is odd
				//check if it is the first row and break if it is
					if(maze.getCurrRow() == 0) {
						break;
					}
					if(this.maze.moveUp())
						appendText();
					if(maze.isDone()) {
						break;
					}
					//if we run into an obstacle moving up on odd columns move (LUUR)
					if(!this.maze.moveUp()) {
						appendText();
						if(maze.isDone()) {
							break;
						}
						if(this.maze.moveLeft())
							appendText();
						if(maze.isDone()) {
							break;
						}
							if(this.maze.moveUp())
							appendText();
							if(maze.isDone()) {
								break;
							}
							if(this.maze.moveUp())
							appendText();
							if(maze.isDone()) {
								break;
							}
							if(this.maze.moveRight())
							appendText();
							if(maze.isDone()) {
								break;
							}
					}
					//see if maze was solved from having to move LUUR
				if(maze.isDone())
					break;
				//try and move right
				if(this.maze.moveRight())
					appendText();
				if(maze.isDone()) {
					break;
				}
			}
				
        }
		
		
		
		location.textArea.append("Logo Found \n");
		
		location.textArea.append("Success" + "\n");
		System.out.println("MAZE WAS SOLVED!!!");
//		
	}//end run
   
	public void appendText() {
		location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
	}
	
}
