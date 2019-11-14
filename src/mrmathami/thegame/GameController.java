package mrmathami.thegame;

import javafx.animation.AnimationTimer;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mrmathami.thegame.drawer.GameDrawer;
import mrmathami.thegame.entity.enemy.AbstractEnemy;
import mrmathami.thegame.entity.tile.tower.BuyTower;

import java.util.ArrayList;

/**
 * A game controller. Everything about the game should be managed in here.
 */
public final class GameController {

    private Canvas canvas;
    private Group root;
    public  static   GraphicsContext graphicsContext;
    public  static  MouseEvent mouseEvent;
    private Scene gameScene;
    private  AnimationTimer gameLoop;

    private GameStage game = new GameStage();
    private GameField field = new GameField(game);
    private GameDrawer drawer;
    private BuyTower buyTower = new BuyTower();
    static int[] typeTower = {0};
    public static boolean isMenuGame = false;
    public static boolean isReady = false;
    public static boolean isPlay = false;


    public GameController(Stage primaryStage, Canvas _canvas, Group root) {
        this.canvas = _canvas;
        this.root = root;
        root.getChildren().add(canvas);

        // Tao scene
        this.gameScene = new Scene(root);
        this.graphicsContext = canvas.getGraphicsContext2D();

        game = GameStage.load("res/stage/demo.txt");

        field = new GameField(game);

        // Just a few acronyms.
        final long width = Config.TILE_HORIZONTAL;
        final long height = Config.TILE_VERTICAL;

        startGameLoop();
        canvas.setOnMouseClicked(this::handleEvent);
        //canvas.setOnMouseDragged(this::handleEvent);

        primaryStage.setScene(gameScene);
        primaryStage.setTitle("Garden Defense");
        primaryStage.setResizable(false);
        primaryStage.show();

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

    public void handleEvent(MouseEvent mouseEvent){
        buyTower.chooseTower(mouseEvent);
        buyTower.holdTower(mouseEvent, graphicsContext);
        isReady(mouseEvent);
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

        //handleEvent();

        final AnimationTimer timer = new AnimationTimer() {
            int timer = Config.WAITING_TIME;
            int index = 0;

            @Override
            public void handle(long timestamp) {
                drawer.render();
                if (isReady) {
                    if (timestamp/ 1000000000 != secondUpdate.get()) {
                        timer --;
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

    public void isReady(MouseEvent mouseEvent){
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();
        if (posX > 28*32 && posY > 18*32) isReady = true;
    }
}
