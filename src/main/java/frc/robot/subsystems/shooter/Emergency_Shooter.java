/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.*;
import frc.robot.motor_method.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PowCon;


public class Emergency_Shooter extends SubsystemBase {
  private SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration = new SupplyCurrentLimitConfiguration(true, 50, 50, 1);
  private TalonFX flywheelLeft = new TalonFX(PowCon.flywheelLeft);
  private TalonFX flywheelRight = new TalonFX(PowCon.flywheelRight); 
  

  
  public Emergency_Shooter() {
    // Factory default hardware to prevent unexpected behavior 
    flywheelLeft.configFactoryDefault();
    flywheelRight.configFactoryDefault();
    
    //set sensor
    MotorFactory.setSensor(flywheelLeft,FeedbackDevice.IntegratedSensor);
    MotorFactory.setSensor(flywheelRight, FeedbackDevice.IntegratedSensor);
    
    //adjust kP,kF 
    MotorFactory.configPF(flywheelLeft,PowCon.flywheel_kP,PowCon.flywheel_kF,0);
    MotorFactory.configPF(flywheelRight, PowCon.flywheel_kP, PowCon.flywheel_kF, 0);
    
    //adjust CruiseVel, Accler,SensorPos
    flywheelLeft.configMotionCruiseVelocity(15000, PowCon.kTimeoutMs);
		flywheelLeft.configMotionAcceleration(6000, PowCon.kTimeoutMs);
		flywheelLeft.setSelectedSensorPosition(0, 0, PowCon.kTimeoutMs);
    flywheelRight.configMotionCruiseVelocity(15000, PowCon.kTimeoutMs);
		flywheelRight.configMotionAcceleration(6000, PowCon.kTimeoutMs);
		flywheelRight.setSelectedSensorPosition(0, 0, PowCon.kTimeoutMs);

    //PeakOutput , CurrentLimit , NeutralDeadband 
    flywheelLeft.configPeakOutputForward(0.7, PowCon.kTimeoutMs);
    flywheelRight.configPeakOutputForward(0.7, PowCon.kTimeoutMs);
    flywheelLeft.configSupplyCurrentLimit(supplyCurrentLimitConfiguration);
    flywheelRight.configSupplyCurrentLimit(supplyCurrentLimitConfiguration);
    
    flywheelLeft.setNeutralMode(NeutralMode.Coast);
    flywheelRight.setNeutralMode(NeutralMode.Coast);
    flywheelLeft.configNeutralDeadband(0.005, PowCon.kTimeoutMs);
    flywheelRight.configNeutralDeadband(0.005, PowCon.kTimeoutMs);
    
    //Closedloop,Openedloop
    flywheelLeft.configClosedloopRamp(0.5, 10);
    flywheelRight.configClosedloopRamp(0.5, 10);
    
    //InvertType
    flywheelRight.follow(flywheelLeft);
    flywheelLeft.setInverted(false);
    flywheelRight.setInverted(InvertType.OpposeMaster);    

  }

  public void emergency(){
    flywheelLeft.set(ControlMode.PercentOutput,0.9);
    SmartDashboard.putString("flywheel status", "emergency");
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("flyvel", flywheelLeft.getSelectedSensorVelocity(0));
  }

  public double getflywheelVelocity(){ 
    
    return flywheelLeft.getSelectedSensorVelocity();
  }

  
}