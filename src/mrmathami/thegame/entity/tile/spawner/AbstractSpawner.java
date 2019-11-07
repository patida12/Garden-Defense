package mrmathami.thegame.entity.tile.spawner;

import mrmathami.thegame.GameField;
import mrmathami.thegame.entity.AbstractEntity;

public abstract class AbstractSpawner extends AbstractEntity {
    private long numOfSpawn;

    protected AbstractSpawner(double posX, double posY, int numOfSpawn) {
        super(posX, posY);

        this.numOfSpawn = numOfSpawn;
    }

    @Override
    public void createEntity(GameField gameField) {

    }

    @Override
    public void onDestroy(GameField gameField) {

    }
}