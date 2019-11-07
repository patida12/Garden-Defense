package mrmathami.thegame.entity.tile;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.LoadImage;

public final class Target extends AbstractTile{
    private int health;

    public Target(double posX, double posY) {
        super(posX, posY);
        this.health = 10;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(LoadImage.target, getX(), getY());
    }

    public long getHealth() {
        return health;
    }

    public void doDestroy() {
        this.health = Integer.MIN_VALUE;
    }

    public boolean isDestroyed() {
        return health <= 0L;
    }
}
