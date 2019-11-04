package mrmathami.thegame.entity.tile.tower;

import mrmathami.thegame.Config;
import mrmathami.thegame.entity.bullet.NormalBullet;

public final class NormalTower extends AbstractTower<NormalBullet> {
	public NormalTower(long createdTick, long posX, long posY) {
		super(createdTick, posX, posY, Config.NORMAL_TOWER_RANGE, Config.NORMAL_TOWER_SPEED);
	}


}
