package mrmathami.thegame;

import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.enemy.*;
import mrmathami.thegame.entity.tile.Spawner;
import mrmathami.thegame.entity.tile.Target;
import mrmathami.thegame.entity.tile.tower.NormalTower;

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
    private int stage;
    private int wave;
    private int score;
    private int health;
    private long width;
    private long height;
    @Nonnull public static ArrayList<AbstractEnemy> _enemies = new ArrayList<AbstractEnemy>();
    @Nonnull public static ArrayList<AbstractEntity> _entities = new ArrayList<AbstractEntity>();
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

                for (int i = 0; i < numOfLine; i++) {
                    final String value = scanner.next();
                    if ("Spawner".equals(value)) {
                        _entities.add(new Spawner(x, y));
                    } else if ("NormalEnemy".equals(value)) {
                        final String direction = scanner.next();
                        int numOfSpawn = scanner.nextInt();
                        while(--numOfSpawn >= 0) _enemies.add(new NormalEnemy(x, y, direction, numOfSpawn));
                    } else if ("SmallerEnemy".equals(value)) {
                        final String direction = scanner.next();
                        int numOfSpawn = scanner.nextInt();
                        while(--numOfSpawn >= 0) _enemies.add(new SmallerEnemy(x, y, direction, numOfSpawn));
                    } else if ("TankerEnemy".equals(value)) {
                        final String direction = scanner.next();
                        int numOfSpawn = scanner.nextInt();
                        while(--numOfSpawn >= 0) _enemies.add(new TankerEnemy(x, y, direction, numOfSpawn));
                    } else if ("BossEnemy".equals(value)) {
                        final String direction = scanner.next();
                        int numOfSpawn = scanner.nextInt();
                        while(--numOfSpawn >= 0) _enemies.add(new BossEnemy(x, y, direction, numOfSpawn));
                    } else if ("Target".equals(value)) {
                        final int xTarget = scanner.nextInt();
                        final int yTarget = scanner.nextInt();
                        _entities.add(new Target(xTarget, yTarget));
                    } else if ("NormalTower".equals(value)) {
                        final int a = scanner.nextInt();
                        final int b = scanner.nextInt();
                        _entities.add(new NormalTower(a, b));
                    } else {
                        System.out.println("Unexpected value! Input value: " + value);
                        scanner.nextLine();
    //						throw new InputMismatchException("Unexpected value! Input value: " + value);
                    }
                }
                return new GameStage();
            } catch (NoSuchElementException e) {
                throw new IOException("Resource invalid! Resource name: " + name, e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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