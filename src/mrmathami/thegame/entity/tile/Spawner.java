package mrmathami.thegame.entity.tile;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class Spawner extends Road{

    public Spawner(double posX, double posY) {
        super(posX, posY);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        //graphicsContext.drawImage(LoadImage.spawner, getX() -16, getY() - 32, 32 * 2, 32 * 2);
    }

    @Override
    public void drawRectangle(GraphicsContext graphicsContext, Color color) {
        super.drawRectangle(graphicsContext, color);
    }
}
