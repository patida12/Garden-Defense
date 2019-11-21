package mrmathami.thegame;

import mrmathami.thegame.entity.Point;
import mrmathami.thegame.entity.enemy.*;
import mrmathami.thegame.entity.tile.Garden;
import mrmathami.thegame.entity.tile.Mountain;
import mrmathami.thegame.entity.tile.Road;
import mrmathami.thegame.entity.tile.Spawner;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class GameStage {
    private static GameStage playerGame;
    public static boolean isWin = false;
    public static boolean isGameOver = false;
    public static int star = 0;
    private int stage;
    private long width;
    private long height;

    @Nonnull public static ArrayList<ArrayList<AbstractEnemy>> waves = new ArrayList<>();
    @Nonnull public static ArrayList<Mountain> _grass = new ArrayList<Mountain>();
    @Nonnull public static ArrayList<Road> _road = new ArrayList<Road>();

    public static String[][] Map = new String[Config.TILE_VERTICAL][Config.TILE_HORIZONTAL];
    public static ArrayList<Point> path = new ArrayList<Point>();
    public static Map<Map<Integer, Integer>, Boolean> hashMap = new HashMap<>();

    private Spawner spawner;
    private Target target;

    public GameStage() {
        this.isWin = false;
        this.isGameOver = false;
        this.star = 0;

        this.stage = Config.IS_RUNNING;
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
                /**
                 * Load Map
                 * map 20 x 30
                 */
                for (int i = 0; i < Config.TILE_VERTICAL; i++) {
                    for (int j = 0; j < Config.TILE_HORIZONTAL; j++) {
                        Map[i][j] = null;
                    }
                }
                _grass.clear();
                _road.clear();
                hashMap.clear();
                for (int i = 0; i < Config.TILE_VERTICAL; i++){
                    String[] _row = scanner.nextLine().split("\\s");
                    for (int j = 0; j < Config.TILE_HORIZONTAL; j++) {
                        Map[i][j] = _row[j];
                        int tile = Integer.parseInt((_row[j]));
                        HashMap<Integer, Integer> temHashMap = new HashMap<>();
                        temHashMap.put(j, i);
                        if (tile >=5 && tile <=9 || tile >=23 && tile <=27 || tile >=41 && tile <= 43 || tile >=47 && tile <=228 )
                            {
                                _road.add(new Road(j * Config.TILE_SIZE, i * Config.TILE_SIZE));
                                hashMap.put(temHashMap, true);
                            }
                        else if (tile <= 4 || tile >=18 && tile <= 22 || tile >= 36 && tile <= 40 )
                            {
                                _grass.add(new Mountain(j * Config.TILE_SIZE, i * Config.TILE_SIZE));
                            }
                    }
                }

                /**
                 * Load Path
                 */
                ArrayList<Point> _path = new ArrayList<Point>();
                final int numOfPoint = scanner.nextInt();
                for (int i = 0; i < numOfPoint; i++){
                    _path.add(new Point(scanner.nextInt(), scanner.nextInt()));
                }
                path = _path;

                /**
                 * Load Entities
                 */
                // Spawner
                final int x = scanner.nextInt();
                final int y = scanner.nextInt();
                _road.add(new Spawner(x, y));
                //Garden
                final int xTarget = scanner.nextInt();
                final int yTarget = scanner.nextInt();
                _road.add(new Garden(xTarget, yTarget));

                ArrayList<ArrayList<AbstractEnemy>> _waves = new ArrayList<>();
                final int numOfLine = scanner.nextInt();
                for (int i = 0; i < numOfLine; i++) {
                    final int number = scanner.nextInt();
                    ArrayList<AbstractEnemy> _enemies = new ArrayList<AbstractEnemy>();
                    for (int j = 0; j < number; j++) {
                        final String value = scanner.next();
                        if ("NormalEnemy".equals(value)) {
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
                        } else {
                            System.out.println("Unexpected value! Input value: " + value);
                            scanner.nextLine();
        //						throw new InputMismatchException("Unexpected value! Input value: " + value);
                        }
                    }
                    _waves.add(_enemies);

                }
                waves = _waves;
                return new GameStage();
            } catch (NoSuchElementException e) {
                throw new IOException("Resource invalid! Resource name: " + name, e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isGameOver(){
        if (GameField.health <= 0) {
            isWin = false;
            isGameOver = true;
            this.stage = Config.IS_STOPPED;
            return true;
        }
        if (GameField.curWave > waves.size() && GameField.live == 0) {
            isWin = true;
            if (GameField.health < 50) star = 1;
            else if (GameField.health < 90) star = 2;
            else star = 3;
            isGameOver = true;
            this.stage = Config.IS_STOPPED;
            return true;
        }
        isGameOver = false;
        return false;
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

    public static void resetGameStage() {
        try {
            GameController.game = getNewgame();
            GameField.entities.removeAll(GameField.entities);
        } catch (Exception e){}
    }


}