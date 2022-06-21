package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class vroomVroom extends CommandBase{
    private final DriveTrain m_drive;
    private final XboxController m_controller;

    public vroomVroom(DriveTrain subsystem, XboxController controller) {
        m_drive = subsystem;
        m_controller = controller;
        addRequirements(m_drive);
    }

    @Override
    public void execute() {
        double xSpeed = -m_controller.getLeftY();
        double zRotation = m_controller.getRightX();

        m_drive.arcadeDrive(xSpeed, zRotation);
  }
}
