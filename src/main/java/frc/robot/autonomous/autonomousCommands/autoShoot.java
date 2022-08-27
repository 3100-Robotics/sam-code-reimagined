package frc.robot.autonomous.autonomousCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.collector;
import frc.robot.subsystems.shooter;

public class autoShoot extends CommandBase{
    
    public shooter shooter;
    public collector collector;
    public double time, shooterTime, collectorTime;

    public autoShoot(shooter shooter, collector collector, double shooterTime, double collectorTime) {
        this.shooter = shooter;
        this.collector = collector;
        this.shooterTime = shooterTime;
        this.collectorTime = collectorTime;
        addRequirements(shooter, collector);
    }

    public void initialize() {
        time = Timer.getFPGATimestamp();
    }

    public void execute() {
        shooter.runShooter(0.7);
        if (Timer.getFPGATimestamp() - time >= Constants.autonomousConstants.shooterTime) {
            collector.runConveyor(0.5);
        }
    }

    public boolean isFinished() {
        if (Timer.getFPGATimestamp() - time >= Constants.autonomousConstants.conveyorTime) {
            System.out.println("all done here");
            return true;
        }
        return false;
    }

    public void end() {
        shooter.stopShooter();
        collector.stopconveyor();
    }
}
