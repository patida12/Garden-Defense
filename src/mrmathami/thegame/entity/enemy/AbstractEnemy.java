package mrmathami.thegame.entity.enemy;

import mrmathami.thegame.entity.AbstractEntity;

public abstract class AbstractEnemy extends AbstractEntity {
    private long health;
    private long armor;
    private double speed;
    private long reward;
    private int nodeDirection;
    private boolean moveX;
    private boolean isDead;
    private boolean pathFinished;


    protected AbstractEnemy(double posX, double posY, double size, long health, long armor, double speed, long reward, int nodeDirection) {
        super(posX, posY, size, size);
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        this.nodeDirection = nodeDirection;
        this.pathFinished = false;
        this.moveX = true;
    }

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
}