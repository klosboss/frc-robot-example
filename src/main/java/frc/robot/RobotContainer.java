// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.LoadBall;
import frc.robot.commands.TankDrive;
import frc.robot.commands.autonomous.AutonomousCommandSequence;
import frc.robot.controllers.LoadBallController;
import frc.robot.controllers.TankDriveController;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.BallMachine;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Joystick leftJoystick = new Joystick(Constants.LEFT_TANK_JOYSTICK_USB_PORT);
  private final Joystick rightJoystick = new Joystick(Constants.RIGHT_TANK_JOYSTICK_USB_PORT);
  private final XboxController xboxController = new XboxController(Constants.XBOX_CONTROLLER_USB_PORT);

  // Subsystems
  private final DriveTrain driveTrain = new DriveTrain();
  private final Arm arm = new Arm();
  private final BallMachine ballMachine = new BallMachine();

  // Commands
  private final TankDrive tankDriveCommand = new TankDrive(driveTrain, new TankDriveController(leftJoystick, rightJoystick));
  private final LoadBall loadBallCommand = new LoadBall(ballMachine, new LoadBallController(xboxController));
  

  // Add ability to choose autonomous mode in SmartDashboard
  private final SendableChooser<Command> autonomousChooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    Constants.initializeSmartDashboardConstants();
    this.configureButtonBindings();
    this.configureSubsystems();
    this.configureAutonomousModes();
  }

  private void configureAutonomousModes() {
    this.autonomousChooser.setDefaultOption("Shoot and Backup", new AutonomousCommandSequence(driveTrain, ballMachine));
    this.autonomousChooser.addOption("Do nothing", new WaitCommand(10.0));
    SmartDashboard.putData(this.autonomousChooser);
  }

  /**
   * Used to configure Subsystem::setDefaultCommand. This will schedule a Command until 
   * another Command takes over from configureButtonBindings() method which requires 
   * the Subsystem.
   * Default commands are best used for non-button input or setting default behavior.
   */
  private void configureSubsystems() {
    this.driveTrain.setDefaultCommand(tankDriveCommand);
    this.arm.setDefaultCommand(new RunCommand(arm::stop, arm));
    this.ballMachine.setDefaultCommand(loadBallCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(leftJoystick, Constants.TANK_JOYSTICK_TURBO_BUTTON_ID)
      .whenPressed(tankDriveCommand::activateTurbo, driveTrain)
      .whenReleased(tankDriveCommand::deactivateTurbo, driveTrain);
    new JoystickButton(rightJoystick, Constants.TANK_JOYSTICK_TURBO_BUTTON_ID)
      .whenPressed(tankDriveCommand::activateTurbo, driveTrain)
      .whenReleased(tankDriveCommand::deactivateTurbo, driveTrain);

    new JoystickButton(xboxController, Button.kY.value).whenHeld(new RunCommand(arm::raise, arm));
    new JoystickButton(xboxController, Button.kA.value).whenHeld(new RunCommand(arm::lower, arm));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autonomousChooser.getSelected();
  }
}
