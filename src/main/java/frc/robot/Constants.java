// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
   public final static int kCANTimeoutMs = 10;
   public final static int PID_PRIMARY = 0;

    public static final class autonomousConstants {
        public final static double shooterTime = 1;
        public final static double conveyorTime = 1 + shooterTime;
    }

    public static final class motorConstants {
        public final static int hoodServoPort = 0;
        public final static int frontLeftDrivePort = 1;
        public final static int backLeftDrivePort = 2;
        public final static int frontRightDrivePort = 3;
        public final static int backRightDrivePort = 4;
        public final static int collectorMotorPort = 5;
        public final static int conveyorMotorPort = 6;
        public final static int turretMotorPort = 8;
        public final static int shooterMotorPort = 9;
        public final static int leftClimberMotorPort = 10;
        public final static int rightClimberMotorPort = 11;
    }

    public static final class Pneumaticsconstants {
        public final static int IntakeSolenoidPort = 7;

        public final static int ClimberSolenoidPort = 6;
    }

    public static final class ClimberConstants {

        // === CLIMBER SOFT LIMITS === //
        public final static int kRightForwardSoftLimit_Quad = 2048 * 158;
        public final static int kLeftForwardSoftLimit_Quad = -2048 * 154;
        public final static int kRightReverseSoftLimit_Quad = -2048 * 158; /* 5 rotations assuming FX Integrated Sensor */
        public final static int kLeftReverseSoftLimit_Quad = 2048 * 154;
  
     }

    public static final class IOConstants {
        // === XBOX CHANNELS === //
        // AXES
        public static final int leftXAxisChannel = 0;
        public static final int leftYAxisChannel = 1;
        public static final int leftTriggerChannel = 2;
        public static final int rightTriggerChannel = 3;
        public static final int rightXAxisChannel = 4;
        public static final int rightYAxisChannel = 5;
  
        // BUTTONS
        public static final int aButtonChannel = 1;
        public static final int bButtonChannel = 2;
        public static final int xButtonChannel = 3;
        public static final int yButtonChannel = 4;
  
        public static final int leftBumperChannel = 5;
        public static final int rightBumperChannel = 6;
  
        public static final int backButtonChannel = 7;
        public static final int startButtonChannel = 8;
  
        public static final int POVU = 0;
        public static final int POVR = 90;
        public static final int POVD = 180;
        public static final int POVL = 270;
     }

    public static final class drivetrainConstants {
        public final static double kSensorUnitsPerRotation = 2048;
        private final static double kGearReduction = 8.68;
        private final static double driveWheelRadiusMeters = 0.0508;

        public static double encoderScale = (1 / kGearReduction) * (kSensorUnitsPerRotation)
            * (2 * Math.PI * driveWheelRadiusMeters);
    }
}
