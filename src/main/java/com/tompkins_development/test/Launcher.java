package com.tompkins_development.test;

import com.tompkins_development.core.EngineManager;
import com.tompkins_development.core.WindowManager;
import com.tompkins_development.core.utils.Consts;


public class Launcher {

    public static WindowManager window;
    private static TestGame game;

    public static void main(String[] args) {
        window = new WindowManager(Consts.TITLE, 1920, 1080, false);
        game = new TestGame();
        EngineManager engine = new EngineManager();

        try {
            engine.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WindowManager getWindow() {
        return window;
    }

    public static TestGame getGame() {
        return game;
    }
}
