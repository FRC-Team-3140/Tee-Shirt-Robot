package org.usfirst.frc.team3140.robot.subsystems;

import org.usfirst.frc.team3140.robot.OI;
import org.usfirst.frc.team3140.robot.RobotMap;
import org.usfirst.frc.team3140.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
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
	protected final Talon fL, fR, bL, bR;
	private final PowerDistributionPanel pdp;
	private double maxV, fLT, fRT, bLT, bRT;
	private Timer timer; // Might need this, idk
	
	/*******************************************************************************
	 * Constructor for the DriveTrain subsystem including all its components:
	 * -Talons are assigned ports and initialized
	 * -Encoders* ;-;
	 * -Appropriate values are given to the SmartDashboard
	 *******************************************************************************/
	private DriveTrain() {
		fL = new Talon(fL_Talon);
		fR = new Talon(fR_Talon);
		bL = new Talon(bL_Talon);
		bR = new Talon(bR_Talon);
		
		pdp = new PowerDistributionPanel();
		
		timer = new Timer();
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
		fLT = OI.getJoystick().getSmartMag() * Math.sin(OI.getJoystick().getDirectionRadians() + (Math.PI / 8)) + OI.getRotation().getSmartRotation();
		fRT = OI.getJoystick().getSmartMag() * Math.sin(OI.getJoystick().getDirectionRadians() + (Math.PI / 8)) - OI.getRotation().getSmartRotation();
		bLT = OI.getJoystick().getSmartMag() * Math.sin(OI.getJoystick().getDirectionRadians() + (Math.PI / 8)) + OI.getRotation().getSmartRotation();
		bRT = OI.getJoystick().getSmartMag() * Math.sin(OI.getJoystick().getDirectionRadians() + (Math.PI / 8)) - OI.getRotation().getSmartRotation();
		
        maxV = Math.max(
        		Math.max(Math.abs(fLT), Math.abs(fRT)), 
        		Math.max(Math.abs(bLT), Math.abs(bRT)));
        
        if(maxV>1) {
        	fLT = fLT / maxV;
        	fRT = fRT / maxV;
        	bLT = bLT / maxV;
        	bRT = bRT / maxV;
        }
        
        fL.set(-fLT);
        fR.set(fRT);
        bL.set(-bLT);
        bR.set(bRT);
        
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

