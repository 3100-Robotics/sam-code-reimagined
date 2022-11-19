package frc.robot.autonomous.autonomousCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class autoEncoderDrive extends CommandBase{
    DriveTrain Drive;
    double speed, distance;
    double time;

    public autoEncoderDrive(DriveTrain Drive, double speed, double distance) {
        this.Drive = Drive;
        this.speed = speed;
        this.distance = distance;
        
        addRequirements(Drive);
    }

    public void initialize() {
        Drive.resetEncoders();
    }

    public void execute() {
        Drive.arcadeDrive(speed, 0.0);
    }

    public boolean isFinished() {
        if (speed < 0 && -DriveTrain.frontRight.getSelectedSensorPosition(0) >= distance) {
            System.out.println("done driving");
            return true;
        }
        else if (DriveTrain.frontRight.getSelectedSensorPosition(0) >= distance) { 
            System.out.println("done driving");
            return true;
        }
        return false;
    }

}
