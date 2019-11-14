package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import mrmathami.thegame.Config;

import javax.annotation.Nonnull;

public class RectangleDrawer {
    Rectangle rectangle = new Rectangle();
    public void draw(@Nonnull GraphicsContext graphicsContext, Color color, double screenPosX, double screenPosY) {
        graphicsContext.setFill(color);
        graphicsContext.fillRoundRect(screenPosX, screenPosY, Config.TILE_SIZE, Config.TILE_SIZE, 0.5, 0.5);
    }
}
