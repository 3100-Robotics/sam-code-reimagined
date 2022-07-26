// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.autonomous.autonomous;
import frc.robot.commands.CLIMB;
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
  // The robot's subsystems and commands are defined here...

  public shooter Shooter = new shooter();
  public collector Collector = new collector();
  public climber Climber = new climber();
  public DriveTrain drive = new DriveTrain();

  public XboxController driveController = new XboxController(0);
  public XboxController coDriveController = new XboxController(1);

  final JoystickButton shooterButton = new JoystickButton(driveController,
  Constants.IOConstants.leftBumperChannel);
  final JoystickButton toggleClimberpnematics = new JoystickButton(coDriveController,
  Constants.IOConstants.startButtonChannel);
  final JoystickButton collectorPneumaticsButton = new JoystickButton(coDriveController,
  Constants.IOConstants.backButtonChannel);
  final JoystickButton collectorMotorButton = new JoystickButton(coDriveController,
  Constants.IOConstants.aButtonChannel);
  final JoystickButton ReverseCollectorMotor = new JoystickButton(coDriveController,
  Constants.IOConstants.yButtonChannel);
  final JoystickButton ReverseShooterMOtor = new JoystickButton(coDriveController,
  Constants.IOConstants.xButtonChannel);

  //////////////
  // commands //
  //////////////

  StartEndCommand runShooter = new StartEndCommand(
    () -> Shooter.runShooter(0.7),
    () -> Shooter.stopShooter(),
    Shooter);

  InstantCommand toggleCollector = new InstantCommand(
    () -> Collector.toggleCollector(),
    Collector);
  
  InstantCommand toggleClimber = new InstantCommand(
    () -> Climber.toggleClimber(),
    Climber);
  
    StartEndCommand runCollector = new StartEndCommand(
      () -> Collector.runCollector(0.5),
      () -> Collector.stopcollector(),
    Collector);

    StartEndCommand reverseCollector = new StartEndCommand(
      () -> Collector.runCollector(-0.5),
      () -> Collector.stopcollector(),
    Collector);

    StartEndCommand reverseShooter = new StartEndCommand(
      () -> Shooter.runShooter(-0.5),
      () -> Shooter.stopShooter(),
      Shooter);
  
  /////////////////
  // no commands //
  ////////////////

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    drive.setDefaultCommand(new vroomVroom(drive, driveController));
    Climber.setDefaultCommand(new CLIMB(Climber, coDriveController));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    shooterButton.whileHeld(runShooter);
    collectorPneumaticsButton.whenPressed(toggleCollector);
    toggleClimberpnematics.whenPressed(toggleClimber);
    collectorMotorButton.whileHeld(runCollector);
    ReverseCollectorMotor.whileHeld(reverseCollector);
    ReverseShooterMOtor.whileHeld(reverseShooter);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    
    return new autonomous(drive, 0.5, 0.5, Constants.drivetrainConstants.encoderScale*1000, 270, Constants.drivetrainConstants.encoderScale*1000);
  }
}
