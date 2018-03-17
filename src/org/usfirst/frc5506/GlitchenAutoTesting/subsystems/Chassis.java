// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5506.GlitchenAutoTesting.subsystems;

import org.usfirst.frc5506.GlitchenAutoTesting.RobotMap;
import org.usfirst.frc5506.GlitchenAutoTesting.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Counter;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Chassis extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController leftMotor = RobotMap.chassisLeftMotor;
    private final SpeedController rightMotor = RobotMap.chassisRightMotor;
    private final DifferentialDrive robotDrive = RobotMap.chassisRobotDrive;
    private final Encoder leftEncoder = RobotMap.chassisLeftEncoder;
    //private final Encoder rightEncoder = RobotMap.chassisRightEncoder;
    private final Encoder wheelRotations = RobotMap.chassisRightEncoder;
	private double correction;
	private double difference;
	private double lCorrect;
	private double rCorrect;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS  
	public double encoderLeftDistance;
	private double newLeftDistance;
	private double oldLeftDistance;
	private double newRightDistance;
	private double oldRightDistance;
	public double encoderRightDistance;

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopGo());
    	
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
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

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void drive(double forwardSpeed, double turnSpeed) {
    	robotDrive.arcadeDrive(forwardSpeed, turnSpeed);
    }
    
    public void stop() {
    	robotDrive.stopMotor();
    }
    
    public Encoder getLeftRotations() {
    	return leftEncoder;
    }
    
    public Encoder getRightRotations() {
    	return wheelRotations;
    }
    
    public void resetEncoders() {
    	oldLeftDistance = 0;
    	oldRightDistance = 0;
    	encoderLeftDistance = 0;
    	encoderRightDistance = 0;
    	
    	getLeftRotations().reset();
    	getRightRotations().reset();
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed) {
    	robotDrive.tankDrive(leftSpeed, rightSpeed);
    }
    
    public DifferentialDrive getMotors() {
    	return robotDrive;
    }
    
    public SpeedController getLeftMotor() {
    	return leftMotor;
    }
    
    public SpeedController getRightMotor() {
    	return rightMotor;
    }
    
    public void driveLinear() {
    	/*difference = rightEncoder.getDistance()-leftEncoder.getDistance();//difference of distances
    																//wheels travelled
    	
    	if(Math.abs(difference)>1)//if one side has gone farther than another
    		correction = difference;//turn the robot the amount that it's off
    	else
    		correction = 0;
    	
    	if(correction>0)
    		lCorrect = correction;
    	else if(correction<0)
    		rCorrect = correction;
    	else
    		correction = 0;*/
    	
    	drive(0.4, 0);
    	//tankDrive((0.5/*+lCorrect*/), (-0.5/*+Math.abs(rCorrect)*/));//play with this number -- imprecise
    	//if it gets off by more than half an inch, turn at 5%
    }
    
}

