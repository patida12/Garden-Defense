package mrmathami.thegame.entity.enemy;

import mrmathami.thegame.Config;

public class NormalEnemy extends AbstractEnemy {

    public NormalEnemy(double posX, double posY) {
        super(posX, posY,  Config.NORMAL_ENEMY_SIZE, Config.NORMAL_ENEMY_HEALTH, Config.NORMAL_ENEMY_ARMOR, Config.NORMAL_TOWER_SPEED, Config.NORMAL_ENEMY_REWARD, Config.NORMAL_ENEMY_NODEDIRECTION);
    }
}