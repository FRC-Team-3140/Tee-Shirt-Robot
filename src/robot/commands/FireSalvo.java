package robot.commands;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireSalvo extends CommandGroup {
    
    public  FireSalvo() throws InterruptedException {
    	addSequential(new FireLeft());
    	TimeUnit.SECONDS.sleep(1);
    	addSequential(new FireMiddle());
    	TimeUnit.SECONDS.sleep(1);
    	addSequential(new FireRight());
    }
}
