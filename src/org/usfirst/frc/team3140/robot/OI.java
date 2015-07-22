package org.usfirst.frc.team3140.robot;

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
	private static SmartJoystick smartJoystick;
	private JoystickButton fireShot, fireSalvo, toggleL, light1, light2,
			light3, play1, play2, play3, play4, play5, play6;

	/********************************************************************************
	 * Assigns joysticks to ports defined by RobotMap 
	 * Calls the assoc() method
	 ********************************************************************************/
	public OI() {
		smartJoystick = new SmartJoystick(joystick_Drive);
		assoc();
	}

	/********************************************************************************
	 * Initializes buttons and assigns them buttons defined by RobotMap 
	 * Calls the check() method
	 ********************************************************************************/
	private void assoc() {
		fireShot = new JoystickButton(smartJoystick, fire_Shot);
		fireSalvo = new JoystickButton(smartJoystick, fire_Salvo);
		toggleL = new JoystickButton(smartJoystick, toggle_L);
		light1 = new JoystickButton(smartJoystick, light_1);
		light2 = new JoystickButton(smartJoystick, light_2);
		light3 = new JoystickButton(smartJoystick, light_3);
		play1 = new JoystickButton(smartJoystick, play_1);
		play2 = new JoystickButton(smartJoystick, play_2);
		play3 = new JoystickButton(smartJoystick, play_3);
		play4 = new JoystickButton(smartJoystick, play_4);
		play5 = new JoystickButton(smartJoystick, play_5);
		play6 = new JoystickButton(smartJoystick, play_6);
		check();
	}
	
	/********************************************************************************
	 * Checks the joystick to determine if a button is pressed
	 * If a button is pressed, call the designated command
	 * @throws InterruptedException
	 ********************************************************************************/
	private void check() {
		// TO-DO
	}
	
	/********************************************************************************
	 * Methods for getting the joystick(s)
	 * Allows other classes to use value of joystick input
	 ********************************************************************************/
	public static SmartJoystick getJoystick() {
		return smartJoystick;
	}

	public static SmartJoystick getRotation() {
		return smartJoystick;
	}

}
