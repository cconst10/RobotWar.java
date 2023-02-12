/**
 * 
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class saves the coordinates of a robot and which angle it's going to move at
 */
public class Location {

	private double X;
	private double Y;
	private double Angle;
	
	//Constructor
	/**
	 * 
	 * @param x (double / x coordinate of a robot)
	 * @param y (double / y coordinate of a robot)
	 * @param angle (double / the angle which the robot is going to move at)
	 */
	public Location(double x, double y, double angle) {
		X = x;
		Y = y;
		Angle = angle;
	}
	
	//Getters
	/**
	 * 
	 * @return X coordinate of a robot
	 */
	public double getX() {
		return X;
	}

	/**
	 * 
	 * @return Y coordinate of a robot
	 */
	public double getY() {
		return Y;
	}

	/**
	 * 
	 * @return Angle(the angle which the robot is going to move at)
	 */
	public double getAngle() {
		return Angle;
	}
				
	//Setters
	/**
	 * 
	 * @param x(double / is set equal to the X coordinate of ''this'' Location type object
	 */
	public void setX(double x) {
		X = x;
	}

	/**
	 * 
	 * @param y(double / is set equal to the Y coordinate of ''this'' Location type object
	 */
	public void setY(double y) {
		Y = y;
	}

	/**
	 * 
	 * @param angle (double / is set equal to the Angle of ''this'' Location type object
	 */
	public void setAngle(double angle) {
		Angle = angle;
	}

	/**
	 * This methods allows coordinates to be changed
	 * 
	 * @param xchange(double / the new x coordinate of a robot after it has been changed)
	 * @param ychange(double / the new y coordinate of a robot after it has been changed)
	 */
	public void moveTo(double xchange, double ychange) {
		X = xchange;
		Y = ychange;
	}

	
	/**
	 * Converts Degrees to Radians
	 * @param angle (the angle in degrees)
	 * @return The angle in radians
	 */
	public double DegreesToRadians(double angle) {
		return angle * (Math.PI / 180);
	}

	/**
	 * Converts Radians to Degrees
	 * @param rad (the angle in radians)
	 * @return The angle in degrees
	 */
	public double RadiansToDegrees(double rad) {
		return (rad * 180) / Math.PI;
	}

	/**
	 * This method changes the direction and distance which is essentially changing
	 * the x and y coordinates the "direction" parameter is an integer that
	 * expresses the angle in an integer number of degrees double d = distance , int
	 * a = angle used in formula
	 * 
	 * @param d (double / distance)
	 * @param a (int / angle used in formula)
	 */
	public void moveBy(double d, int a) {
		double xnew = this.X + (d * Math.cos(DegreesToRadians(a)));
		double ynew = this.Y + (d * Math.sin(DegreesToRadians(a)));
		moveTo(xnew, ynew);
	}

	/**
	 * This method calculates the distance between two points using the standard
	 * math equation
	 * @param x2 (double / the x coordinate of a robot)
	 * @param y2 (double / the y coordinate of a robot)
	 * @return the distance between two points
	 */
	public double distance(double x2, double y2) {
		return Math.sqrt((y2 - Y) * (y2 - Y) + (x2 - X) * (x2 - X));

	}		
		
		
		
		
}
	

