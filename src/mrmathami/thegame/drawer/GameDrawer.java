package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.GameField;
import mrmathami.thegame.GameStage;
import mrmathami.thegame.drawer.mapDrawer.MapDrawer;
import mrmathami.thegame.entity.AbstractEntity;

import javax.annotation.Nonnull;

public final class GameDrawer {
    @Nonnull
    private GraphicsContext graphicsContext;
    @Nonnull private GameField gameField = new GameField(new GameStage());

    public GameDrawer(GraphicsContext graphicsContext, GameField field) {
        this.graphicsContext = graphicsContext;

        this.gameField = field;
        LoadImage.Map();

    }

    public void renderMap() {
        MapDrawer.render(graphicsContext);
   }

    public void render() {
        renderMap();
        gameField.update();
       for ( AbstractEntity entity : GameField.entities) {

           AbstractEntity lastEntity = null;
           if (lastEntity != null) continue;
           lastEntity = entity;
           if(entity != null) {
               entity.draw(graphicsContext);
           }

       }
   }



}
