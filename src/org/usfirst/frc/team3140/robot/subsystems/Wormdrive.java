package org.usfirst.frc.team3140.robot.subsystems;

import org.usfirst.frc.team3140.robot.OI;
import org.usfirst.frc.team3140.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Wormdrive extends Subsystem implements RobotMap {
	
	public static Wormdrive instance;
	protected final Talon lift;
	private final PowerDistributionPanel pdp;
	private double liftT;
	private Timer timer;
	
	private Wormdrive() {
		lift = new Talon(lift_Talon);
		
		pdp = new PowerDistributionPanel();
		
		timer = new Timer();
	}

	public static Wormdrive getInstance() {
		if (instance == null) {
			instance = new Wormdrive();
		}
		return instance;
	}
	
	public void driveLifter() {
		if (OI.getJoystick().getSmartPOV() == 0) {
			liftT = 1;
		}else if(OI.getJoystick().getSmartPOV() == 90) {
			liftT = -1;
		}
		
		lift.set(liftT);
		
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

