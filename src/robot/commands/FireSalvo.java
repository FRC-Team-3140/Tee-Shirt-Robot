package robot.commands;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireSalvo extends CommandGroup {
    
    public  FireSalvo(double timeout)  {
    	addSequential(new FireLeft(), timeout);
    	addSequential(new FireMiddle(), timeout);
    	addSequential(new FireRight(), timeout);
    }
}
