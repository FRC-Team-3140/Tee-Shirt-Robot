package org.usfirst.frc.team3140.robot.subsystems;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team3140.robot.RobotMap;
import org.usfirst.frc.team3140.robot.commands.FireLeft;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem implements RobotMap {
	
	private int Shots = 3;

	private static Pneumatics instance;
	private Solenoid left, middle, right;
	private Compressor comp;

	/*******************************************************************************
	 * Constructor for the Pneumatics subsystem including all its components:
	 * -Compressor is initialized and started -Solenoids are assigned ports and
	 * initialized
	 *******************************************************************************/
	public Pneumatics() {
		comp = new Compressor();
		comp.start();
		left = new Solenoid(l_Solenoid);
		middle = new Solenoid(m_Solenoid);
		right = new Solenoid(r_Solenoid);

	}

	/*******************************************************************************
	 * The singleton used by the subsystem, prevents the constructor for running
	 * more than once.
	 *******************************************************************************/
	public static Pneumatics getInstance() {
		if (instance == null) {
			instance = new Pneumatics();
		}
		return instance;
	}
	
	/*******************************************************************************
	 * Code used to fire the cannons
	 * @throws InterruptedException 
	 *******************************************************************************/
	// Fires the left-barrel
	public void LeftShot() throws InterruptedException {
		left.set(true);
		TimeUnit.SECONDS.sleep(1);
		left.set(false);
	}
	
	// Fires the middile-barrel
	public void MiddleShot() throws InterruptedException {
		middle.set(true);
		TimeUnit.SECONDS.sleep(1);
		middle.set(false);
	}
	
	// Fires the right-barrel
	public void RightShot() throws InterruptedException {
		right.set(true);
		TimeUnit.SECONDS.sleep(1);
		right.set(true);
	}
	

	public void initDefaultCommand() {
		setDefaultCommand(new FireLeft());
		// setDefaultCommand(new MySpecialCommand());
	}
}
