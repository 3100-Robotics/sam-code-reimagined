package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter;

public class runCollecor extends CommandBase{
    
    private static shooter motor = new shooter();
    private static double speed;

    public runCollecor(double speed) {
        runCollecor.speed = speed;
    }

    public void execute() {
        motor.runShooter(speed);
    }

    public void end() {
        motor.stopShooter();
    }
}
