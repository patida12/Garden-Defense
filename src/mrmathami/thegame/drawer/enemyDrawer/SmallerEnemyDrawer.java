package mrmathami.thegame.drawer.enemyDrawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import mrmathami.thegame.Config;
import mrmathami.thegame.drawer.EntityDrawer;
import mrmathami.thegame.drawer.LoadImage;

import javax.annotation.Nonnull;

public class SmallerEnemyDrawer implements EntityDrawer {
    @Override
    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        graphicsContext.drawImage(LoadImage.smallerEnemyDrawer, screenPosX, screenPosY);
    }

    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight, long health) {
        graphicsContext.drawImage(LoadImage.smallerEnemyDrawer, screenPosX, screenPosY);
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(screenPosX, screenPosY, Config.SMALLER_ENEMY_HEALTH, 5);
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillRect(screenPosX, screenPosY, health, 5 );
    }
}