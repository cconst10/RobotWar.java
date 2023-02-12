/**
 * This class represents the object Battlefield. It is defined by a 10x10 2d array
 * It creates the grid visually and displays the enemy robots and the player robot as well as their movements according 
 * to what the user enters
 * @author Christodoulos Constantinou
 * @version 1.0
 *
 */
public class Battlefield {

	private Location grid[][];
	
	//Constructor
	/**
	 * This constructor creates the object Battlefield according to the grid 10x10 2d array
	 */
	public Battlefield(){
		grid = new Location [10][10];
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = new Location (i, j, 0); 
			}
			
		}
	}
	
	/**
	 * Checks whether a robot is inside a certain square / location
	 * @param cell(Location type object that refers to a square of the grid)
	 * @param robot(The location of the robot we are testing to see if it's inside a certain square of the grid)
	 * @return result(boolean type / true if it's inside, false if not)
	 */
	private boolean inside(Location cell , Location robot) {
		boolean result = false;
		if(cell.getX() <= robot.getX() && 
		   robot.getX() <= (cell.getX() + 0.9) &&
				   cell.getY() <= robot.getY() && 
				   robot.getY() <= (cell.getY() + 0.9)
		   ) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Goes through the enemies array and checks if there are any 
     *ALIVE enemies that are in the first argument.
     *if there is none return -1
     *if there is one return its index in the array
     *the index is returned so that the calling function
     *'kills' off the enemy (if a friend is also there)
     *
	 * @param cell(Location type object that refers to a square of the grid)
	 * @param enemies(1d array that stores the enemy robots)
	 * @return result(boolean type that returns true when there is an enemy robot in the cell
	 *  and false if there is no enemy robot in the cell)
	 */
    
    private int getEnemy(Location cell, Robot enemies[]) {
        int result = -1;
        for(int k = 0; k < enemies.length; k++) {
            Location enemy = new Location(enemies[k].getX(), enemies[k].getY(), 0);
            if (inside(cell, enemy) && enemies[k].getStatus()) {
                result = k;
                return result;
            }
        }
        return result;    
    }
    /**
     * This method prints the 10x10 grid and the robots
     * @param enemies(1d array that stores the enemies)
     * @param player(Robot type object which resembles the player robot)
     */
    public void printBattleField(Robot enemies[], Robot player) {
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        for(int i = 0; i < 10; i++) {
            System.out.println("   - - - - - - - - - -");
            System.out.print(" " + i + "|");
            for(int j = 0; j < 10; j++) {
                Location cell = new Location(i,j,0);
                Location playerLocation = new Location(player.getX(), player.getY(), 0);
                String x = " |";
                int haveEnemy = getEnemy(cell, enemies);
                if (haveEnemy==-1) {
                    //no enemy
                    if (inside(cell, playerLocation)) {
                        x = "F|";
                    }

                } else {
                    //enemy
                    x = "E|";
                    if (inside(cell, playerLocation)) {
                        x = "F|";
                        //have to set the specific
                        enemies[haveEnemy].setStatus(false); 
                    }
                } // end of if-else

                System.out.print(x);    
            }
            
            System.out.println();
	
			
		
	}
  }
    
}
