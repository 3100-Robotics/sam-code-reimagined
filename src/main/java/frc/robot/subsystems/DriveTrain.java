package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DriveTrain extends SubsystemBase{
    
  TalonFXConfiguration _leftConfig = new TalonFXConfiguration();
  TalonFXConfiguration _rightConfig = new TalonFXConfiguration();

  TalonFXInvertType _rightInvert = TalonFXInvertType.Clockwise;

  public static WPI_TalonFX frontLeft = new WPI_TalonFX(Constants.motorConstants.frontLeftDrivePort);
  public static WPI_TalonFX rearLeft = new WPI_TalonFX(Constants.motorConstants.backLeftDrivePort);

  public static WPI_TalonFX frontRight = new WPI_TalonFX(Constants.motorConstants.frontRightDrivePort);
  public static WPI_TalonFX rearRight = new WPI_TalonFX(Constants.motorConstants.backRightDrivePort);

  static DifferentialDrive diffDrive = new DifferentialDrive(frontLeft, frontRight);

  public DriveTrain() {
    // initialize
    setupDrivetrainMotors();
    resetEncoders();
  }

  public void arcadeDrive(double speed, double rotation) {
    // drive!
    diffDrive.arcadeDrive(speed, rotation);
  }

  public void stop() {
    // STOP
    diffDrive.stopMotor();
  }

  public void resetEncoders() {
    // reset the encoders
    frontRight.getSensorCollection().setIntegratedSensorPosition(0, 10);
    frontLeft.getSensorCollection().setIntegratedSensorPosition(0, 10);
  }

  public void setupDrivetrainMotors() {
    //set up the motors

    TalonFXConfiguration configs = new TalonFXConfiguration();

    // reset configs
    frontLeft.configFactoryDefault();
    rearLeft.configFactoryDefault();
    frontRight.configFactoryDefault();
    rearRight.configFactoryDefault();

    // enable safety
    frontLeft.setSafetyEnabled(false);
    rearLeft.setSafetyEnabled(false);
    frontRight.setSafetyEnabled(false);
    rearRight.setSafetyEnabled(false);
    

    // _leftConfig.primaryPID.selectedFeedbackSensor = TalonFXFeedbackDevice.IntegratedSensor.toFeedbackDevice();
    // _rightConfig.remoteFilter0.remoteSensorDeviceID = frontLeft.getDeviceID(); // Device ID of Remote Source
    // _rightConfig.remoteFilter0.remoteSensorSource = RemoteSensorSource.TalonFX_SelectedSensor; // Remote Source Type

    // setRobotDistanceConfigs(_rightInvert, _rightConfig);
    // configs.primaryPID.selectedFeedbackSensor = FeedbackDevice.IntegratedSensor;

    // frontLeft.configAllSettings(configs);
    // frontRight.configAllSettings(configs);

    // Determines which motors will be inverted

    // invert the right motors
    frontLeft.setInverted(false);
    rearLeft.setInverted(false);
    frontRight.setInverted(true);
    rearRight.setInverted(true);

    // Sets the motors to brake mode
    frontLeft.setNeutralMode(NeutralMode.Brake);
    rearLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);
    rearRight.setNeutralMode(NeutralMode.Brake);

    rearLeft.follow(frontLeft);
    rearRight.follow(frontRight);

    frontLeft.configPeakOutputForward(1.0);
    frontLeft.configPeakOutputReverse(-1.0);

    frontRight.configPeakOutputForward(1.0);
    frontRight.configPeakOutputReverse(-1.0);

    frontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    frontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    //Might break
    frontLeft.setSensorPhase(true);
    frontRight.setSensorPhase(true);

    frontLeft.setSelectedSensorPosition(0);
    frontRight.setSelectedSensorPosition(0);

    // Add PID constants
    frontLeft.config_kP(0, 0);
    frontLeft.config_kI(0, 0);
    frontLeft.config_kD(0, 0);
    frontLeft.config_kF(0, 0);
    // leftMotorLeader.configMaxIntegralAccumulator(0, 400);

    frontRight.config_kP(0, 0);
    frontRight.config_kI(0, 0);
    frontRight.config_kD(0, 0);
    frontRight.config_kF(0, 0);
    // rightMotorLeader.configMaxIntegralAccumulator(0, 400);
 
    frontLeft.setIntegralAccumulator(0);
    frontRight.setIntegralAccumulator(0);
  }
}
