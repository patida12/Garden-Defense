package mrmathami.thegame.entity.tile;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.LoadImage;

public final class Spawner extends AbstractTile{

    public Spawner(double posX, double posY) {
        super(posX, posY);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(LoadImage.spawner, getX(), getY());
    }

}
