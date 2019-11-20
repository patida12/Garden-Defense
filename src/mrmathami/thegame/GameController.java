package mrmathami.thegame;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mrmathami.thegame.drawer.GameDrawer;
import mrmathami.thegame.entity.enemy.Wave;
import mrmathami.thegame.entity.tile.tower.BuyTower;

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
    private GameStage game3 = new GameStage();
    private Wave wave = new Wave();
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

        GameStage _game = new GameStage();

        initGameStage(_game);

        // Just a few acronyms.
        final long width = Config.TILE_HORIZONTAL;
        final long height = Config.TILE_VERTICAL;

        startGameLoop();

        primaryStage.setScene(gameScene);
        primaryStage.setTitle("Garden Defense");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void initGameStage(GameStage gameStage){
        game = gameStage;
        field = new GameField(gameStage);
        wave = new Wave(5);
    }
    
    public void initGame(){
         isStartMenuGame = true;
         isSelectMap = false;
         isSelected = false;
         isMenu = false;
         isReady = false;
         isPlay = false;
    }

    public  Scene getGameScene(){
        return gameScene;
    }

    public void stopGame(){
        gameLoop.stop();
        game.setStage(Config.IS_STOPPED);
        isPlay = false;
        isReady = false;
        isMenu = false;
        GameField.curWave = 0;
    }

    public void pauseGame(){
        game.setStage(Config.IS_PAUSED);
    }

    public void resumeGame(){
        isMenu = false;
        game.setStage(Config.IS_RUNNING);
    }

    public void startGameLoop() {
        drawer = new GameDrawer(graphicsContext, field);
        if (isStartMenuGame) {
            showStartMenuGame();
        }

    }

    public void playGame() {
        isPlay = true;
        canvas.setOnMousePressed(this::handleEvent);


         final AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long timestamp) {
                drawer.render();
                if (isReady && game.isRunning()) {
                   // System.out.println("ready");
                    wave.update();
                    showGameOver();
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

        if (posX > 28*32 && posY > 18*32){
            isReady = true;
            if (GameField.curWave > 0 ) {
                GameField.curWave++;
               // System.out.println(GameStage.waves.size());
            }
        }
    }

    public void selectMap(MouseEvent mouseEvent){
        double posX = mouseEvent.getX();
        double posY = mouseEvent.getY();
        if (!isSelected &&posX < 320) {
            isSelected = false;
            System.out.println("1");
            game1 = GameStage.load("res/stage/map1.txt");
            game = game1;
            initGameStage(game1);

            isSelected = true;
        }
        if (!isSelected && posX > 320 && posX < 640) {
            isSelected = false;
            System.out.println("2");
            game2 = GameStage.load("res/stage/map2.txt");
            game = game2;
            initGameStage(game2);

            isSelected = true;
        }
        if (!isSelected && posX >= 640) {
            isSelected = false;
            System.out.println("3");
            game3 = GameStage.load("res/stage/map3.txt");
            game = game3;
            initGameStage(game3);

            isSelected = true;
        }
    }

    public void showSelectMap(){
        isSelectMap = true;
        isSelected = false;
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
        if(isMenu){
            pauseGame();
            drawer.render();
            GameDrawer.resume_button.setOnMousePressed(mouseEvent1 -> {
                GameDrawer.resume_button.setEffect(GameDrawer.shadow);
                graphicsContext.setGlobalAlpha(1);
                resumeGame();
            });

            GameDrawer.restart_button.setOnMousePressed(mouseEvent1 -> {
                GameDrawer.restart_button.setEffect(GameDrawer.shadow);
                graphicsContext.setGlobalAlpha(1);
                stopGame();

                GameStage.getNewgame();
                initGameStage(GameStage.load("res/stage/map1.txt"));
                playGame();
            });

            GameDrawer.select_map_button.setOnMousePressed(mouseEvent1 -> {
                GameDrawer.select_map_button.setEffect(GameDrawer.shadow);
                graphicsContext.setGlobalAlpha(1);
                stopGame();
                showSelectMap();
            });
        }
    }

    public void showGameOver() {
        if (game.isGameOver()) {
            GameDrawer.start_menu_button.setOnMousePressed(mouseEvent2 -> {
                GameDrawer.start_menu_button.setEffect(GameDrawer.shadow);
                //game = new GameStage();
                GameDrawer.start_menu_button.setVisible(false);
                stopGame();
                initGameStage(GameStage.load("res/stage/map1.txt"));
                initGame();
                showStartMenuGame();
            });

            GameDrawer.quit_button.setOnMouseClicked(mouseEvent1 -> {
                GameDrawer.quit_button.setEffect(GameDrawer.shadow);
                isStartMenuGame = false;
                Platform.exit();
            });
        }
    }
}
