package robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;

/**
 *
 */
public class Elevator extends Subsystem implements RobotMap {
	
	public static Elevator instance;
	protected final Talon lift;
	private final PowerDistributionPanel pdp;
	private Timer timer;
	
	private Elevator() {
		lift = new Talon(lift_Talon);
		
		pdp = new PowerDistributionPanel();
		
		timer = new Timer();
	}

	public static Elevator getInstance() {
		if (instance == null) {
			instance = new Elevator();
		}
		return instance;
	}
	
	public void driveLifter(double speed) {
		lift.set(speed);
		
		logPower();
	}
	
	public void logPower() {
		SmartDashboard.putNumber("Lifter power: ", pdp.getCurrent(p_Lift_Talon));
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

