
/**
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class saves the initial coordinates of a robot, 
 * whether it's a friendly or an enemy and if it's dead or alive
 *
 *
 */

public class Robot {
	
	private double X;
	private double Y;
	private boolean status;
	private boolean frenemy;

	//Getters
	
	/**
	 * @return X coordinate of a robot
	 */
	public double getX(){
		return X;
			}
	/**
	 * @return Y coordinate of a robot 
	 */
	public double getY(){
		return Y;
			
	}
	/**
	 * @return status (dead or alive)
	 */
	public boolean getStatus() {
		return status;
	}
	/**
	 * @return frenemy (friend or enemy)
	 */
	public boolean getFrenemy() {
		return frenemy;
		
	}
	
	//Setters
	
	
    /**
     * @param double x
     */
    public void setX(double x){
		X = x;
			}
    
    /**
     * 
     * @param double y
     */
    public void setY(double y){
		Y = y;
			}
    /**
     * 
     * @param bs(boolean) / (dead or alive)
     */
    public void setStatus(boolean bs) {
    	status = bs;
    }
    /**
     * 
     * @param bf(boolean) / (friendly or enemy)
     */
    public void setFrenemy(boolean bf) {
    	frenemy = bf;
    }
    
    
	//Constructor
    /**
     * 
     * @param x
     * @param y
     * @param bs (boolean) / (dead or alive)
     * @param bf (boolean) / (friendly or enemy)
     */
	public Robot (double x, double y, boolean bs, boolean bf) {
		String xs = "" + x;
		xs = xs.substring(0, 3);
		X = Double.parseDouble(xs);
		String ys = "" + y;
		ys = ys.substring(0, 3);
		Y = Double.parseDouble(ys);
		status = bs;
		frenemy = bf;
	}
	
	//toString
	// Status:  D = Dead , A = Alive
	//Frenemy : F = Friendly , X = Enemy
	/**
	 * This method is used for testing purposes only.To test whether the robot coordinates and movements that appear
	 * in the grid are correct
	 * @return Robot object in String form  
	 */
    public String toString(){
	  return "The coordinates of the Robot are :  ("+ X + ", " + Y + ") " + (status?"A" : "D") + (frenemy?"F" : "X");
		}    
	}
	
	
		
		
		
		
		



