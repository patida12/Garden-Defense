package mrmathami.thegame.drawer.towerDrawer;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.EntityDrawer;
import mrmathami.thegame.drawer.LoadImage;

import javax.annotation.Nonnull;

public class NormalTowerDrawer implements EntityDrawer {
    @Override
    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        graphicsContext.drawImage(LoadImage.normalTower, screenPosX, screenPosY);
    }

    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY) {
        graphicsContext.drawImage(LoadImage.normalTower, screenPosX, screenPosY);
    }
}