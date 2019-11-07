package mrmathami.thegame.entity.tile;

import mrmathami.thegame.GameField;
import mrmathami.thegame.entity.AbstractEntity;


public abstract class AbstractTile extends AbstractEntity {
	protected AbstractTile(double posX, double posY) {
		super(posX, posY);
	}

	@Override
	public void onDestroy(GameField gameField) {
		//
	}
}


