package mrmathami.thegame.entity.tile;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.LoadImage;

public final class Garden extends Road {
    private int health;

    public Garden(double posX, double posY) {
        super(posX, posY);
        this.health = 100;
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
