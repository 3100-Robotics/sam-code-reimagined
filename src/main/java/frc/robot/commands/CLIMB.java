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

    @Override
    public void execute() {
        double xSpeed = -m_controller.getLeftY();

        m_climb.runClimber(xSpeed);
    }
}
