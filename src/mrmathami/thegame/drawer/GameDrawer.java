package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
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

    public static boolean selectGame1 = false;
    public static boolean selectGame2 = false;
    public static boolean selectGame3 = false;

    public static DropShadow shadow = new DropShadow();
    public static Button play_button = new Button();
    public static Button quit_button = new Button();
    public static Button start_button = new Button();
    public static Button back_button = new Button();
    public static Button restart_button = new Button();
    public static Button resume_button = new Button();
    public static Button select_map_button = new Button();
    public static Button start_menu_button = new Button();

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
        GameController.root.getChildren().add(start_menu_button); start_menu_button.setVisible((false));
    }

    public void resetGameDrawer(){
        GameController.root.getChildren().remove(play_button); 
        GameController.root.getChildren().remove(quit_button);
        GameController.root.getChildren().remove(start_button); 
        GameController.root.getChildren().remove(back_button); 
        GameController.root.getChildren().remove(restart_button); 
        GameController.root.getChildren().remove(resume_button); 
        GameController.root.getChildren().remove(select_map_button); 
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
        graphicsContext.setStroke(Color.YELLOW);
        graphicsContext.setLineWidth(4);

        graphicsContext.drawImage(LoadImage.map1,5,300);
        graphicsContext.drawImage(LoadImage.map2,380,300);
        graphicsContext.drawImage(LoadImage.map3,700,300);




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
        back_button.setLayoutX(433);
        back_button.setLayoutY(570);

        start_button.setVisible(true);
        back_button.setVisible(true);
    }
    
    public void renderMenu(){
        graphicsContext.setGlobalAlpha(0.3);

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

   public void renderGameOver() {
       graphicsContext.drawImage(LoadImage.gameOver, 0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
       graphicsContext.setFont(Font.loadFont("file:src/assets/text/Diavlo_BOLD_II_37.otf", 50));
       if (GameStage.isWin) {
           graphicsContext.setFill(Color.YELLOW);
           graphicsContext.fillText("Win!", 440, 100, 200);
           for (int i = 8; i < GameStage.star + 8; i++) {
               graphicsContext.drawImage(LoadImage.star, i * 52,160, 50, 50);
           }
       } else {
           graphicsContext.setFill(Color.ROSYBROWN);
           graphicsContext.fillText("Lose!", 440, 160, 200);
       }
       graphicsContext.setFont(Font.loadFont("file:src/assets/text/Diavlo_BOLD_II_37.otf", 20));
       graphicsContext.setFill(Color.DARKGOLDENROD);
       graphicsContext.fillText("Cash: " + String.valueOf(GameField.cash) + " $", 445, 13 * 32 - 6);
       graphicsContext.setFill(Color.RED);
       graphicsContext.fillText("Health: " + String.valueOf(GameField.health) , 445, 14 * 32 - 6);

       start_menu_button.setStyle("-fx-background-color: YELLOW");
       start_menu_button.setFont(Font.loadFont("file:src/assets/text/zorque.ttf", 30));
       start_menu_button.setText("Menu");
       start_menu_button.setMinSize(100, 30);
       start_menu_button.setLayoutX(430);
       start_menu_button.setLayoutY(500);

       start_menu_button.setVisible(true);
       quit_button.setVisible(true);
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
            resume_button.setVisible(false);
            restart_button.setVisible(false);
            select_map_button.setVisible(false);
        }

        if (GameController.isPlay){
            renderMap();
            gameField.update();
            if (GameStage.isGameOver) {
                renderGameOver();
            } else {
                start_menu_button.setVisible(false);
                quit_button.setVisible(false);
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
}
