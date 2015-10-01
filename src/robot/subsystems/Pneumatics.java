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
	public boolean safe = true;

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
	public void LeftShot(boolean fire){
		if(safe){
		left.set(fire);
		}
	}
	
	// Fires the middle-barrel
	public void MiddleShot(boolean fire) {
		if(safe){
		middle.set(fire);
		}
	}
	
	// Fires the right-barrel
	public void RightShot(boolean fire){
		if(safe){
		right.set(fire);
		}
	}
	

	public void initDefaultCommand() {
		setDefaultCommand(null);
		// setDefaultCommand(new MySpecialCommand());
	}
}
