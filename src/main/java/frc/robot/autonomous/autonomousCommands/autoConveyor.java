package frc.robot.autonomous.autonomousCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.collector;
import frc.robot.subsystems.shooter;

public class autoConveyor extends CommandBase{
    public shooter shooter;
    public collector collector;
    public double time, convSpeed;

    public autoConveyor(collector collector, shooter shooter, double convSpeed) {
        this.collector = collector;
        this.shooter = shooter;
        this.convSpeed = convSpeed;
        addRequirements(collector);
    }

    public void initialize() {
        time = Timer.getFPGATimestamp();
    }

    public void execute() {
        collector.runConveyor(convSpeed);
    }

    public boolean isFinished() {
        if (Timer.getFPGATimestamp() - time >= Constants.autonomousConstants.conveyorTime) {
            System.out.println("all done here");
            shooter.stopShooter();
            collector.stopConveyor();
            return true;
        }
        return false;
    }

    
    public void end() {
        shooter.stopShooter();
        collector.stopConveyor();
        System.out.println("stopped motors");
    }
}
