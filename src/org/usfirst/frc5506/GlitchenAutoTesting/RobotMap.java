// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5506.GlitchenAutoTesting;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController chassisLeftMotor;
    public static SpeedController chassisRightMotor;
    public static DifferentialDrive chassisRobotDrive;
    public static Encoder chassisLeftEncoder;
    public static Encoder chassisRightEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisLeftMotor = new Talon(0);
        LiveWindow.addActuator("Chassis", "LeftMotor", (Talon) chassisLeftMotor);
        chassisLeftMotor.setInverted(false);
        chassisRightMotor = new Talon(1);
        LiveWindow.addActuator("Chassis", "RightMotor", (Talon) chassisRightMotor);
        chassisRightMotor.setInverted(false);
        chassisRobotDrive = new DifferentialDrive(chassisLeftMotor, chassisRightMotor);
        LiveWindow.addActuator("Chassis", "RobotDrive", chassisRobotDrive);
        chassisRobotDrive.setSafetyEnabled(true);
        chassisRobotDrive.setExpiration(0.1);
        chassisRobotDrive.setMaxOutput(1.0);

        chassisLeftEncoder = new Encoder(0, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Chassis", "LeftEncoder", chassisLeftEncoder);
        chassisLeftEncoder.setDistancePerPulse((428.5/265)*9.11891167);
        chassisLeftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        //chassisLeftEncoder.setSamplesToAverage(1);
        
        chassisRightEncoder = new Encoder(1, 2, true, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "wheelRotations", chassisRightEncoder);
        chassisRightEncoder.setDistancePerPulse((428.5/265)*9.11891167);
        chassisRightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        //chassisRightEncoder.setSamplesToAverage(1);

        
        //428.5in/265pulses for pushing it in disabled
        //112in / 175.69216081468113 pulses @ 60% left side
        //118in / 158.12294473321302 pulses @ 60% right side
        
        //(125/8.8933962264151 @ 80%
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
