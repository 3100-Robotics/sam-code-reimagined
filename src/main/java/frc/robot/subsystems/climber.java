package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ClimberConstants;

public class climber extends SubsystemBase{
    public static WPI_TalonFX LClimber = new WPI_TalonFX(Constants.motorConstants.leftClimberMotorPort);
    public static WPI_TalonFX RClimber = new WPI_TalonFX(Constants.motorConstants.rightClimberMotorPort);

    public static final Solenoid ClimberSolenoid = new
    Solenoid(PneumaticsModuleType.CTREPCM,
    Constants.Pneumaticsconstants.ClimberSolenoidPort);

    public climber() {
        LClimber.configFactoryDefault();
        RClimber.configFactoryDefault();

        LClimber.configForwardSoftLimitEnable(true, Constants.kCANTimeoutMs);
        RClimber.configReverseSoftLimitEnable(true, Constants.kCANTimeoutMs);


        LClimber.setNeutralMode(NeutralMode.Brake);
        RClimber.setNeutralMode(NeutralMode.Brake);

        LClimber.follow(RClimber);

        SoftLimitSetup();

        LClimber.setSelectedSensorPosition(0);
        RClimber.setSelectedSensorPosition(0);
    }

    void SoftLimitSetup() {

        /* select local quadrature if using Talon FX */
        LClimber.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,
                Constants.PID_PRIMARY,
                Constants.kCANTimeoutMs);
                RClimber.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,
                Constants.PID_PRIMARY,
                Constants.kCANTimeoutMs);
       

        /* select limits */
        LClimber.configForwardSoftLimitThreshold(ClimberConstants.kLeftForwardSoftLimit_Quad, Constants.kCANTimeoutMs);
        RClimber.configForwardSoftLimitThreshold(ClimberConstants.kRightForwardSoftLimit_Quad, Constants.kCANTimeoutMs);
        LClimber.configReverseSoftLimitThreshold(ClimberConstants.kLeftReverseSoftLimit_Quad, Constants.kCANTimeoutMs);
        RClimber.configReverseSoftLimitThreshold(ClimberConstants.kRightReverseSoftLimit_Quad, Constants.kCANTimeoutMs);
    }

    public void runClimber(double speed) {
        LClimber.set(speed);
        RClimber.set(speed);
    }

    public void stopClimber() {
        LClimber.stopMotor();
        RClimber.stopMotor();
    }

    public void toggleClimber() {
        ClimberSolenoid.toggle();
    }
}
