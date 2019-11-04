package mrmathami.thegame.entity;

import mrmathami.thegame.GameEntity;

public abstract class AbstractEntity implements GameEntity {
    private double X;
    private double Y;
    private double width;
    private double height;

    protected AbstractEntity(double posX, double posY, double width, double height) {
        this.X = posX;
        this.Y = posY;
        this.width = width;
        this.height = height;
    }
}
