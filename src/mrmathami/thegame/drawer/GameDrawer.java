package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.mapDrawer.MapDrawer;

public final class GameDrawer {
    public GameDrawer() {}

   public void render(GraphicsContext graphicsContext) {
        MapDrawer.render(graphicsContext);
   }

}
