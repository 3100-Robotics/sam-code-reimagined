package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.autonomous.autonomousCommands.autoEncoderDrive;
import frc.robot.autonomous.autonomousCommands.autoTurn;
import frc.robot.subsystems.DriveTrain;

public class autonomous extends SequentialCommandGroup {

    public autonomous(DriveTrain drive, double driveSpeed,
        double turnSpeed, double driveDistance1, double turnAngle, double driveDistance2) {
            super(
                new autoEncoderDrive(drive, driveSpeed, driveDistance1),
                new autoTurn(drive, turnAngle, turnSpeed),
                new autoEncoderDrive(drive, driveSpeed, driveDistance2));
     }
    
}
