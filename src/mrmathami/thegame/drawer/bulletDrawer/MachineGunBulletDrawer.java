package mrmathami.thegame.drawer.bulletDrawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import mrmathami.thegame.drawer.EntityDrawer;

import javax.annotation.Nonnull;

public class MachineGunBulletDrawer implements EntityDrawer {
    @Override
    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        //graphicsContext.drawImage(LoadImage.machineGunBullet, screenPosX, screenPosY);
        graphicsContext.setFill(Color.DEEPPINK);
        graphicsContext.fillOval(screenPosX, screenPosY, 10, 10);
    }
}