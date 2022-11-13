// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.autonomous.autonomous;
import frc.robot.commands.CLIMB;
import frc.robot.commands.collectorVroom;
import frc.robot.commands.vroomVroom;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.climber;
import frc.robot.subsystems.collector;
import frc.robot.subsystems.shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // define subsystems for button commands
  public shooter Shooter = new shooter();
  public collector Collector = new collector();
  public climber Climber = new climber();
  public DriveTrain Drive = new DriveTrain();

  // define the channel the pcm is on
  // public static final PneumaticsControlModule PCM = new PneumaticsControlModule(41);

  // define controllers
  public XboxController driveController = new XboxController(0);
  public XboxController coDriveController = new XboxController(1);

  // define the needed buttons for comands
  final JoystickButton shooterButton = new JoystickButton(coDriveController,
  Constants.IOConstants.leftBumperChannel);
  final JoystickButton collectorMotorButton = new JoystickButton(coDriveController,
  Constants.IOConstants.aButtonChannel);

  final JoystickButton reverseIntakeButton = new JoystickButton(coDriveController,
  Constants.IOConstants.yButtonChannel);

  final JoystickButton climberpnematicsButton = new JoystickButton(coDriveController,
  Constants.IOConstants.startButtonChannel);
  
  final JoystickButton collectorUpButton = new JoystickButton(coDriveController, 
  Constants.IOConstants.xButtonChannel);
  final JoystickButton collectorDownButton = new JoystickButton(coDriveController, 
  Constants.IOConstants.bButtonChannel);

  //////////////
  // commands //
  //////////////

  StartEndCommand runShooter = new StartEndCommand(
    () -> Shooter.runShooter(0.7),
    () -> Shooter.stopShooter(),
    Shooter);

  StartEndCommand reverseShooter = new StartEndCommand(
    () -> Shooter.runShooter(-0.5),
    () -> Shooter.stopShooter(),
  Shooter);

  InstantCommand toggleClimber = new InstantCommand(
    () -> Climber.toggleClimber(),
  Climber);

  StartEndCommand runCollector = new StartEndCommand(
    () -> Collector.runCollector(0.5),
    () -> Collector.stopCollector(),
  Collector);

  StartEndCommand reverseCollector = new StartEndCommand(
    () -> Collector.runCollector(-0.5),
    () -> Collector.stopCollector(),
  Collector);

  StartEndCommand runCollectorUp = new StartEndCommand(
    () -> Collector.runCollectorUpDown(0.5), 
    () -> Collector.stopCollectorUpDown(),
  Collector);

  StartEndCommand runCollectorDown = new StartEndCommand(
    () -> Collector.runCollectorUpDown(-0.5), 
    () -> Collector.stopCollectorUpDown(),
  Collector);
  
  /////////////////
  // no commands //
  ////////////////

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // set up camera server
    CameraServer.startAutomaticCapture();

    // configure drivetrain and climber controll commands
    // Collector.setDefaultCommand(new collectorVroom(Collector, coDriveController));
    // if you want joystick collector up down uncomment this this ^
    Drive.setDefaultCommand(new vroomVroom(Drive, driveController));
    Climber.setDefaultCommand(new CLIMB(Climber, coDriveController));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // bind commands to buttons
    shooterButton.whileHeld(runShooter);
    climberpnematicsButton.whenPressed(toggleClimber);
    collectorMotorButton.whileHeld(runCollector);
    reverseIntakeButton.whileHeld(reverseCollector);
    reverseIntakeButton.whileHeld(reverseShooter);
    collectorUpButton.whileHeld(runCollectorUp);
    collectorDownButton.whileHeld(runCollectorDown);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // giving the autonomous command
    return new autonomous(Drive, Shooter, Collector, 0.5, 0.5, Constants.autonomousConstants.encoderScale*1000, 270, Constants.autonomousConstants.encoderScale*1000, 1, 2);
  }
}
