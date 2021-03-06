package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.autonomous.autonomousCommands.autoEncoderDrive;
import frc.robot.autonomous.autonomousCommands.autoShoot;
import frc.robot.autonomous.autonomousCommands.autoTurn;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.collector;
import frc.robot.subsystems.shooter;

public class autonomous extends SequentialCommandGroup {

    public autonomous(DriveTrain drive, shooter shooter, collector collector, double driveSpeed,
        double turnSpeed, double driveDistance1, double turnAngle,
        double driveDistance2) {
            super(
                new autoShoot(shooter, collector)
                // new autoEncoderDrive(drive, driveSpeed, driveDistance1),
                // new autoTurn(drive, turnAngle, turnSpeed),
                // new autoEncoderDrive(drive, driveSpeed, driveDistance2)
                );
     }
    
}
