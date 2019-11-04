package mrmathami.thegame.entity.tile.tower;

import mrmathami.thegame.Config;
import mrmathami.thegame.entity.bullet.SniperBullet;

public final class SniperTower extends AbstractTower<SniperBullet> {
    public SniperTower(long createdTick, long posX, long posY) {
        super(createdTick, posX, posY, Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_SPEED);
    }


}
