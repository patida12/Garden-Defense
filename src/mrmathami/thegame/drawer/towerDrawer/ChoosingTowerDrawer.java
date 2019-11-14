package mrmathami.thegame.drawer.towerDrawer;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.EntityDrawer;

import javax.annotation.Nonnull;

public class ChoosingTowerDrawer implements EntityDrawer {
    @Override
    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        graphicsContext.strokeOval(screenPosX, screenPosY, 70, 70);
        //graphicsContext.fillOval(screenPosX, screenPosY, screenWidth, screenHeight);
    }
}
