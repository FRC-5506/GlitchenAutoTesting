package org.usfirst.frc5506.GlitchenAutoTesting.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5506.GlitchenAutoTesting.Robot;

public class Count extends Command {
	
	int c;
	
	public Count() {
		requires(Robot.wheels);
	}
	
	@Override
	protected void initialize() {
		c = 0;
	}
	
	@Override
	protected void execute() {
		for(int j = 0;j<27;j++) {
		Robot.wheels.runEncoders();
		
		if(Robot.moving) {
			SmartDashboard.putNumber("Active Count", c);
			c++;
		}
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
