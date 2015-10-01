package robot.commands;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireSalvo extends CommandGroup {
    
    public  FireSalvo()  {
    	addSequential(new FireLeft(true));
    	addSequential(new FireLeft(false));
    	addSequential(new FireMiddle(true));
    	addSequential(new FireMiddle(false));
    	addSequential(new FireRight(true));
    	addSequential(new FireRight(false));
    }
}
