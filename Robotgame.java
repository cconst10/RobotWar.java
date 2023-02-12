import java.util.*;

/**
 * @author Christodoulos Constantinou
 * @version 1.0
 * This is the driver class for the game. It controls the movement and behavior of the player Robot.
 * Also it keeps count of enemy robots that have been killed
 * 
 *
 */

public class Robotgame {
    
	/**
     * This method realizes if all enemy robots in a new array of robot objects are dead
     * @param An array of robot objects
     * @return a boolean indicating if all enemy robots are dead or not
     */
	private static boolean allDead(Robot z []) {
		//true = allDead
		boolean result = true;
		for(int i = 0; i < z.length; i++) {
			if(z[i].getStatus()) {
				return false;
			}
		}
		return result;
	}
	/**
	 * The Player Robot checks if there are any enemy robots in the same square as him and if so eliminates them
	 * If not he moves to a random location
	 * @param angle(the angle which the robot is going to move at)
	 * @param location(A location type object)
	 * @return found (boolean type - returns true/false if the robot has found an enemy robot or not)  
	 */
	private static boolean checkDistance(int angle, Location location, double distance) {
		boolean found = false;
		
		double nx = location.getX() + distance * Math.cos(location.DegreesToRadians(angle));
        double ny = location.getY() + distance * Math.sin(location.DegreesToRadians(angle));
			
			
			if(angle >= 0 && angle <= 90) {
			   if(nx < 10 && ny < 10) {
				   found = true;
			   }
			}else if(angle >= 91 && angle <= 180) {
			   if(nx > 0 && ny < 10) {
				   found = true;
			   }
			}else if(angle >=181 && angle <= 270) {
			   if(nx > 0 && ny > 0) {
				   found = true;
			   }
			}else {
				if(nx < 10 && ny > 0) {
					found = true;
				}
				
			}
			
		return found;
    }
	
	public static void main(String[] args) 
    {
		
    
        if ((args.length != 3 && args.length != 4)) 
        {
           System.out.println("Wrong number of arguements entered!: ");
           System.out.println("Usage: Robotgame double double int ");
           System.out.println("Usage: Robotgame double double int long ");
           System.exit(0); 
        }
        
        double X = Double.parseDouble(args[0]);
        double Y = Double.parseDouble(args[1]);
        int count = Integer.parseInt(args[2]);
        long seed = 0;
        if (args.length == 4)
        {
            seed = Long.parseLong(args[3]);
        }
    
        if ((X < 0.0 || X > 9.9) || (Y < 0.0 || Y > 9.9) || (count < 1 || count > 100) || (seed < 0))
        {
           System.out.println("X , Y need to be between 0 - 9.9");
           System.out.println("Count need to be between 1 - 100");
           System.out.println("Seed needs to be greater than 0");
           System.exit(0);
        }
        
        //Generates a random seed
        new java.util.Random(seed);
    
        Robot r1[] = new Robot [count];
        Robot player = new Robot(X, Y, true, true);
        Location playerLocation = new Location (X, Y, 0);
        double useless = Math.random();
        for(int i = 0; i < count; i++)
        {
                r1[i] = new Robot(Math.random() * 10, Math.random() * 10, true, false);
                System.out.println(r1[i]);    
        }
    
        Scanner input =  new Scanner (System.in);
        Battlefield field = new Battlefield();
        System.out.println("Welcome to Robot War!!!");
        field.printBattleField(r1, player);
        
            
        while(!allDead(r1)) 
        {
            int angle = 0;
            boolean error = false;
            double distance = 0;
            try
            {
                System.out.print("Insert angle: ");
                angle = input.nextInt();
                System.out.print("Insert distance: ");
                distance = input.nextDouble();
            }
            catch (Exception e)
            {
                error = true;
            }
            if (error == true) 
            {
               System.out.println("Invalid distance or angle !");
            }
            else {
                
            } // end of if-else
            {
                if(!checkDistance(angle,playerLocation,distance) || (angle<0 || angle>359))
                {
                  System.out.println("Invalid move or invalid angle");
                } 
                else 
                {
                    // Moving the player robot
                    playerLocation.moveBy(distance, angle);
                    player.setX(playerLocation.getX());
                    player.setY(playerLocation.getY());
                    field.printBattleField(r1, player);
                    System.out.println("..................................................");
                }
            }
        }
        System.out.println("All enemies killed. Congatulations you won!");
    }
	}


