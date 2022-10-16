package frc.robot.controllers;

import edu.wpi.first.wpilibj.XboxController;

public class AdjustArmController {

    private final XboxController xboxController;

    public AdjustArmController(XboxController xboxController) {
        this.xboxController = xboxController;
    }

    public boolean shouldRaise() {
        return this.xboxController.getYButtonPressed();
    }

    public boolean shouldLower() {
        return this.xboxController.getAButtonPressed();
    }


}
