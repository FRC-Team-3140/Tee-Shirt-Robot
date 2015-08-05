package org.usfirst.frc.team3140.robot;

import org.usfirst.frc.team3140.robot.commands.FireLeft;
import org.usfirst.frc.team3140.robot.commands.FireMiddle;
import org.usfirst.frc.team3140.robot.commands.FireRight;
import org.usfirst.frc.team3140.robot.commands.FireSalvo;
import org.usfirst.frc.team3140.robot.commands.MediaCtrl;

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
	private JoystickButton toggleLights, toggleSound, fireL, fireM, fireR,
			fireS, play1, play2, play3, play4, play5, play6;

	/********************************************************************************
	 * Assigns joysticks to ports defined by RobotMap 
	 * Calls the assoc() method
	 * @throws InterruptedException 
	 ********************************************************************************/
	public OI() throws InterruptedException {
		smartJoystick = new SmartJoystick(joystick_Drive);
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
		fireL = new JoystickButton(smartJoystick, fire_Left);
		fireM = new JoystickButton(smartJoystick, fire_Middle);
		fireR = new JoystickButton(smartJoystick, fire_Right);
		fireS = new JoystickButton(smartJoystick, fire_Salvo);
		//play1 = new JoystickButton(smartJoystick, play_1);
		//play2 = new JoystickButton(smartJoystick, play_2);
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
	private void check() throws InterruptedException {
		//ToggleLights.whenPressed(new FireShot());
		toggleSound.whenPressed(new MediaCtrl("Toggle"));
		fireL.whenPressed(new FireLeft());
		fireM.whenPressed(new FireMiddle());
		fireR.whenPressed(new FireRight());
		fireS.whenPressed(new FireSalvo());
		//play1.whenPressed(new MediaCtrl("Alpha"));
		//play2.whenPressed(new MediaCtrl("Bravo"));
		//play3.whenPressed(new MediaCtrl("Charlie"));
		//play4.whenPressed(new MediaCtrl("Delta"));
		//play5.whenPressed(new MediaCtrl("Echo"));
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
	
	public static SmartJoystick getPOV() {
		return smartJoystick;
		
	}

}
