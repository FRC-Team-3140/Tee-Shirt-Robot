package robot.subsystems;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.RobotMap;
import robot.commands.CloseValves;
import robot.commands.FireLeft;

/**
 *
 */
public class Pneumatics extends Subsystem implements RobotMap {
	//public boolean safe = false;

	private static Pneumatics instance;
	private Solenoid left, middle, right;

	/*******************************************************************************
	 * Constructor for the Pneumatics subsystem including all its components:
	 * -Compressor is initialized and started -Solenoids are assigned ports and
	 * initialized
	 *******************************************************************************/
	public Pneumatics() {
		left = new Solenoid(l_Solenoid);
		middle = new Solenoid(m_Solenoid);
		right = new Solenoid(r_Solenoid);
		//left.set(false);
		//middle.set(false);
		//right.set(false);
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
	public void LeftShot(){
			left.set(false);
			left.set(true);
	} 
	
	// Fires the middle-barrel
	public void MiddleShot() {
			middle.set(false);
			middle.set(true);
	}
	
	// Fires the right-barrel
	public void RightShot(){
			right.set(false);
			right.set(true);
	}
	
	public void closeValves(){
		left.set(false);
		middle.set(false);
		right.set(false);
	}
	

	public void initDefaultCommand() {
		setDefaultCommand(new CloseValves());
	}
	
}
