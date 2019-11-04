package mrmathami.thegame.entity.tile;

import mrmathami.thegame.entity.AbstractEntity;


public abstract class GameTile extends AbstractEntity {
	protected GameTile(long posX, long posY, long width, long height) {
		super(posX, posY, width, height);
	}
}
