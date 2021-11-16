package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.HardwareAdapter;
// import frc.robot.Constants;
// import frc.robot.commands.drivetrain.mDrive;

public class Drivetrain extends SubsystemBase implements HardwareAdapter{
  private MecanumDrive dT;

  public Drivetrain() {
    // backLeftMotor.setInverted(true);
    // frontRightMotor.setInverted(true);
    dT = new MecanumDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

  }

  /***********
   * DRIVING *
   ***********/
  public void mecanumDrive(double forwardComponent, double strafeComponent, double rotationComponent){
    dT.driveCartesian(forwardComponent, strafeComponent, rotationComponent);
  }

}
