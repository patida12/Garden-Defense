package mrmathami.thegame.entity.tile.tower;

import mrmathami.thegame.entity.bullet.AbstractBullet;
import mrmathami.thegame.entity.tile.AbstractTile;

public abstract class AbstractTower<E extends AbstractBullet> extends AbstractTile {
	private final double range;
	private final long speed;

	private long tickDown;

	protected AbstractTower(long createdTick, long posX, long posY, double range, long speed) {
		super(createdTick, posX, posY, 1L, 1L);
		this.range = range;
		this.speed = speed;
		this.tickDown = 0;
	}

}
