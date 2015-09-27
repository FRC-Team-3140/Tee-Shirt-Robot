package robot.subsystems;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.RobotMap;
import robot.commands.FireLeft;

/**
 *
 */
public class Pneumatics extends Subsystem implements RobotMap {
	public boolean safe = false;

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
		if(safe){
		left.set(true);
		TimeUnit.SECONDS.sleep(1);
		left.set(false);
		}
	}
	
	// Fires the middle-barrel
	public void MiddleShot() throws InterruptedException {
		if(safe){
		middle.set(true);
		TimeUnit.SECONDS.sleep(1);
		middle.set(false);
		}
	}
	
	// Fires the right-barrel
	public void RightShot() throws InterruptedException {
		if(safe){
		right.set(true);
		TimeUnit.SECONDS.sleep(1);
		right.set(false);
		}
	}
	

	public void initDefaultCommand() {
		setDefaultCommand(new FireLeft());
		// setDefaultCommand(new MySpecialCommand());
	}
}
