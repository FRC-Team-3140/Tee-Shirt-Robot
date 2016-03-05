package robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import library.HatSwitch;
import library.SmartJoystick;
//import robot.commands.CloseValves;
import robot.commands.Lift;
import robot.commands.FireLeft;
import robot.commands.FireMiddle;
import robot.commands.FireRight;
import robot.commands.FireSalvo;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * @author Ryan Cook
 */
public class OI implements RobotMap {

	public static Joystick joystick;
	private static SmartJoystick smartJoystick;
	private static HatSwitch pov;
	private JoystickButton toggleLights, toggleSound, fireL, fireM, fireR,
			fireS, lUp, lDown;

	/********************************************************************************
	 * Assigns joysticks to ports defined by RobotMap 
	 * Calls the assoc() method
	 * @throws InterruptedException 
	 ********************************************************************************/
	public OI() throws InterruptedException {
		smartJoystick = new SmartJoystick(joystick_Drive);
		pov = new HatSwitch(smartJoystick);
		assoc();
	}

	/********************************************************************************
	 * Initializes buttons and assigns them buttons defined by RobotMap 
	 * Calls the check() method
	 * @throws InterruptedException 
	 ********************************************************************************/
	private void assoc() throws InterruptedException {
		//toggleLights = new JoystickButton(smartJoystick, toggle_Lights);
		toggleSound = new JoystickButton(smartJoystick, toggle_Sound);
		fireL = new JoystickButton(smartJoystick, 5);
		fireM = new JoystickButton(smartJoystick, 3);
		fireR = new JoystickButton(smartJoystick, 4);
		fireS = new JoystickButton(smartJoystick, 6);
		lUp = new JoystickButton(smartJoystick, 1);
		lDown = new JoystickButton(smartJoystick,2);
		//play3 = new JoystickButton(smartJoystick, play_3);
		//play4 = new JoystickButton(smartJoystick, play_4);
		//play5 = new JoystickButton(smartJoystick, play_5);
		//play6 = new JoystickButton(smartJoystick, play_6);
		check();
	}
	
	/********************************************************************************
	 * Checks the joystick to determine if a button is pressed
	 * If a button is pressed, call the designated command
	 * @throws InterruptedException
	 ********************************************************************************/
	private void check() {
		fireL.whenPressed(new FireLeft());
		//fireL.whenReleased(new CloseValves());
		fireM.whenPressed(new FireMiddle());
		//fireM.whenReleased(new CloseValves());
		fireR.whenPressed(new FireRight());
		//fireS.whenReleased(new FireSalvo(1));
	//	fireS.whenReleased(new CloseValves());
		
		lUp.whenPressed(new Lift(0.25));
		lUp.whenReleased(new Lift(0));
		lDown.whenPressed(new Lift(-0.25));
		lDown.whenReleased(new Lift(0));
	}
	
	/********************************************************************************
	 * Methods for getting the joystick(s)
	 * Allows other classes to use value of joystick input
	 ********************************************************************************/
	
	public static SmartJoystick getJoystick() {
		return smartJoystick;
	}

}
