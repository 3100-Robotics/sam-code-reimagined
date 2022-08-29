package frc.robot.autonomous.autonomousCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class autoDrive extends CommandBase {
    
    DriveTrain Drive;
    double stopTime, speed;
    double time;

    public autoDrive(DriveTrain Drive, double speed, double stopTime) {
        this.Drive = Drive;
        this.stopTime = stopTime;
        this.speed = speed;
        
        addRequirements(Drive);
    }

    public void initialize() {
        time = Timer.getFPGATimestamp();
    }

    public void execute() {
        Drive.arcadeDrive(speed, 0.0);
    }

    public boolean isFinished() {
        if (Timer.getFPGATimestamp() - time >= stopTime) {
            return true;
        }
        return false;
    }

}
