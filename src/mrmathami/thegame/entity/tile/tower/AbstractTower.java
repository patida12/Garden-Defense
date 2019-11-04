package mrmathami.thegame.entity.tile.tower;

import mrmathami.thegame.entity.Point;
import mrmathami.thegame.entity.tile.AbstractTile;

public abstract class AbstractTower extends AbstractTile {
    private Point point;                            // Represents the coordinates of the tower on the map

    public AbstractTower(double x, double y) {
        super(x, y);
        this.point = new Point(x, y);
    }

    public abstract void updateTower();

    //get+set
}