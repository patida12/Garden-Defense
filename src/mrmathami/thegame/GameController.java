package mrmathami.thegame;

import javafx.animation.AnimationTimer;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.GameDrawer;
import mrmathami.thegame.entity.enemy.AbstractEnemy;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A game controller. Everything about the game should be managed in here.
 */
public final class GameController {

    private final GraphicsContext graphicsContext;
    private GameStage game = new GameStage();
    private  Scene gameScene;
    private GameField field = new GameField(game);
    private Group enemyLayer;
    private  AnimationTimer gameLoop;
    private GameDrawer drawer;

    

    public GameController(GraphicsContext graphicsContext) {
        // The screen to draw on
        this.graphicsContext = graphicsContext;
        game = GameStage.load("C:\\Users\\User\\Documents\\GitHub\\thegame-master\\Garden-Defense\\src\\stage\\demo.txt");
        field = new GameField(game);

        // Just a few acronyms.
        final long width = Config.TILE_HORIZONTAL;
        final long height = Config.TILE_VERTICAL;

        startGameLoop();

    }

    public  Scene getGameScene(){
        return gameScene;
    }

    public void stopGame(){
        pauseGame();
        game.setStage(Config.IS_STOPPED);
        gameLoop.stop();
    }

    public void pauseGame(){
        game.setStage(Config.IS_PAUSED);
    }

    public void resumeGame(){
        game.setStage(Config.IS_RUNNING);
    }



    public void startGameLoop() {
        final LongProperty secondUpdate = new SimpleLongProperty(0);
        final LongProperty fpstimer = new SimpleLongProperty(0);
        this.drawer = new GameDrawer(graphicsContext, field);
        ArrayList<AbstractEnemy> enemies = game._enemies;System.out.println(enemies.size());
        Iterator iterator = enemies.iterator();

        final AnimationTimer timer = new AnimationTimer() {
            int timer = Config.WAITING_TIME;
            int index = 0;
            @Override
            public void handle(long timestamp) {

                if (timestamp/ 1000000000 != secondUpdate.get()) {
                    timer--;
                    if(timer >= Config.ENEMY_DURATION_SPAWN && index < enemies.size()) {
                        //System.out.println(" timer> duration");
                        GameField.addEntity(enemies.get(index++));
                    }
                    else if(timer <= 0 && index < enemies.size()){
                        //System.out.println(" timer <= 0");
                        GameField.addEntity(enemies.get(index));
                        timer = (int) (Config.ENEMY_DURATION_SPAWN + enemies.get(index++).getNumOfSpawn());
                    }
                }
                fpstimer.set(timestamp / 10000000);
                secondUpdate.set(timestamp / 1000000000);
                drawer.render();
            }
        };
        gameLoop = timer;
        timer.start();
    }
}
