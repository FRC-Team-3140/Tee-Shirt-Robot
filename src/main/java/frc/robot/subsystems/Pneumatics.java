package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.HardwareAdapter;

public class Pneumatics extends SubsystemBase  implements Constants, HardwareAdapter {  
  public Pneumatics() {
    //make sure all valves are closed at start
    middleSolenoid.set(false);
    rightSolenoid.set(false);
    leftSolenoid.set(false);

    //when the values do fire later, how long they should fire for in seconds
    final double pulseTime=0.5;
    middleSolenoid.setPulseDuration(pulseTime);
    rightSolenoid.setPulseDuration(pulseTime);
    leftSolenoid.setPulseDuration(pulseTime);
  }
  
  //define setter functions for commands
  public void setMiddleState(Boolean v) {
    middleSolenoid.set(v);
  }

  public void setLeftState(Boolean v) {
    leftSolenoid.set(v);
  }

  public void setRightState(Boolean v) {
    rightSolenoid.set(v);
  }
  
  public void pulseRight() {
    rightSolenoid.startPulse();
  }

  public void pulseMiddle() {
    middleSolenoid.startPulse();
  }

  public void pulseLeft() {
    leftSolenoid.startPulse();
  }

  @Override
  public void periodic() {
  }
}
