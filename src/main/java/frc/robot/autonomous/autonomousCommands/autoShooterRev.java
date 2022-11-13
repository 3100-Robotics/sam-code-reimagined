package frc.robot.autonomous.autonomousCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.shooter;

public class autoShooterRev extends CommandBase{
    
    public shooter shooter;
    public double time, speed;

    public autoShooterRev(shooter shooter, double speed) {
        this.shooter = shooter;
        this.speed = speed;
        addRequirements(shooter);
    }

    public void initialize() {
        time = Timer.getFPGATimestamp();
    }

    public void execute() {
        shooter.runShooter(speed);
    }

    public boolean isFinished() {
        if (Timer.getFPGATimestamp() - time >= Constants.autonomousConstants.shooterTime) {
            return true;
        }
        return false;
    }

    public void end() {}
}
