package mrmathami.thegame.entity.tile;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import mrmathami.thegame.entity.AbstractEntity;



public abstract class AbstractTile extends AbstractEntity {
	Color color;

	protected AbstractTile(double posX, double posY) {
		super(posX, posY);
	}

	public abstract void drawRectangle(GraphicsContext graphicsContext, Color color);

}


