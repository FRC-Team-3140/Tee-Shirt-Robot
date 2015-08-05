package org.usfirst.frc.team3140.robot.subsystems;
 import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arduino extends Subsystem implements Runnable {
	
	private static Arduino instance;
	private SerialPort arduino;
	
	 public Arduino() {
	        //initializing everything
	        arduino = new SerialPort(9600  , Port.kMXP); //Serial port for transmitting data
	    }

	    public void run() {
	        while (true) {

	        }
	    }
	    
	    public synchronized void setLightSequence(String selection){
	        sendString(selection);
	     }
	    
	    public void sendString(String selection) {
	    	arduino.writeString(selection);
	    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static Arduino getInstance() {
		if (instance == null) {
			instance = new Arduino();
		}
		return getInstance();
	}
	
}

