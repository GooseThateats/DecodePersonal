package org.firstinspires.ftc.teamcode.troubleShooting;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.DecodeClasses.CameraSystem;
import org.firstinspires.ftc.teamcode.DecodeClasses.ColorSensorCode;
import org.firstinspires.ftc.teamcode.DecodeClasses.DriveMotorTest;
import org.firstinspires.ftc.teamcode.DecodeClasses.Feeder;
import org.firstinspires.ftc.teamcode.DecodeClasses.Firecracker;
import org.firstinspires.ftc.teamcode.DecodeClasses.Hammer;
import org.firstinspires.ftc.teamcode.DecodeClasses.Inhaler;
import org.firstinspires.ftc.teamcode.DecodeClasses.LED;
import org.firstinspires.ftc.teamcode.MecanumDrive;

import java.util.ArrayList;

@TeleOp
public final class EncoderTelemetry extends LinearOpMode {

    //enter how many motors you have

    private int numberOfMotors = 10;

    //enter how many crservos you have

    private int numberOfCRServos = 10;

    //enter how many servos you have

    private int numberOfServos = 10;

    //name all the names based on their deviceName, add more if needed
    private final String[] MOTORNAMES = {"motor1", "motor2", "motor3", "motor4"};

    private final String[] CRSERVONAMES = {"crServo1"};

    private final String[] SERVONAMES = {"servo1"};


    @Override
    public void runOpMode() throws InterruptedException {

        ArrayList<Motors> dcMotorList = new ArrayList<Motors>();
        ArrayList<ContinuousRotationServos> crServoList = new ArrayList<ContinuousRotationServos>();
        ArrayList<Servos> servoList = new ArrayList<Servos>();

        for(int i = 0; i<numberOfMotors; i++){
            dcMotorList.add(new Motors(hardwareMap, MOTORNAMES[i]));
        }

        for(int i = 0; i<numberOfCRServos; i++){
            crServoList.add(new ContinuousRotationServos(hardwareMap, CRSERVONAMES[i]));
        }

        for(int i = 0; i<numberOfServos; i++){
            servoList.add(new Servos(hardwareMap, SERVONAMES[i]));
        }

        for(int i = 0; i<numberOfMotors; i++){
            dcMotorList.get(i).initialize();
        }


        waitForStart();

        while(opModeIsActive()) {
            //encoder values for motors
            for(int i = 0; i<dcMotorList.size(); i ++){
                telemetry.addData("Motor" + (i+1) + "encoder ticks: ",dcMotorList.get(i).getCurrentEncoderPosition());
                telemetry.update();
            }
            //Power values of Continuous rotational Servos
            for(int i = 0; i<crServoList.size(); i++){
                telemetry.addData("crServo" + (i+1) + "power: ", crServoList.get(i).getCurrentPower());
                telemetry.update();
            }
            //Position values of every servos
            for(int i = 0; i<servoList.size(); i++){
                telemetry.addData("Servo " + (i+1) + " position: ", servoList.get(i).getCurrentServoPosition());
            }


        }
    }

}

