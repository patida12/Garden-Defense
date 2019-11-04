package mrmathami.thegame.entity.tile.spawner;

import mrmathami.thegame.entity.AbstractEntity;

public abstract class AbstractSpawner extends AbstractEntity {
    private long numOfSpawn;

    protected AbstractSpawner(long posX, long posY, long width, long height, long numOfSpawn) {
        super(posX, posY, width, height);

        this.numOfSpawn = numOfSpawn;
    }
}