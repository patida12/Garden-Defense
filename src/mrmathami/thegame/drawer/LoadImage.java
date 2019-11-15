package mrmathami.thegame.drawer;

import javafx.scene.image.Image;

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
    public static Image startMenu = new Image("file:src/assets/images/startMenu.png");
    public static Image display = new Image("file:src/assets/images/display.png");


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
