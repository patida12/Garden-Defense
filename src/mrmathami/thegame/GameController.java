package mrmathami.thegame;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
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
    public static Group root;
    public static GraphicsContext graphicsContext;
    public static MouseEvent mouseEvent;
    private Scene gameScene;
    private  AnimationTimer gameLoop;

    public static GameStage game = new GameStage();
    private GameStage game1 = new GameStage();
    private GameStage game2 = new GameStage();
    private GameField field ;
    private GameDrawer drawer;
    private BuyTower buyTower = new BuyTower();

    public static boolean isStartMenuGame = true;
    public static boolean isSelectMap = false;
    public static boolean isSelected = false;
    public static boolean isMenu = false;
    public static boolean isReady = false;
    public static boolean isPlay = false;


    public GameController(Stage primaryStage, Canvas _canvas, Group root) {
        this.canvas = _canvas;
        this.root = root;
        root.getChildren().add(canvas);

        // Tao scene
        this.gameScene = new Scene(root);
        this.graphicsContext = canvas.getGraphicsContext2D();
//
        game = GameStage.load("res/stage/demo.txt");

        field = new GameField(game);

        // Just a few acronyms.
        final long width = Config.TILE_HORIZONTAL;
        final long height = Config.TILE_VERTICAL;

        startGameLoop();



        primaryStage.setScene(gameScene);
        primaryStage.setTitle("Garden Defense");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public  Scene getGameScene(){
        return gameScene;
    }

    public void stopGame(){
        isMenu = false;
        pauseGame();
        game.setStage(Config.IS_STOPPED);
        gameLoop.stop();
    }

    public void pauseGame(){
        game.setStage(Config.IS_PAUSED);
    }

    public void resumeGame(){
        isMenu = false;
        game.setStage(Config.IS_RUNNING);
    }

    public void startGameLoop() {
        this.drawer = new GameDrawer(graphicsContext, field);

        if (isStartMenuGame) {
            showStartMenuGame();
        }

    }

    public void playGame() {
        isPlay = true;
        /////////////////////////////////////////////////////////
        final LongProperty secondUpdate = new SimpleLongProperty(0);
        final LongProperty fpstimer = new SimpleLongProperty(0);
        ArrayList<AbstractEnemy> enemies = game._enemies;
        canvas.setOnMousePressed(this::handleEvent);


         final AnimationTimer timer = new AnimationTimer() {
            int time = Config.WAITING_TIME;
            int index = 0;

            @Override
            public void handle(long timestamp) {
                System.out.println("df");
                drawer.render();
                if (isReady) {
                    if (timestamp/ 1000000000 != secondUpdate.get()) {
                        time --;
                        if(time >= Config.ENEMY_DURATION_SPAWN && index < enemies.size()) {
                            GameField.addEntity(enemies.get(index++));
                        }
                        else if(time <= 0 && index < enemies.size()){
                            GameField.addEntity(enemies.get(index));
                            time = (int) (Config.ENEMY_DURATION_SPAWN + enemies.get(index++).getNumOfSpawn());
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


    public void handleEvent(MouseEvent mouseEvent){
        if (game.isRunning()){
            buyTower.chooseTower(mouseEvent);
            buyTower.holdTower(mouseEvent, graphicsContext);
            checkReady(mouseEvent);
        }
        if(!isMenu) checkIsMenu(mouseEvent);
    }

    public void showStartMenuGame(){
        isStartMenuGame = true;
        drawer.render();

        GameDrawer.play_button.setOnMousePressed(mouseEvent2 -> {
            GameDrawer.play_button.setEffect(GameDrawer.shadow);
            isStartMenuGame = false;
            showSelectMap();
        });

        GameDrawer.quit_button.setOnMouseClicked(mouseEvent1 -> {
            GameDrawer.quit_button.setEffect(GameDrawer.shadow);
            isStartMenuGame = false;
            Platform.exit();
        });
    }

    public void checkReady(MouseEvent mouseEvent){
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();

        if (posX > 28*32 && posY > 18*32) isReady = true;
    }

    public void selectMap(MouseEvent mouseEvent){
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();
        if (!isSelected &&posX < 320) {
            isSelectMap = false;
            System.out.println("1");
            game = GameStage.load("res/stage/demo.txt");;
            field = new GameField(game);
            isSelected = true;
        }
        if (!isSelected && posX > 320 && posX < 640) {
            isSelectMap = false;
            System.out.println("2");
            game = GameStage.load("res/stage/demo1.txt");
            field = new GameField(game);
            isSelected = true;
        }
    }

    public void showSelectMap(){
        isSelectMap = true;
        canvas.setOnMouseClicked(this::selectMap);
        drawer.render();

        GameDrawer.start_button.setOnMousePressed(mouseEvent2 -> {
            GameDrawer.start_button.setEffect(GameDrawer.shadow);
            isSelectMap = false;
            playGame();
        });

        GameDrawer.back_button.setOnMousePressed(mouseEvent2 -> {
            GameDrawer.back_button.setEffect(GameDrawer.shadow);
            isSelectMap = false;
            showStartMenuGame();
        });
    }

    public void checkIsMenu(MouseEvent mouseEvent){
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();
        if (posX < 3 * 32 && posY < 32){
            isMenu = true;
            showMenu();
        }
    }

    public void showMenu(){
    //    canvas.setOnMouseClicked(this::checkIsMenu);

        if(isMenu){
            game.setStage(Config.IS_PAUSED);
            drawer.render();
            GameDrawer.resume_button.setOnMousePressed(mouseEvent1 -> {
                GameDrawer.resume_button.setEffect(GameDrawer.shadow);
                resumeGame();
            });

            GameDrawer.restart_button.setOnMousePressed(mouseEvent1 -> {
                GameDrawer.restart_button.setEffect(GameDrawer.shadow);
                isMenu = false;
                game.setStage(Config.IS_STOPPED);
                GameStage.getNewgame();
                playGame();
            });

            GameDrawer.select_map_button.setOnMousePressed(mouseEvent1 -> {
                GameDrawer.select_map_button.setEffect(GameDrawer.shadow);
                stopGame();
                showSelectMap();
            });
        }
    }

}
