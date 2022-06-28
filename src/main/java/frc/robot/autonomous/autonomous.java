package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.autonomous.autonomousCommands.autoDrive;
import frc.robot.autonomous.autonomousCommands.autoTurn;
import frc.robot.subsystems.DriveTrain;

public class autonomous extends SequentialCommandGroup {

    static DriveTrain Drive;
    double driveSpeed, turnSpeed;
    double driveTime, turnAngle;

    public autonomous(DriveTrain drive, double driveSpeed,
        double turnSpeed, double driveTime, double turnAngle) {
            super(
                new autoDrive(Drive, driveSpeed, driveTime),
                new autoTurn(Drive, turnAngle, turnSpeed));
     }
    
}
