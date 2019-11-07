package mrmathami.thegame.entity.bullet;

import mrmathami.thegame.GameField;
import mrmathami.thegame.entity.AbstractEntity;

public abstract class AbstractBullet extends AbstractEntity {
    protected AbstractBullet(double posX, double posY, double deltaX, double deltaY, double speed, long strength, long timeToLive) {
        super( posX, posY, 0.2, 0.2);
    }

    @Override
    public void onDestroy(GameField gameField) {

    }
}