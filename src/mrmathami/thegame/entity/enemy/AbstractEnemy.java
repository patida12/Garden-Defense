package mrmathami.thegame.entity.enemy;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.GameField;
import mrmathami.thegame.entity.AbstractEntity;

public abstract class AbstractEnemy extends AbstractEntity {
    private long numOfSpawn;
    private long health;
    private long armor;
    private double speed;
    private long reward;
    private int nodeDirection = 0;
    private boolean moveX;
    private boolean isDead = false;
    private boolean pathFinished = false;
    int nodeDi = 0;
    int rotation;


    protected AbstractEnemy(double posX, double posY, double size, long numOfSpawn, long health, long armor, double speed, long reward) {
        super(posX, posY, size, size);
        this.numOfSpawn = numOfSpawn;
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        this.pathFinished = false;
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

    @Override
    public void createEntity(GameField gameField) {
        gameField.addEntity(this);
    }

    @Override
    public void onDestroy(GameField gameField) {
        if (this.isDead() || this.isPathFinished()) gameField.removeEntity(this);
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

    public int getNodeDirection() {
        return nodeDirection;
    }

    public int getnodeDirection() {
        return nodeDirection;
    }

    public int getRotation() {
        return rotation;
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