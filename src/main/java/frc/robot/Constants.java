package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 */

// Use meters, seconds, degrees (180deg to -180deg) (CCWP), and volts for all units.
public interface Constants {
	// Use meters, seconds, degrees (180deg to -180deg) (CCWP), and volts for all units.
	public interface GeneralConstants {
		// Pnuematics
		public final static Value EXT = Value.kForward;
		public final static Value RET = Value.kReverse;
		public final static Value OFF = Value.kOff;
		// OI
		public final static double DEADBAND = 0.1;

	}///////////////////////////

	public interface ElectricalPortConstants {
		// Xbox Controllers
		public static final int xboxPrimaryDriver = 0;

		// Other Can Bus
		public final static int PDP = 8;
		public final static int PCM = 1;

		/******************
		 * MOTOR CHANNELS *
		 ******************/
		// Ports for the talons
		public static final int fL_Talon = 8;
		public static final int fR_Talon = 7;
		public static final int bL_Talon = 9;
		public static final int bR_Talon = 6;
		public static final int lift_Talon = 5;

		/***************
		 * DIGITAL I/O *
		 ***************/
		// Ports for PDP feedback 
		// NOTE: THIS MIGHT NOT BE UP TO DATE. Check the and then: fix these definitions as needed and then remove this comment
		public static final int p_FL_Talon = 0;
		public static final int p_FR_Talon = 15;
		public static final int p_BL_Talon = 3;
		public static final int p_BR_Talon = 12;
		public static final int p_Lift_Talon = 13;

		// Pnuematic solenoids (the valves that let air into the cannons)
		public final static int r_Solenoid =1;
		public final static int m_Solenoid = 0;
		public final static int l_Solenoid = 2;
	}
}