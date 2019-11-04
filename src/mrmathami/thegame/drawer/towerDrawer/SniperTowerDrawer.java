package mrmathami.thegame.drawer.towerDrawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import mrmathami.thegame.Config;
import mrmathami.thegame.drawer.EntityDrawer;
import mrmathami.thegame.entity.GameEntity;

import javax.annotation.Nonnull;

public final class SniperTowerDrawer implements EntityDrawer {
	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.drawImage(new Image("file:src/assets/images/sniperTower.png"), screenPosX, screenPosY, Config.ROAD_SIZE, Config.ROAD_SIZE);
		//graphicsContext.setFill(Color.MEDIUMVIOLETRED);
		//graphicsContext.fillOval(screenPosX, screenPosY, screenWidth, screenHeight);
	}
}
