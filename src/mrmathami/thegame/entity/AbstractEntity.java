package mrmathami.thegame.entity;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.GameField;

public abstract class AbstractEntity implements GameEntity {
    private double X;
    private double Y;
    private double width;
    private double height;

    protected AbstractEntity(double posX, double posY) {
        this.X = posX;
        this.Y = posY;
    }

    protected AbstractEntity(double posX, double posY, double width, double height) {
        this.X = posX;
        this.Y = posY;
        this.width = width;
        this.height = height;
    }

    public void createEntity() {
        GameField.addEntity(this);
    };

    public void onDestroy() {
        GameField.removeEntity(this);
    };

    @Override
    public double getX() {
        return X;
    }

    @Override
    public double getY() {
        return Y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setX(double x) {
        this.X = x;
    }

    public void setY(double y) {
        this.Y = y;
    }

    public void update(){

    };

    public void draw(GraphicsContext graphicsContext){};
}
