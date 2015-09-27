package robot.subsystems;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.RobotMap;
import robot.commands.FireLeft;

/**
 *
 */
public class Pneumatics extends Subsystem implements RobotMap {
	
	private int Shots = 3;

	private static Pneumatics instance;
	private DoubleSolenoid left, middle, right;
	private Compressor comp;

	/*******************************************************************************
	 * Constructor for the Pneumatics subsystem including all its components:
	 * -Compressor is initialized and started -Solenoids are assigned ports and
	 * initialized
	 *******************************************************************************/
	public Pneumatics() {
		comp = new Compressor();
		comp.start();
		left = new DoubleSolenoid(l_Solenoid_A, l_Solenoid_B);
		middle = new DoubleSolenoid(m_Solenoid_A, m_Solenoid_B);
		right = new DoubleSolenoid(r_Solenoid_A, r_Solenoid_B);
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
		left.set(OPEN);
		TimeUnit.SECONDS.sleep(1);
		left.set(CLOSED);
	}
	
	// Fires the middile-barrel
	public void MiddleShot() throws InterruptedException {
		middle.set(OPEN);
		TimeUnit.SECONDS.sleep(1);
		middle.set(CLOSED);
	}
	
	// Fires the right-barrel
	public void RightShot() throws InterruptedException {
		right.set(OPEN);
		TimeUnit.SECONDS.sleep(1);
		right.set(CLOSED);
	}
	

	public void initDefaultCommand() {
		setDefaultCommand(new FireLeft());
		// setDefaultCommand(new MySpecialCommand());
	}
}
