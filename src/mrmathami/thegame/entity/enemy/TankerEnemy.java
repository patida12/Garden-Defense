package mrmathami.thegame.entity.enemy;

import mrmathami.thegame.Config;

public class TankerEnemy extends AbstractEnemy {

    public TankerEnemy(double posX, double posY) {
        super(posX, posY,  Config.TANKER_ENEMY_SIZE, Config.TANKER_ENEMY_HEALTH, Config.TANKER_ENEMY_ARMOR, Config.TANKER_ENEMY_SPEED, Config.TANKER_ENEMY_REWARD, Config.TANKER_ENEMY_NODEDIRECTION);
    }
}