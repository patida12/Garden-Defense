package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;

import javax.annotation.Nonnull;

public interface EntityDrawer {
	void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) ;

}
