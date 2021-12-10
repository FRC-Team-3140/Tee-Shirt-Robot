package frc.robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;


public interface HardwareAdapter extends Constants.ElectricalPortConstants {
    // Other CAN
    public static final PowerDistributionPanel pdp = new PowerDistributionPanel(PDP);
    // Drivetrain
    public static final Talon frontLeftMotor = new Talon(fL_Talon);
    public static final Talon frontRightMotor = new Talon(fR_Talon);
    public static final Talon backLeftMotor = new Talon(bL_Talon);
    public static final Talon backRightMotor = new Talon(bR_Talon);
    public static final Talon liftMotor = new Talon(lift_Talon);


    // Pnuematics
    // public static final Compressor compressor = new Compressor(PCM);
    // public static final Solenoid leftSolenoid = new Solenoid(l_Solenoid, PCM);
    // public static final Solenoid middleSolenoid = new Solenoid(m_Solenoid, PCM);
    // public static final Solenoid rightSolenoid = new Solenoid(r_Solenoid, PCM);
    
    // Gyro
    // public static final AHRS navx = new AHRS(SPI.Port.kMXP);
    
}
