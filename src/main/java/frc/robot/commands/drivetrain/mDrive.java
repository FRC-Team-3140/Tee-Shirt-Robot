package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class mDrive extends CommandBase {
  public mDrive() {
    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double forward = RobotContainer.xbox.getSmoothedMainX();
    double strafe = RobotContainer.xbox.getSmoothedMainY();
    double rotation = RobotContainer.xbox.getSmoothedAltX();
    RobotContainer.dt.mecanumDrive(forward, strafe, rotation);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
