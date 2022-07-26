package frc.robot.autonomous.autonomousCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class autoTurn extends CommandBase {

    DriveTrain Drive;
    double angle, speed;
    double startAngle;

    public autoTurn(DriveTrain drive, double angle, double speed) {
        Drive = drive;
        this.angle = angle;
        this.speed = speed;

        addRequirements(Drive);
    }

    public void initialize() {
        startAngle = Drive.gyro.getAngle();
    }

    public void execute() {
        Drive.arcadeDrive(0.0, speed);
    }

    public boolean isFinished() {
        if (Drive.gyro.getAngle() - startAngle >= angle-20) {
            return true;
        }
        return false;
    }
    
}
