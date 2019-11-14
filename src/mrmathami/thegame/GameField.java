package mrmathami.thegame;

import mrmathami.thegame.entity.AbstractEntity;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;

public final class GameField {
    @Nonnull public static  ArrayList<AbstractEntity> entities = new ArrayList<AbstractEntity>();
    Iterator iterator;

    private final double width;

    private final double height;

    public GameField( @Nonnull GameStage gameStage) {
        this.width = gameStage.getWidth();
        this.height = gameStage.getHeight();
        entities.addAll(gameStage._grass);
        entities.addAll(gameStage._road);
        entities.addAll(gameStage.storeTower);
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

        //System.out.println(entities.size());

    }

    public final double getWidth() {
        return width;
    }

    public final double getHeight() {
        return height;
    }

    public static void addEntity(AbstractEntity entity) {
        entities.add(entity);
    }
    public static void removeEntity(AbstractEntity entity){
        entities.remove(entity);
    }

}
