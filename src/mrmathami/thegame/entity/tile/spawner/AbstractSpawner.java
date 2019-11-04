package mrmathami.thegame.entity.tile.spawner;

import mrmathami.thegame.entity.enemy.AbstractEnemy;
import mrmathami.thegame.entity.tile.AbstractTile;

import javax.annotation.Nonnull;

public abstract class AbstractSpawner<E extends AbstractEnemy> extends AbstractTile  {
	private final double spawningSize;
	@Nonnull private final Class<E> spawningClass;
	private final long spawnInterval;
	private long tickDown;
	private long numOfSpawn;

	protected AbstractSpawner(long createdTick, long posX, long posY, long width, long height, double spawningSize, @Nonnull Class<E> spawningClass, long spawnInterval, long initialDelay, long numOfSpawn) {
		super(createdTick, posX, posY, width, height);
		this.spawningSize = spawningSize;
		this.spawningClass = spawningClass;
		this.spawnInterval = spawnInterval;
		this.tickDown = initialDelay;
		this.numOfSpawn = numOfSpawn;
	}


}
