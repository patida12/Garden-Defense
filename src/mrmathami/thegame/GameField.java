package mrmathami.thegame;

import javafx.event.EventHandler;
import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.tile.tower.NormalTower;

import javax.annotation.Nonnull;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public final class GameField {
    public static int count = 50;
    @Nonnull private  ArrayList<AbstractEntity> entities;

    private final double width;

    private final double height;

    public GameField( @Nonnull GameStage gameStage) {
        this.width = gameStage.getWidth();
        this.height = gameStage.getHeight();
        this.entities = gameStage.getEntities();
    }

    public void update(){

        for (AbstractEntity entity : entities) {
            entity.update(); }
        System.out.println(entities.size());

        /*if(--count == 0) {
            entities.add(new NormalEnemy(896, 0, "DOWN", 1));
            count = 50;
        }*/
    }

    public final double getWidth() {
        return width;
    }

    public final double getHeight() {
        return height;
    }

    @Nonnull public final ArrayList<AbstractEntity> getEntities() {
        return entities;
    }

    public void addEntity(AbstractEntity entity){entities.add(entity);}
    public void removeEntity(AbstractEntity entity){entities.remove(entity);}


}
