package frc.robot;

import frc.robot.commands.drivetrain.mDrive;
import frc.robot.commands.pneumatics.cannons.*;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pneumatics;
import frc.libs.*;
// import edu.wpi.cscore.UsbCamera;
// import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer implements Constants.ElectricalPortConstants {
  // The robot's subsystems and OI devices
 
  // Subsystems and class objects used elsewhere in the code
  //  are declared here.
  // All classes required by any class instantiated here must, be instantiated before the instatiated class.
  public static final Drivetrain dt = new Drivetrain();
  public static final Pneumatics pn = new Pneumatics();
  

  // Xbox controllers
  public static final XboxController xbox = new XboxController(xboxPrimaryDriver);

  // private UsbCamera camera;

  public RobotContainer() {
    configureButtonBindings();
    configureDefaultCommands();
  }

  private void configureButtonBindings() {
    xbox.leftBumper.whenPressed(new FireLeft());
    xbox.y.whenPressed(new FireMiddle());
    xbox.rightBumper.whenPressed(new FireRight());
  }

  private void configureDefaultCommands() {
    dt.setDefaultCommand(new mDrive());

  }

}
