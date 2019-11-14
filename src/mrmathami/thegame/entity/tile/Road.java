package mrmathami.thegame.entity.tile;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import mrmathami.thegame.drawer.RectangleDrawer;

public class Road extends AbstractTile {
    RectangleDrawer drawer = new RectangleDrawer();
    public Road(double posX, double posY) {
        super(posX, posY);
    }

    @Override
    public void drawRectangle(GraphicsContext graphicsContext, Color color) {
        drawer.draw(graphicsContext, color, this.getX(), this.getY());
    }
}