package mrmathami.thegame.drawer.enemyDrawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import mrmathami.thegame.GameEntity;
import mrmathami.thegame.drawer.EntityDrawer;

import javax.annotation.Nonnull;

public class TankerEnemyDrawer implements EntityDrawer {
    @Override
    public void draw(@Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        graphicsContext.drawImage(new Image("file:src/assets/images/tankerEnemy.png"), screenPosX, screenPosY);

    }
}