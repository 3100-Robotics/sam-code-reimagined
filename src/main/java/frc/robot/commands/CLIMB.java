package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.climber;

public class CLIMB extends CommandBase{
    private final climber m_climb;
    private final XboxController m_controller;

    public CLIMB(climber subsystem, XboxController controller) {
        m_climb = subsystem;
        m_controller = controller;
        addRequirements(m_climb);
    }

    private double limit(double value) {
        /* Upper deadband */
        if (value >= +0.1)
          return value;
    
        /* Lower deadband */
        if (value <= -0.1)
          return value;
    
        /* Outside deadband */
        return 0;
      }

    @Override
    public void execute() {
        double Speed = -m_controller.getLeftY();

        m_climb.runClimber(limit(Speed));
    }
}
