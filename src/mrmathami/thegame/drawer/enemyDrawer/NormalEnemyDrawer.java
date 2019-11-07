package mrmathami.thegame.drawer.enemyDrawer;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.EntityDrawer;
import mrmathami.thegame.drawer.LoadImage;

import javax.annotation.Nonnull;

public class NormalEnemyDrawer implements EntityDrawer {
    public NormalEnemyDrawer(){}

    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight ) {
        graphicsContext.drawImage(LoadImage.normalEnemy, screenPosX, screenPosY);
        //graphicsContext.setFill(Color.RED);
        //graphicsContext.fillOval(screenPosX, screenPosY,10, 10);
    }

}