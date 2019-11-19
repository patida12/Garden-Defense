package mrmathami.thegame.drawer.towerDrawer;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.EntityDrawer;
import mrmathami.thegame.drawer.LoadImage;

import javax.annotation.Nonnull;

public class SniperTowerDrawer implements EntityDrawer {
    @Override
    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        graphicsContext.drawImage(LoadImage.sniperTower, (int)(screenPosX/32) * 32, (int)(screenPosY/32) * 32 - 32, 20, 50);

    }

    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY) {
        graphicsContext.drawImage(LoadImage.sniperTower, (int)(screenPosX/32) * 32, (int)(screenPosY/32) * 32 - 32, 20, 50);

    }
}