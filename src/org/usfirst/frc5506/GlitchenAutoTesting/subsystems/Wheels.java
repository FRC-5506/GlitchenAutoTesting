package org.usfirst.frc5506.GlitchenAutoTesting.subsystems;

import org.usfirst.frc5506.GlitchenAutoTesting.RobotMap;
import org.usfirst.frc5506.GlitchenAutoTesting.commands.Count;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Wheels extends Subsystem {
	
	private double newRightDistance;
	private double encoderRightDistance;
	private double oldRightDistance;
	private double newLeftDistance;
	private double encoderLeftDistance;
	private double oldLeftDistance;
	private final Encoder leftEncoder = RobotMap.chassisLeftEncoder;
	private final Encoder rightEncoder = RobotMap.chassisRightEncoder;

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Count());
	}
	
	@Override
	public void periodic() {
		//Put code here to be run every loop
	}
	
	public double leftDist() {
		return encoderLeftDistance;
	}
	
	public double rightDist() {
		return encoderRightDistance;
	}
	
	public void runEncoders() {
		newRightDistance = getRightRotations().getDistance();//newDistance is how far the encoder moves in a cycle
    	
    	if(!(newRightDistance==oldRightDistance))//if the encoder actually moved
    		encoderRightDistance += Math.abs(newRightDistance);//add how far it moved to a sum
    	
    	oldRightDistance = newRightDistance;//now use how far it moved as a reference point to check that it moved next cycle
    	//even if it didn't move, it's okay to set that value equal to itself
    	
    	//now for the left encoder
    	newLeftDistance = getLeftRotations().getDistance();
    	
    	if(!(newLeftDistance==oldLeftDistance))
    		encoderLeftDistance += Math.abs(newLeftDistance);
    	
    	oldLeftDistance = newLeftDistance;
	}
	
	public Encoder getRightRotations() {
		return rightEncoder;
	}
	
	public Encoder getLeftRotations() {
		return leftEncoder;
	}
	
	public void resetEncoders() {
		encoderLeftDistance = 0;
		encoderRightDistance = 0;
		oldLeftDistance = 0;
		oldRightDistance = 0;
		
		getRightRotations().reset();
		getLeftRotations().reset();
	}
	
	public boolean moving() {
		return ((oldLeftDistance!=newLeftDistance)||(oldRightDistance!=newRightDistance));
	}
}
