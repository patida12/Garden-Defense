package mrmathami.thegame.drawer.enemyDrawer;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.EntityDrawer;
import mrmathami.thegame.drawer.LoadImage;

import javax.annotation.Nonnull;

public class TankerEnemyDrawer implements EntityDrawer {
    @Override
    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        graphicsContext.drawImage(LoadImage.tankerEnemy, screenPosX, screenPosY);

    }
}