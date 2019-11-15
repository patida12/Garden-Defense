package mrmathami.thegame;

import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.enemy.AbstractEnemy;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public final class GameField {
    @Nonnull public static  ArrayList<AbstractEntity> entities = new ArrayList<AbstractEntity>();
    public static int score;
    public static int  health;
    public static int live;
    private final double width;

    private final double height;

    public GameField( @Nonnull GameStage gameStage) {
        this.score = 0;
        this.health = 100;
        this.live = 0;
        this.width = gameStage.getWidth();
        this.height = gameStage.getHeight();
        entities.addAll(gameStage._grass);
        entities.addAll(gameStage._road);
        //entities.addAll(BuyTower.storeTower);
    }

    public void update(){
        for (int i = entities.size() - 1; i >= 0; i--) {
            if( entities.get(i) == null) {
                continue;
            }
            else
                entities.get(i).update();
        }

    }

    public final double getWidth() {
        return width;
    }

    public final double getHeight() {
        return height;
    }

    public static int countEnemies(){
        live = 0;
        for (AbstractEntity entity : entities) {
            if (entity instanceof AbstractEnemy)
                live++;
        }
        return live;
    }

    public static void addEntity(AbstractEntity entity) {
        entities.add(entity);
    }
    public static void removeEntity(AbstractEntity entity){
        entities.remove(entity);
    }

}
