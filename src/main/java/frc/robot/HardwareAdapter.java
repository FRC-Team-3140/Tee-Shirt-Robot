package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TalonSRX;


public interface HardwareAdapter extends Constants.ElectricalPortConstants {
    // Other CAN
    public static final PowerDistributionPanel pdp = new PowerDistributionPanel(PDP);
    // Drivetrain
    public static final TalonSRX frontLeftMotor = new TalonSRX(fL_Talon);
    public static final TalonSRX frontRightMotor = new TalonSRX(fR_Talon);
    public static final TalonSRX backLeftMotor = new TalonSRX(bL_Talon);
    public static final TalonSRX backRightMotor = new TalonSRX(bR_Talon);
    public static final TalonSRX liftMotor = new TalonSRX(lift_Talon);


    // Pnuematics
    // public static final Compressor compressor = new Compressor(PCM);
    // public static final Solenoid leftSolenoid = new Solenoid(l_Solenoid, PCM);
    // public static final Solenoid middleSolenoid = new Solenoid(m_Solenoid, PCM);
    // public static final Solenoid rightSolenoid = new Solenoid(r_Solenoid, PCM);
    
    // Gyro
    // public static final AHRS navx = new AHRS(SPI.Port.kMXP);
    
}
