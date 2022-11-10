package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class collector extends SubsystemBase{

    public static CANSparkMax collector = new CANSparkMax(Constants.CollectorConstants.collectorMotorPort,
    MotorType.kBrushless);
    public static CANSparkMax conveyor = new CANSparkMax(Constants.CollectorConstants.conveyorMotorPort,
    MotorType.kBrushless);

    public static final Solenoid IntakeSolenoid = new
    Solenoid(PneumaticsModuleType.CTREPCM, 7);

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

    public void stopcollector() {
        collector.stopMotor();
        conveyor.stopMotor();
    }

    public void runConveyor(double speed) {
        conveyor.set(speed);
    }

    public void stopconveyor() {
        conveyor.stopMotor();
    }

    public void toggleCollector() {
        IntakeSolenoid.toggle();
    }
}
