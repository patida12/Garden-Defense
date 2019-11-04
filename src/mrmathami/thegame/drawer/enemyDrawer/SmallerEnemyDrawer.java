package mrmathami.thegame.drawer.enemyDrawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import mrmathami.thegame.drawer.EntityDrawer;
import mrmathami.thegame.entity.GameEntity;

import javax.annotation.Nonnull;

public final class SmallerEnemyDrawer implements EntityDrawer {
	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.drawImage(new Image("file:src/assets/images/smallerEnemy.png"), screenPosX, screenPosY);
		graphicsContext.setFill(Color.MAGENTA);
		graphicsContext.fillRoundRect(screenPosX, screenPosY, screenWidth, screenHeight, 4, 4);
	}
}
