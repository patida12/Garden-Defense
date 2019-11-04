package mrmathami.thegame.entity.enemy;

import mrmathami.thegame.entity.AbstractEntity;

public abstract class Enemy extends AbstractEntity {
    private long health;
    private long armor;
    private double speed;
    private long reward;

    protected Enemy(double posX, double posY, double size, long health, long armor, double speed, long reward) {
        super(posX, posY, size, size);
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
    }


}