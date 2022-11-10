package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class climber extends SubsystemBase{
    public static WPI_TalonFX LClimber = new WPI_TalonFX(Constants.ClimberConstants.leftClimberMotorPort);
    public static WPI_TalonFX RClimber = new WPI_TalonFX(Constants.ClimberConstants.rightClimberMotorPort);

    public static final Solenoid ClimberSolenoid = new
    Solenoid(PneumaticsModuleType.CTREPCM, 6);

    public climber() {
        LClimber.configFactoryDefault();
        RClimber.configFactoryDefault();
       
        // soft limits. doesn't work right now fix later
        RClimber.configForwardSoftLimitEnable(true, Constants.ClimberConstants.kCANTimeoutMs);
        RClimber.configReverseSoftLimitEnable(true, Constants.ClimberConstants.kCANTimeoutMs);


        LClimber.setNeutralMode(NeutralMode.Brake);
        RClimber.setNeutralMode(NeutralMode.Brake);

        LClimber.follow(RClimber);

        // more soft limits
        SoftLimitSetup();

        LClimber.setSelectedSensorPosition(0);
        RClimber.setSelectedSensorPosition(0);
    }

    public void runClimber(double speed) {
        RClimber.set(speed);
        // LClimber.set(speed);
    }

    public void stopClimber() {
        RClimber.stopMotor();
        // LClimber.stopMotor();
    }

    public void toggleClimber() {
        ClimberSolenoid.toggle();
    }

    void SoftLimitSetup() {
        // more soft limits

        /* select local quadrature if using Talon FX */
        LClimber.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,
                Constants.ClimberConstants.PID_PRIMARY,
                Constants.ClimberConstants.kCANTimeoutMs);
        RClimber.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,
                Constants.ClimberConstants.PID_PRIMARY,
                Constants.ClimberConstants.kCANTimeoutMs);
       

        /* select limits */
        // LClimber.configForwardSoftLimitThreshold(Constants.ClimberConstants.kLeftForwardSoftLimit_Quad,
        //  Constants.ClimberConstants.kCANTimeoutMs);
        RClimber.configForwardSoftLimitThreshold(Constants.ClimberConstants.kRightForwardSoftLimit_Quad,
         Constants.ClimberConstants.kCANTimeoutMs);
        // LClimber.configReverseSoftLimitThreshold(Constants.ClimberConstants.kLeftReverseSoftLimit_Quad,
        //  Constants.ClimberConstants.kCANTimeoutMs);
        RClimber.configReverseSoftLimitThreshold(0,
         Constants.ClimberConstants.kCANTimeoutMs);
    }
}
