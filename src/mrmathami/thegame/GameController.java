package mrmathami.thegame;

import javafx.animation.AnimationTimer;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import mrmathami.thegame.drawer.GameDrawer;
import mrmathami.thegame.entity.enemy.AbstractEnemy;
import mrmathami.thegame.entity.tile.tower.NormalTower;

import java.util.ArrayList;

/**
 * A game controller. Everything about the game should be managed in here.
 */
public final class GameController {

    private final GraphicsContext graphicsContext;
    private GameStage game = new GameStage();
    Scene gameScene;
    private GameField field = new GameField(game);
    private Group enemyLayer;
    private  AnimationTimer gameLoop;
    private GameDrawer drawer;
    static int[] typeTower = {0};
    public static boolean isMenuGame = false;
    public static boolean isReady = false;
    public static boolean isPlay = false;

    

    public GameController(GraphicsContext graphicsContext, Scene scene) {
        // The screen to draw on
        this.graphicsContext = graphicsContext;
        this.gameScene = scene;
        game = GameStage.load("res/stage/demo.txt");
        ////////////////////

        ////////////////////
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
        this.drawer = new GameDrawer(graphicsContext, field);
        menuGame();
        drawer.render();


    }

    public void handleEvent(){

        gameScene.setOnMouseClicked(this::buyTower);

    }

    public void menuGame(){
        isMenuGame = true;
        gameScene.setOnMouseClicked(mouseEvent -> {
            double posX = mouseEvent.getX();
            double posY = mouseEvent.getY();
            if (posX < 3 *32 && posY < 32) {
                isMenuGame = false;
                playGame();
            }
        });

    }
    public void playGame() {
        isPlay = true;
        /////////////////////////////////////////////////////////
        final LongProperty secondUpdate = new SimpleLongProperty(0);
        final LongProperty fpstimer = new SimpleLongProperty(0);
        ArrayList<AbstractEnemy> enemies = game._enemies;

        handleEvent();

        final AnimationTimer timer = new AnimationTimer() {
            int timer = Config.WAITING_TIME;
            int index = 0;

            @Override
            public void handle(long timestamp) {
                drawer.render();
                if (isReady) {
                    if (timestamp/ 1000000000 != secondUpdate.get()) {
                        timer--;
                        if(timer >= Config.ENEMY_DURATION_SPAWN && index < enemies.size()) {
                            GameField.addEntity(enemies.get(index++));
                        }
                        else if(timer <= 0 && index < enemies.size()){
                            GameField.addEntity(enemies.get(index));
                            timer = (int) (Config.ENEMY_DURATION_SPAWN + enemies.get(index++).getNumOfSpawn());
                        }
                    }
                    fpstimer.set(timestamp / 10000000);
                    secondUpdate.set(timestamp / 1000000000);
                }
            }
        };
        gameLoop = timer;
        timer.start();
    }

    public void buyTower(MouseEvent mouseEvent){
        /*Them tower*/
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();
        if (posX > 28*32 && posY > 18*32) isReady = true;
        else if (posX < 32 * 3 && posY < 32 * 2) typeTower[0] = 1;
        else if (posX > 100 && posY > 100 && typeTower[0] == 1) {
            field.addEntity(new NormalTower(posX, posY));
            typeTower[0] = 0;
        }
    }
}
