/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pneumatics.cannons;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class FireLeft extends CommandBase {
  /**
   * Creates a new FireMiddle command.
   */
  public FireLeft() {
    addRequirements(RobotContainer.pn);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.pn.setLeftState(false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.pn.pulseLeft();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.pn.setLeftState(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    RobotContainer.pn.setLeftState(false);
    return true;
  }
}
