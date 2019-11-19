package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;
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

    public static DropShadow shadow = new DropShadow();
    public static Button play_button = new Button();
    public static Button quit_button = new Button();
    public static Button start_button = new Button();
    public static Button back_button = new Button();
    public static Button restart_button = new Button();
    public static Button resume_button = new Button();
    public static Button select_map_button = new Button();

    public GameDrawer(GraphicsContext graphicsContext, GameField field) {
        this.graphicsContext = graphicsContext;
        this.gameField = field;
        LoadImage.Map();

        GameController.root.getChildren().add(play_button); play_button.setVisible(false);
        GameController.root.getChildren().add(quit_button); quit_button.setVisible(false);
        GameController.root.getChildren().add(start_button); start_button.setVisible(false);
        GameController.root.getChildren().add(back_button); back_button.setVisible(false);
        GameController.root.getChildren().add(restart_button); restart_button.setVisible(false);
        GameController.root.getChildren().add(resume_button); resume_button.setVisible(false);
        GameController.root.getChildren().add(select_map_button); select_map_button.setVisible((false));
    }

    public void renderStartMenu(){
        graphicsContext.drawImage(LoadImage.startMenu,0,0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        
        play_button.setStyle("-fx-background-color: YELLOW");
        play_button.setFont(Font.loadFont("file:src/assets/text/zorque.ttf", 30));
        play_button.setText("Play");
        play_button.setMinSize(100, 30);
        play_button.setLayoutX(430);
        play_button.setLayoutY(500);

        quit_button.setStyle("-fx-background-color: YELLOW");
        quit_button.setFont(Font.loadFont("file:src/assets/text/zorque.ttf", 30));
        quit_button.setText("Quit");
        quit_button.setMinSize(100, 30);
        quit_button.setLayoutX(430);
        quit_button.setLayoutY(570);

        play_button.setVisible(true);
        quit_button.setVisible(true);
    }

    public void renderSelectMap(){
        graphicsContext.drawImage(LoadImage.start,0,0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        start_button.setStyle("-fx-background-color: YELLOW");
        start_button.setFont(Font.loadFont("file:src/assets/text/zorque.ttf", 30));
        start_button.setText("Start");
        start_button.setMinSize(100, 30);
        start_button.setLayoutX(430);
        start_button.setLayoutY(500);

        back_button.setStyle("-fx-background-color: YELLOW");
        back_button.setFont(Font.loadFont("file:src/assets/text/zorque.ttf", 30));
        back_button.setText("Back");
        back_button.setMinSize(100, 30);
        back_button.setLayoutX(430);
        back_button.setLayoutY(570);

        start_button.setVisible(true);
        back_button.setVisible(true);
    }
    
    public void renderMenu(){
//        graphicsContext.setGlobalAlpha(0.3);

        resume_button.setStyle("-fx-background-color: YELLOW");
        resume_button.setFont(Font.loadFont("file:src/assets/text/zorque.ttf", 30));
        resume_button.setText("Resume");
        resume_button.setMinSize(100, 30);
        resume_button.setLayoutX(430);
        resume_button.setLayoutY(430);

        restart_button.setStyle("-fx-background-color: YELLOW");
        restart_button.setFont(Font.loadFont("file:src/assets/text/zorque.ttf", 30));
        restart_button.setText("Restart");
        restart_button.setMinSize(100, 30);
        restart_button.setLayoutX(430);
        restart_button.setLayoutY(500);

        select_map_button.setStyle("-fx-background-color: YELLOW");
        select_map_button.setFont(Font.loadFont("file:src/assets/text/zorque.ttf", 30));
        select_map_button.setText("Select Map");
        select_map_button.setMinSize(100, 30);
        select_map_button.setLayoutX(430);
        select_map_button.setLayoutY(570);

        resume_button.setVisible(true);
        restart_button.setVisible(true);
        select_map_button.setVisible(true);

    }
    
    public void renderMap() {
        MapDrawer.render(graphicsContext);
   }

    public void render() {

        if (GameController.isStartMenuGame){
            renderStartMenu();
        } else{
            play_button.setVisible(false);
            quit_button.setVisible(false);
        }

        if (GameController.isSelectMap) {
            renderSelectMap();
        } else {
            start_button.setVisible(false);
            back_button.setVisible(false);
        }

        if (GameController.isMenu) {
            renderMenu();
        } else {
//            GameController.root.getChildren().remove(restart_button);
//            GameController.root.getChildren().remove(resume_button);
//            GameController.root.getChildren().remove(select_map_button);
            resume_button.setVisible(false);
            restart_button.setVisible(false);
            select_map_button.setVisible(false);
        }

        if (GameController.isPlay){
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
