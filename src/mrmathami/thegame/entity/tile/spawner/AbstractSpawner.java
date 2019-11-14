package mrmathami.thegame.entity.tile.spawner;

import mrmathami.thegame.entity.tile.Road;

public abstract class AbstractSpawner extends Road {
    private long numOfSpawn;

    protected AbstractSpawner(double posX, double posY, int numOfSpawn) {
        super(posX, posY);

        this.numOfSpawn = numOfSpawn;
    }

}