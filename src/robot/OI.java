package robot;

import library.SmartJoystick;
import library.XboxController;
import robot.commands.FireLeft;
import robot.commands.FireMiddle;
import robot.commands.FireRight;
import robot.commands.FireSalvo;
import robot.commands.Lift;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * @author Ryan Cook
 */
public class OI implements RobotMap {

	public static Joystick joystick;
	private static XboxController xbox;
	private JoystickButton toggleLights, toggleSound, fireL, fireM, fireR,
			fireS;

	/********************************************************************************
	 * Assigns joysticks to ports defined by RobotMap 
	 * Calls the assoc() method
	 * @throws InterruptedException 
	 ********************************************************************************/
	public OI() throws InterruptedException {
		xbox = new XboxController(joystick_Drive);
	}
	
	/********************************************************************************
	 * Checks the joystick to determine if a button is pressed
	 * If a button is pressed, call the designated command
	 * @throws InterruptedException
	 ********************************************************************************/
	private void check() throws InterruptedException {
		xbox.x.whenPressed(new FireLeft());
		xbox.y.whenPressed(new FireMiddle());
		xbox.b.whenPressed(new FireRight());
		xbox.a.whenPressed(new FireSalvo());
		
		xbox.dUp.whenActive(new Lift(0.5));
		xbox.dUp.whenInactive(new Lift(0.0));
		xbox.dDown.whenActive(new Lift(-0.5));
		xbox.dDown.whenInactive(new Lift(0.0));
		
		
		
	}
	
	/********************************************************************************
	 * Methods for getting the joystick(s)
	 * Allows other classes to use value of joystick input
	 ********************************************************************************/
	
	public static XboxController getXbox() {
		return xbox;
	}

}
