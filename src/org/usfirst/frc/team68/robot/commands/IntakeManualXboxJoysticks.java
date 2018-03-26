package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;


public class IntakeManualXboxJoysticks extends Command {
	
	boolean isFinished = false;
	private double speedLeft;
	private double speedRight;
	
	
	public IntakeManualXboxJoysticks() {
		
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		
		if (Robot.oi.getRightXboxManipulatorJoystick() > 0.5) {
			Robot.intake.intakeNormal();
			Robot.intake.setIntakeSpeed(Robot.oi.getRightXboxManipulatorJoystick()/2.5, Robot.oi.getRightXboxManipulatorJoystick()/2.5);
		}
		
		if(Robot.oi.getRightXboxManipulatorJoystick() < -0.1) {
			Robot.intake.setIntakeSpeed(RobotMap.INTAKE_A_SPEED_FORWARD, RobotMap.INTAKE_B_SPEED_FORWARD);
			if (Robot.intake.getSwitch() == false) {
				Robot.intake.intakeClamp();
				Robot.intake.setIntakeSpeed(RobotMap.INTAKE_SPEED_STOP, RobotMap.INTAKE_SPEED_STOP);
			}
		}
		
		
		if (Robot.oi.getXboxManipulateLT() > 0) {
   			Robot.intake.intakeNormal();
   		}
   		
   		if (Robot.oi.getXboxManipulateRT() > 0) {
   			Robot.intake.intakeDownPosition();
   		}
		
		
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}


