package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class collector extends SubsystemBase{

    public static CANSparkMax collector = new CANSparkMax(Constants.CollectorConstants.collectorMotorPort,
    MotorType.kBrushless);
    public static CANSparkMax conveyor = new CANSparkMax(Constants.CollectorConstants.conveyorMotorPort,
    MotorType.kBrushless);
    public static WPI_TalonFX collectorUpDown = new WPI_TalonFX(Constants.CollectorConstants.collectorUpDownPort);

    public collector() {
        // configure the motors
        collector.restoreFactoryDefaults();
        collector.setIdleMode(IdleMode.kBrake);
        conveyor.restoreFactoryDefaults();
        conveyor.setIdleMode(IdleMode.kBrake);
    }

    public void runCollector(double speed) {
        collector.set(speed);
        conveyor.set(speed);
    }

    public void stopCollector() {
        collector.stopMotor();
        conveyor.stopMotor();
    }

    public void runConveyor(double speed) {
        conveyor.set(speed);
    }

    public void stopConveyor() {
        conveyor.stopMotor();
    }

    public void runCollectorUpDown(double speed) {
        collectorUpDown.set(speed);
    }

    public void stopCollectorUpDown() {
        collectorUpDown.stopMotor();
    }
}
