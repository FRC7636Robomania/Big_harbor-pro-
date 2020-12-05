/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static class Vision{
        public static final String limelightName = "limelight-unicorn";
        public static final double targetHigh = 206;
        public static final double limelightHigh = 58;
        public static final double limelightAngle = 36;
        public static final double lime_kp = 0.15;
        public static final double lime_ki = 0.0;
        public static final double lime_kd = 0.0;
    }
    
    public static class PowCon{
        
        public static final double flywheel_kF  = 0.506; 
        public static final double flywheel_kP  = 0.1;
        public static final double flywheelvel  = 21600;
        
        public static final int wingMiddle    = 2;
        public static final int wingRight     = 1;
        public static final int intake = 4;
        public static final int conveyor = 6; 
        
        public static final int tower = 36;
        public static final int rack = 25;
        
        public static final int flywheelLeft  = 17;
        public static final int flywheelRight = 15;
        
        public static final int kTimeoutMs    = 30;
    }
    
    
    public static class chassis{

		public static final int leftMaster    = 19;
		public static final int leftFollewer  = 18;
        public static final int rightMaster   = 21;
        public static final int rightFollower = 20;

        public static final boolean isRightMotorInvert = false;
        public static final boolean isLeftMotorInvert = true;
        public static final boolean isRightPhaseInvert = false;
        public static final boolean isLeftPhaseInvert = true;
         
    }

    public static class Pne{
        public static final int ArmDS_1 = 0;           //雙電磁閥腳位1
        public static final int ArmDS_2 = 1;           //雙電磁閥腳位2

    }

    public static class Button{
        //XboxController
        public static final int flySpin         = 1;           //飛輪啟用
        public static final int conveyor        = 6;           //送球保險
        public static final int emergency_shoot = 5;           //緊急發射

        //Joystick
        //trigger be used to curvature drive
        public static final int intake          = 2;           //吸球、送球
        public static final int rack_up         = 3;           //齒條上升
        public static final int rack_down       = 4;           //齒條下降
        public static final int turretleft      = 5;           //轉塔左
        public static final int turretRight     = 6;           //轉塔右
        public static final int intake_opp      = 7;           //進球反轉(包括送球三個馬達+吸球)
        public static final int rackZero        = 9;           //齒條歸零
        public static final int arm_out         = 11;           //手臂出去
        public static final int arm_in          = 12;           //手臂進來
        //public static final int one             = 10;          //一號洞
        //public static final int nine            = 11;          //九號洞
        //public static final int three           = 12;          //三號洞
        //public static final int autoaim         = 14;          //自動瞄準
        //public static final int towerZero       = 8;           //轉塔歸零

    }
}
