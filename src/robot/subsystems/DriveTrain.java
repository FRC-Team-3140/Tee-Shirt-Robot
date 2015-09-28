package robot.subsystems;

import robot.OI;
import robot.Robot;
import robot.RobotMap;
import robot.commands.MecanumDrive;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This subsystem is the literal base of the robot, its is of course the drivetrain,
 * the drivetrain interprets the joystick input and coordinates the wheel to do the
 * correct action(s).
 * 
 * @author Ryan Cook
 */
public class DriveTrain extends Subsystem implements RobotMap {
    
	private static DriveTrain instance;
	private final PowerDistributionPanel pdp;
	private double maxV, fLT, fRT, bLT, bRT;
	RobotDrive dT;
	private Timer timer;
	
	/*******************************************************************************
	 * Constructor for the DriveTrain subsystem including all its components:
	 * -Talons are assigned ports and initialized
	 * -Encoders* ;-;
	 * -Appropriate values are given to the SmartDashboard
	 *******************************************************************************/
	private DriveTrain() {
		dT = new RobotDrive(fL_Talon, fR_Talon, bL_Talon, bR_Talon);
		
		/*
		fL = new Talon(fL_Talon);
		fR = new Talon(fR_Talon);
		bL = new Talon(bL_Talon);
		bR = new Talon(bR_Talon);
		*/
		
		pdp = new PowerDistributionPanel();

	}
	
	/*******************************************************************************
	 * The singleton used by the subsystem, prevents the constructor for running more
	 * than once.
	 *******************************************************************************/
	public static DriveTrain getInstance() {
		if (instance == null) {
			instance = new DriveTrain();
		}
		return instance;
	}
	
	/*******************************************************************************
	 * Code used to drive the mecanum wheels correctly
	 * Calculates direction wheels need to turn from joystick input
	 * An explanation for how this works can be found here:
	 * http://thinktank.wpi.edu/resources/346/ControllingMecanumDrive.pdf
	 *******************************************************************************/
	public void mecanumDrive() {
        dT.mecanumDrive_Cartesian(OI.getXbox().getLeftX(), OI.getXbox().getRightX(), OI.getXbox().getLeftY(),0.0);
        logPower();
         
	}
	
	/*******************************************************************************
	 * Logs the power from the pdp and outputs the data to the SmartDashboard
	 *******************************************************************************/
	public void logPower() {
		SmartDashboard.putNumber("Front-left power: ", pdp.getCurrent(p_FL_Talon));
		SmartDashboard.putNumber("Front-right power: ", pdp.getCurrent(p_FR_Talon));
		SmartDashboard.putNumber("Back-left power: ", pdp.getCurrent(p_BL_Talon));
		SmartDashboard.putNumber("Back-right power: ", pdp.getCurrent(p_BL_Talon));
	}
    public void initDefaultCommand() {
       setDefaultCommand(new MecanumDrive());
    }

}

