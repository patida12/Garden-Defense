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
        entities.addAll(gameStage._entities);
    }

    public void update(){
        iterator = entities.iterator();
        while(iterator.hasNext()) {
            AbstractEntity entity = (AbstractEntity) iterator.next();
            if( entity == null) {
                iterator.remove();
                continue;
            }
            entity.update();
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
        entities.set(entities.indexOf(entity), null);
    }

}
