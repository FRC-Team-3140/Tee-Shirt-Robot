package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.kauailabs.navx.frc.AHRS;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

public interface HardwareAdapter extends Constants.ElectricalPortConstants {
    // Other CAN
    public static final PowerDistributionPanel pdp = new PowerDistributionPanel(PDP);
    // Drivetrain
    public static final WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(fL_Talon);
    public static final WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(fR_Talon);
    public static final WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(bL_Talon);
    public static final WPI_TalonSRX backRightMotor = new WPI_TalonSRX(bR_Talon);
    public static final WPI_TalonSRX liftMotor = new WPI_TalonSRX(lift_Talon);


    // Pnuematics
    public static final Compressor compressor = new Compressor(PCM);
    public static final Solenoid leftSolenoid = new Solenoid(l_Solenoid, PCM);
    public static final Solenoid middleSolenoid = new Solenoid(m_Solenoid, PCM);
    public static final Solenoid rightSolenoid = new Solenoid(m_Solenoid, PCM);
    
    // Gyro
    public static final AHRS navx = new AHRS(SPI.Port.kMXP);
    
}
