package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.GameField;
import mrmathami.thegame.drawer.mapDrawer.MapDrawer;

import javax.annotation.Nonnull;

public final class GameDrawer {
    @Nonnull
    private GraphicsContext graphicsContext;
    @Nonnull private GameField gameField;
    public GameDrawer() {}

   public void render(GraphicsContext graphicsContext) {
        MapDrawer.render(graphicsContext);
   }

}
