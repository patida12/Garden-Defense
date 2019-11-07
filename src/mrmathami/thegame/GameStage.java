package mrmathami.thegame;

import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.enemy.BossEnemy;
import mrmathami.thegame.entity.enemy.NormalEnemy;
import mrmathami.thegame.entity.enemy.SmallerEnemy;
import mrmathami.thegame.entity.enemy.TankerEnemy;
import mrmathami.thegame.entity.tile.Spawner;
import mrmathami.thegame.entity.tile.Target;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GameStage {
    private static GameStage playerGame;
    @Nonnull private ArrayList<AbstractEntity> entities = new ArrayList<>();
    private int stage;
    private int wave;
    private int score;
    private int health;
    private long width;
    private long height;
    private Spawner spawner;
    private Target target;
   

     public GameStage() {
        this.stage = Config.IS_RUNNING;
        this.wave = 0;
        this.score = 0;
        this.health = 0;
        this.width = Config.SCREEN_WIDTH;
        this.height = Config.SCREEN_HEIGHT;
    }

    GameStage(@Nonnull ArrayList<AbstractEntity> entities) {
        this.stage = Config.IS_RUNNING;
        this.wave = 0;
        this.score = 0;
        this.health = 0;
        this.width = Config.SCREEN_WIDTH;
        this.height = Config.SCREEN_HEIGHT;
        this.entities = entities;
    }

    private GameStage(int health, ArrayList<AbstractEntity> entities, Spawner spawner, Target target) {
        this.stage = Config.IS_RUNNING;
        this.wave = wave;
        this.score = 0;
        this.health = health;
        this.width = Config.SCREEN_WIDTH;
        this.height = Config.SCREEN_HEIGHT;
        this.entities = entities;
        this.spawner = spawner;
        this.target = target;
    }

    public static GameStage getNewgame() throws NullPointerException {
        playerGame = new GameStage();
        return playerGame;
    }

    public static GameStage getGame() throws NullPointerException{
        return playerGame;
    }

    @Nullable
    public static GameStage load(@Nonnull String name) {
        try (final InputStream stream = new FileInputStream(new File(name))) {
            if (stream == null) throw new IOException("Resource not found! Resource name: " + name);
            final Scanner scanner = new Scanner(stream);
            try {
                final int numOfLine = scanner.nextInt();
                final int x = scanner.nextInt();
                final int y = scanner.nextInt();
                final ArrayList<AbstractEntity> entities = new ArrayList<>();

                for (int i = 0; i < numOfLine; i++) {
                    final String value = scanner.next();
                    if ("Spawner".equals(value)) {
                        entities.add(new Spawner(x, y));
                    } else if ("NormalEnemy".equals(value)) {
                        final String direction = scanner.next();
                        final int numOfSpawn = scanner.nextInt();
                        entities.add(new NormalEnemy(x, y, direction, numOfSpawn));
                    } else if ("SmallerEnemy".equals(value)) {
                        final String direction = scanner.next();
                        final int numOfSpawn = scanner.nextInt();
                        entities.add(new SmallerEnemy(x, y, direction, numOfSpawn));
                    } else if ("TankerEnemy".equals(value)) {
                        final String direction = scanner.next();
                        final int numOfSpawn = scanner.nextInt();
                        entities.add(new TankerEnemy(x, y, direction, numOfSpawn));
                    } else if ("BossEnemy".equals(value)) {
                        final String direction = scanner.next();
                        final int numOfSpawn = scanner.nextInt();
                        entities.add(new BossEnemy(x, y, direction, numOfSpawn));
                    } else if ("Target".equals(value)) {
                        final int xTarget = scanner.nextInt();
                        final int yTarget = scanner.nextInt();
                        entities.add(new Target(xTarget, yTarget));
                    } else {
                        System.out.println("Unexpected value! Input value: " + value);
                        scanner.nextLine();
    //						throw new InputMismatchException("Unexpected value! Input value: " + value);
                    }
                }
                return new GameStage(entities);
            } catch (NoSuchElementException e) {
                throw new IOException("Resource invalid! Resource name: " + name, e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nonnull
    public ArrayList<AbstractEntity> getEntities() {
        return entities;
    }


    public boolean isPaused(){
        return stage == Config.IS_PAUSED;
    }

    public boolean isRunning(){
        return stage == Config.IS_RUNNING;
    }

    public boolean isStopped(){
        return stage == Config.IS_STOPPED;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setTarget(Target target) {
        this.target = target;
    }
    public void setStage(int stage) {
        this.stage = stage;
    }

}