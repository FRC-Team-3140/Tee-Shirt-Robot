package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {
  private Command autoCommand;
  private RobotContainer robotContainer;
  private AddressableLED m_led;
  private AddressableLED f_led;
  private AddressableLEDBuffer f_ledBuffer;
  private AddressableLEDBuffer m_ledBuffer;
  private int m_rainbowFirstPixelHue = 0;
  private int f_rainbowFirstPixelHue = 0;

  // private Timer led_timer;

  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    // PWM port 9
    // Must be a PWM header, not MXP or DIO
    m_led = new AddressableLED(1);
    f_led = new AddressableLED(0);

  

    // Reuse buffer
    //length 32 for top strand, 55 for bottom
    // Default to a length of 60, start empty output
    // Length is expensive to set, so only set it once, then just update data
    m_ledBuffer = new AddressableLEDBuffer(87);
    f_ledBuffer = new AddressableLEDBuffer(55);
    m_led.setLength(m_ledBuffer.getLength());
    f_led.setLength(f_ledBuffer.getLength());
    // Set the data
    m_led.setData(m_ledBuffer);
    m_led.start();
    f_led.setData(f_ledBuffer);
    f_led.start();
    // led_timer = new Timer();
    // led_timer.start();
    robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }


  @Override
  public void teleopInit() {
    if (autoCommand != null) {
      autoCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    rainbow();
    // setonoff();
    // Set the LEDs
    m_led.setData(m_ledBuffer);
    f_led.setData(f_ledBuffer);

  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  private void rainbow() {
    // For every pixel
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      // Calculate the hue - hue is easier for rainbows because the color
      // shape is a circle so only one value needs to precess
      final var hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getLength())) % 180;      
      // Set the value
      m_ledBuffer.setHSV(i, hue, 255, 128);
    }
    for (var i = 0; i < f_ledBuffer.getLength(); i++) {
      // Calculate the hue - hue is easier for rainbows because the color
      // shape is a circle so only one value needs to precess
      final var hue = (f_rainbowFirstPixelHue + (i * 180 / f_ledBuffer.getLength())) % 180;
      // Set the value
      f_ledBuffer.setHSV(i, hue, 255, 128);
    }
    // Increase by to make the rainbow "move"
    m_rainbowFirstPixelHue += 3;
    f_rainbowFirstPixelHue += 3;
    // Check bounds
    m_rainbowFirstPixelHue %= 180;
    f_rainbowFirstPixelHue %= 180;

  }


  // private void setonoff() {
    // final double current_time=led_timer.getFPGATimestamp();
    // if (current_time%5==0){
    //   for (var i = 0; i < m_ledBuffer.getLength(); i++) {
    //   m_ledBuffer.setHSV(i, 0, 255, 255);
    //   }
    // }
    // else
    // { for (var i = 0; i < m_ledBuffer.getLength(); i++) {
    //    m_ledBuffer.setHSV(i, 0, 255, 0);
    // }
    // }
  // }
}