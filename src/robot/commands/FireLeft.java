package robot.commands;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 *
 */
public class FireLeft extends Command {
	
    public FireLeft(boolean fire) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.air);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
			Robot.air.LeftShot(false);
			Robot.air.LeftShot(true);
			Robot.air.LeftShot(false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
