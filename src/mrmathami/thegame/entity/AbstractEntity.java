package mrmathami.thegame.entity;

public abstract class AbstractEntity implements GameEntity {
    private double X;
    private double Y;
    private double width;
    private double height;

    protected AbstractEntity(double posX, double posY) {
        this.X = posX + width/2;
        this.Y = posY + height/2;
    }

    protected AbstractEntity(double posX, double posY, double width, double height) {
        this.X = posX + width/2;
        this.Y = posY + height/2;
        this.width = width;
        this.height = height;
    }

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
}
