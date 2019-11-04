package mrmathami.thegame.entity.enemy;

import mrmathami.thegame.Config;

public class SmallerEnemy extends AbstractEnemy {

    public SmallerEnemy(double posX, double posY) {
        super(posX, posY,  Config.SMALLER_ENEMY_SIZE, Config.SMALLER_ENEMY_HEALTH, Config.SMALLER_ENEMY_ARMOR, Config.SNIPER_BULLET_SPEED, Config.SMALLER_ENEMY_REWARD, Config.SMALLER_ENEMY_NODEDIRECTION);
    }
}