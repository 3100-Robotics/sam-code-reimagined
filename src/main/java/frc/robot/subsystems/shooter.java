package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class shooter extends SubsystemBase{
    public static WPI_TalonFX shooter = new WPI_TalonFX(Constants.motorConstants.shooterMotorPort);

    public shooter() {
        shooter.configFactoryDefault();
        shooter.setNeutralMode(NeutralMode.Coast);

        shooter.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        shooter.setInverted(true);
    }

    public void runShooter(double speed) {
        shooter.set(speed);
    }

    public void stopShooter() {
        shooter.stopMotor();
    }
}
