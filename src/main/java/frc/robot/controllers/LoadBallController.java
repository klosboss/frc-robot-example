package frc.robot.controllers;

import edu.wpi.first.wpilibj.XboxController;

public class LoadBallController {

    private final XboxController controller;
    public LoadBallController(XboxController controller) {
        this.controller = controller;
    }

    public double getLeftPosition() {
        return this.controller.getLeftTriggerAxis();
    }

    public double getRightPosition() {
        return this.controller.getRightTriggerAxis();
    }
    
}
