package mrmathami.thegame.entity.enemy;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.entity.AbstractEntity;

public abstract class AbstractEnemy extends AbstractEntity {
     protected long numOfSpawn;
     protected long health;
     long armor;
     protected double speed;
     long reward;
     int nodeDirection = 0;
     boolean moveX;
     boolean isDead = false;
     boolean pathFinished = false;
    int nodeDi = 0;
    int rotation;
    protected Direction direction;

    protected AbstractEnemy(double posX, double posY, double size, long numOfSpawn, long health, long armor, double speed, long reward) {
        super(posX, posY, size, size);
        this.numOfSpawn = numOfSpawn;
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        this.pathFinished = false;
    }

    public AbstractEnemy(double posX, double posY) {
        super(posX, posY);
    }

    public void takeDamage(int damge) {
        health = health - damge;
        if (health <= 0) {
            isDead = true;
            pathFinished = false;
        }
    }

    enum Direction {
        LEFT(180), UP(270), RIGHT(0), DOWN(90);

        int degree;

        Direction(int i) {
            degree = i;
        }

        int getDegree() {
            return degree;
        }
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public abstract void update() ;

    public void draw(GraphicsContext graphicsContext) {};

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }

    public long getHealth() {
        return health;
    }

    public long getArmor() {
        return armor;
    }

    public double getSpeed() {
        return speed;
    }

    public long getReward() {
        return reward;
    }

    public long getNumOfSpawn() {
        return numOfSpawn;
    }

    public int getNodeDirection() {
        return nodeDirection;
    }

    public int getnodeDirection() {
        return nodeDirection;
    }

    public int getRotation() {
        return rotation;
    }

    public Direction getDirection() {return this.direction;}

    public String getDirectionStr(){
        switch (getDirection()) {
            case UP:
                return "UP";
            case DOWN:
                return "DOWN";
            case LEFT:
                return "LEFT";
            case RIGHT:
                return "RIGHT";
            default:
                return null;
        }
    }

    public boolean isDead() { return isDead;}

    public boolean isPathFinished() { return pathFinished;}

    public void setX(double x) {
        super.setX(x);
    }

    public void setY(double y) {
        super.setY(y);
    }

    public void setPathFinished(boolean pathFinished) {
        this.pathFinished = pathFinished;
    }

    public Direction setDirection(String direction) {
        if (direction.equals("LEFT")) return Direction.LEFT;
        else if (direction.equals("RIGHT")) return Direction.RIGHT;
        else if (direction.equals("DOWN")) return Direction.DOWN;
        else if (direction.equals("UP")) return Direction.UP;
        return null;
    }
}