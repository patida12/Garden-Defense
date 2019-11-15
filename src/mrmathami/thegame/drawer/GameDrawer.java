package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import mrmathami.thegame.Config;
import mrmathami.thegame.GameController;
import mrmathami.thegame.GameField;
import mrmathami.thegame.GameStage;
import mrmathami.thegame.drawer.mapDrawer.MapDrawer;
import mrmathami.thegame.entity.AbstractEntity;

import javax.annotation.Nonnull;

public final class GameDrawer {
    @Nonnull
    private GraphicsContext graphicsContext;
    @Nonnull private GameField gameField = new GameField(new GameStage());
    FieldDrawer fieldDrawer = new FieldDrawer();

    public GameDrawer(GraphicsContext graphicsContext, GameField field) {
        this.graphicsContext = graphicsContext;
        this.gameField = field;
        LoadImage.Map();
    }

    public void renderStartMenu(){graphicsContext.drawImage(LoadImage.startMenu,0,0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);}

    public void renderMap() {
        MapDrawer.render(graphicsContext);
   }

    public void render() {

        if (GameController.isMenuGame){
            renderStartMenu();
            graphicsContext.setFill(Color.RED);
            graphicsContext.fillRect(0,0,3*32,32);
            graphicsContext.strokeText("Start", 10,10, 3*32);
        }
        if (GameController.isPlay) {
            renderMap();
            gameField.update();
            for (AbstractEntity entity : GameField.entities) {
                AbstractEntity lastEntity = null;
                if (lastEntity != null) continue;
                lastEntity = entity;
                if (entity != null) {
                    entity.draw(graphicsContext);
                }
            }
            fieldDrawer.draw(graphicsContext);
        }
   }
}
