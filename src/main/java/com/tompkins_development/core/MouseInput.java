package com.tompkins_development.core;

import com.tompkins_development.test.Launcher;
import org.joml.Vector2d;
import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

public class MouseInput {

    private final Vector2d previousPosition, currentPosition;
    private final Vector2f displVec;

    private boolean inWindow = false, leftButtonPress = false, rightButtonPress = false;

    public MouseInput() {
        previousPosition = new Vector2d(-1,-1);
        currentPosition = new Vector2d(0,0);
        displVec = new Vector2f();
    }

    public void init() {
        GLFW.glfwSetCursorPosCallback(Launcher.getWindow().getWindow(), (window, xpos, ypos) -> {
           currentPosition.x = xpos;
           currentPosition.y = ypos;
        });

        GLFW.glfwSetCursorEnterCallback(Launcher.getWindow().getWindow(), (window, entered) -> {
            inWindow = entered;
        });

        GLFW.glfwSetMouseButtonCallback(Launcher.getWindow().getWindow(), (window, button, action, mods) -> {
            leftButtonPress = button == GLFW.GLFW_MOUSE_BUTTON_1 && action == GLFW.GLFW_PRESS;
            rightButtonPress = button == GLFW.GLFW_MOUSE_BUTTON_2 && action == GLFW.GLFW_PRESS;
        });
    }

    public void input() {
        displVec.x = 0;
        displVec.y = 0;
        if(previousPosition.x > 0 && previousPosition.y > 0 && inWindow) {
            double x = currentPosition.x - previousPosition.x;
            double y = currentPosition.y - previousPosition.y;
            boolean rotateX = x != 0;
            boolean rotateY = y != 0;
            if(rotateX)
                displVec.y = (float) x;
            if(rotateY)
                displVec.x = (float) y;
        }
        previousPosition.x = currentPosition.x;
        previousPosition.y = currentPosition.y;
    }

    public Vector2f getDisplVec() {
        return displVec;
    }

    public boolean isLeftButtonPress() {
        return leftButtonPress;
    }

    public boolean isRightButtonPress() {
        return rightButtonPress;
    }
}
