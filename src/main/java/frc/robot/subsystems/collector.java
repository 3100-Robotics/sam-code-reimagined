package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class collector extends SubsystemBase{
    public static CANSparkMax collector = new CANSparkMax(Constants.motorConstants.collectorMotorPort,
    MotorType.kBrushless);
    public static CANSparkMax conveyor = new CANSparkMax(Constants.motorConstants.conveyorMotorPort,
    MotorType.kBrushless);

    public static final Solenoid IntakeSolenoid = new
    Solenoid(PneumaticsModuleType.CTREPCM,
    Constants.Pneumaticsconstants.IntakeSolenoidPort);

    public collector() {
        collector.restoreFactoryDefaults();
        collector.setIdleMode(IdleMode.kBrake);
        conveyor.restoreFactoryDefaults();
        conveyor.setIdleMode(IdleMode.kBrake);
    }

    public static void runCollector(double speed) {
        collector.set(speed);
    }

    public static void stopcollector() {
        collector.stopMotor();
    }

    public static void runConveyor(double speed) {
        conveyor.set(speed);
    }

    public static void stopconveyor() {
        conveyor.stopMotor();
    }

    public static void toggleCollector() {
        IntakeSolenoid.toggle();
    }

    public static void runToggleCollector(double speed) {
        runCollector(speed);
        toggleCollector();
    }

    public static void stopToggleCollector() {
        stopcollector();
        toggleCollector();
    }
}
