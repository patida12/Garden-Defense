package mrmathami.thegame.drawer.towerDrawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import mrmathami.thegame.drawer.EntityDrawer;
import mrmathami.thegame.entity.GameEntity;

import javax.annotation.Nonnull;

public final class NormalTowerDrawer implements EntityDrawer {
	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.drawImage(new Image("file:src/assets/images/normalTower.png"), screenPosX, screenPosY);
		//graphicsContext.setFill(Color.RED);
		//graphicsContext.fillOval(screenPosX, screenPosY, screenWidth, screenHeight);
	}
}
