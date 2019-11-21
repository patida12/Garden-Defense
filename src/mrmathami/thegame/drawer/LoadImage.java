package mrmathami.thegame.drawer;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class LoadImage {
    public static Image[] map = new Image[230];
    public static Image normalEnemy = new Image("file:src/assets/images/normalEnemy.png");
    public static Image bossEnemy = new Image("file:src/assets/images/bossEnemy.png");
    public static Image smallerEnemyDrawer = new Image("file:src/assets/images/smallerEnemy.png");
    public static Image tankerEnemy = new Image("file:src/assets/images/tankerEnemy.png");
    public static Image machineGunTower = new Image("file:src/assets/images/machineGunTower.png");
    public static Image normalTower = new Image("file:src/assets/images/normalTower.png");
    public static Image sniperTower = new Image("file:src/assets/images/sniperTower.png");
    public static Image machineGunBullet = new Image("file:src/assets/images/tankerEnemy.png");
    public static Image sniperBullet = new Image("file:src/assets/images/tankerEnemy.png");
    public static Image normalBullet = new Image("file:src/assets/images/tankerEnemy.png");
    public static Image target = new Image("file:src/assets/images/target.png");
    public static Image spawner = new Image("file:src/assets/images/spawner.png");
    public static Image startMenu = new Image("file:src/assets/images/startMenu.jpg");
    public static Image display = new Image("file:src/assets/images/display.png");
    public static Image play = new Image("file:src/assets/images/start_bt.png");
    public static Image start = new Image("file:src/assets/images/start_bt.png");
    public static Image menu = new Image("file:src/assets/images/menu/Layer-2.png");
    public static Image quit = new Image("file:src/assets/images/botan_quit.png");
    public static Image restart = new Image("file:src/assets/images/botan_restart.png");
    public static Image gameOver = new Image("file:src/assets/images/gameOver.jpg");
    public static Image star = new Image("file:src/assets/images/star.png");
    public static Image map1 = new Image("file:src/assets/images/map1.png");
    public static Image map2 = new Image("file:src/assets/images/map2.png");
    public static Image map3 = new Image("file:src/assets/images/map3.png");
    public static String musicSMPath = "C:\\Users\\User\\Documents\\GitHub\\thegame-master\\Garden-Defense\\src\\assets\\sound\\music.mp3";
    public static String musicPlayPath = "C:\\Users\\User\\Documents\\GitHub\\thegame-master\\Garden-Defense\\src\\assets\\sound\\play.mp3";
    public static String musicWinPath = "C:\\Users\\User\\Documents\\GitHub\\thegame-master\\Garden-Defense\\src\\assets\\sound\\victoryff.swf.mp3";

    public static Media musicStartMenu = new Media(new File(musicSMPath).toURI().toString());
    public static MediaPlayer musicSMPlayer = new MediaPlayer(musicStartMenu);

    public static Media musicPlay = new Media(new File(musicPlayPath).toURI().toString());
    public static MediaPlayer musicPlayPlayer = new MediaPlayer(musicPlay);

    public static Media musicWin = new Media(new File(musicWinPath).toURI().toString());
    public static MediaPlayer musicWinPlayer = new MediaPlayer(musicWin);

    public static void Map() {
        for (int i = 0; i < 230; i++) {
            String index = "";
            if(i < 10) index = "00" + String.valueOf(i);
            else if(i <100) index = "0" + String.valueOf(i);
            else index = String.valueOf(i);
            map[i] = new Image("file:src/assets/images/rpgTile" + index + ".png");
        }

    }

}
