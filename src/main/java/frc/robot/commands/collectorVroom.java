package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.collector;

public class collectorVroom extends CommandBase{
    private final collector m_collect;
    private final XboxController m_controller;

    public collectorVroom(collector subsystem, XboxController controller) {
        m_collect = subsystem;
        m_controller = controller;
        addRequirements(m_collect);
    }

    private double limit(double value) {
        if (value >= +0.1)
          return value;
    
        if (value <= -0.1)
          return value;
        
        return 0;
      }

    @Override
    public void execute() {
        double speed = -m_controller.getRightY();

        m_collect.runCollectorUpDown(limit(speed));
    }
    
}
