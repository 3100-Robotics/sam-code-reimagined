package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.autonomous.autonomousCommands.autoConveyor;
import frc.robot.autonomous.autonomousCommands.autoEncoderDrive;
import frc.robot.autonomous.autonomousCommands.autoShooterRev;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.collector;
import frc.robot.subsystems.shooter;

public class autonomous extends SequentialCommandGroup {

    public autonomous(DriveTrain drive, shooter shooter, collector collector,
                    double driveDist, double driveSpeed, double shooterSpeed, double conveyorSpeed) {
            super(
                new autoShooterRev(shooter, shooterSpeed),
                new autoConveyor(collector, shooter, conveyorSpeed),
                new autoEncoderDrive(drive, driveSpeed, driveDist)
                );
     }
    
}
