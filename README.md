# FRC Robot in Java Sample
This code base was converted from LabView to Java using the code from Knight Riders 2022 Robot.
This is an initial example, figuring out how to write the code in Java, comparing examples
online and against this past years running code.

## Code Layout
This codebase consists of a few types of classes. Most of the emphasis surrounds subsystems
and commands. These two alone build out most of the functionality of the robot.

### Test Drive Development and Unit Tests
With any library, it is a good idea to incorporate test driven development, better known as TDD.
The basic lifecycle for TDD is as follows

1. Write a test which captures an expectation against a method and ensure that it fails.
2. Fix the test by adding the bare minimum amount of logic. Ensure the new test and all previous tests pass
3. Refactor

To do TDD correctly, each time a test is written or a change is made, rerun all tests. The goal
is to have the tests fill out the logic. For example, a test may be "given the left joystick is
pushed forward 50 percent, when drivetrain moves, then left motors move at 50 percent." The 
expectation here is that moving the controller triggers the left motors to activate. When a new
feature is desired, like adding a boost, then a test may be added such as: "given boost button 
is pressed, when drivetrain moves, then motors spin 15 percent faster". Logic then shall be added
to incorporate this test, but not fail the previous test.

See these resources:

- [TDD Manifesto](https://tddmanifesto.com/)
- [Youtube tutorial](https://www.youtube.com/watch?v=eMU_hninZAs)

### Robot Startup
Like any Java application, it all begins in a static main method. It is in the `Main` class
where the FRC framework is initialized. The framework itself maintains a scheduler and all
the code necessary to interact with the robot.

In this codebase, there is a `Robot` and `RobotContainer` class. The `Robot` class extends
the `TimedRobot` class, which provides methods for the FRC framework to do its job. It will
initialize any required classes or libraries as well as trigger teleop or autonomous modes.

The `RobotContainer` is responsible for wiring up the `Subsystems`, `Commands`, `SmartDashboard`
and any controller button mappings. One thing to note is that many of these class types 
are managed by the FRC framework. As an example, the `JoystickButton` class, which is responsible
for the button mappings, does not get assigned to a variable and is created as part of the 
`RobotContainer` constructor. Seeing this, a big question arises: "Why doesn't this get garbage
collected?" The answer is that the `CommandScheduler` class keeps track of the instance when 
the buttons are mapped.

### Subsystems
The subsystems are responsible for interacting with any of the hardware. These classes are the
interface between the code and any motors or sensors. The idea here is to create methods which
act as the interface to any commands. An example might be the `DriveTrain` which has a 
`moveLeft()` and a `moveRight()` method. The robot may have 2 motors set up on each side, two
on the left and two on the right. A command doesn't need to know how many motors there are, it
only cares how much the left should move and how much the right should move.

### Commands
Commands are useful when interacting with variable input, like a joystick or a trigger. Also,
they are useful for autonomous code and repeatable functions (shooting a ball which uses a 
reflector to calculate angle and speed to throw ball).

In this library, we have both commands for a joystick/trigger and for autonomous mode. It was
seen to be a good idea instead of referencing an `XboxController` or `Joystick` directly, use
an intermediary. So we have a controller type class to offload that logic.

### Controllers
Controllers are simply used as a bridge to interface between an actual controller class and
a command class. The `Command` class only cares about getting axis position and not the type
of controller that was used, nor how to interact with that controller. This essentially
decouples the command from the type of controller used.

### Constants
Constants contain all the mappings to hardware and any other globally accessible data. Any other
configurations, such as limiters, should be placed here as well. To add a configuration that
can be modified can be added to the `SmartDashboard` by adding it to the 
`initializeSmartDashboardConstants()` method adding a getter for it to be accessible from other
`Commands` or `Subsystems`.

## Simulation
Execute `./gradlew simulateJava` in the terminal to run the simulation for this project.

## SmartDashboard
Activated and selected through the FRC Driver Station. Configurable components are displayed
here.

## External Bookmarks

- [WPILib Example Projects](https://docs.wpilib.org/en/stable/docs/software/examples-tutorials/wpilib-examples.html)
- [Command Groups](https://docs.wpilib.org/en/stable/docs/software/commandbased/command-groups.html)
- [Unit Testing](https://docs.wpilib.org/en/stable/docs/software/wpilib-tools/robot-simulation/unit-testing.html)
- [Gradlew Tasks](https://docs.wpilib.org/en/stable/docs/software/advanced-gradlerio/gradlew-tasks.html)
