package frc.robot.subsystems;

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
    public static CANSparkMax collectorUpDown = new CANSparkMax(Constants.CollectorConstants.collectorUpDownPort,
    MotorType.kBrushed);

    public collector() {
        // configure the motors
        collector.restoreFactoryDefaults();
        collector.setIdleMode(IdleMode.kBrake);
        conveyor.restoreFactoryDefaults();
        conveyor.setIdleMode(IdleMode.kBrake);
        collectorUpDown.restoreFactoryDefaults();
        collectorUpDown.setIdleMode(IdleMode.kBrake);
        
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
        // System.out.println("running the motor!");
        collectorUpDown.set(speed);
    }

    public void stopCollectorUpDown() {
        // System.out.println("stoping motor!");
        collectorUpDown.stopMotor();
    }
}
