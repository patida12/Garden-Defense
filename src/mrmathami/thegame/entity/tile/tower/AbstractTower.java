package mrmathami.thegame.entity.tile.tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import mrmathami.thegame.Config;
import mrmathami.thegame.drawer.RectangleDrawer;
import mrmathami.thegame.entity.Point;
import mrmathami.thegame.entity.tile.AbstractTile;

public abstract class AbstractTower extends AbstractTile {

    protected Circle rangeCircle = new Circle();
    RectangleDrawer drawer = new RectangleDrawer();
    boolean isClicked = false;
    long attackDamage;
    double attackSpeed;
    double attackRange;
    int upgradeTime;
    int upgradeCost;
    int sellCost;
    Point point;

    public AbstractTower(double x , double y){
        super(x, y);
    }

    public AbstractTower(double x , double y, long attackDamage, double attackSpeed, double attackRange, int upgradeTime, int upgradeCost, int sellCost){
        super(x, y);
        this.rectangle.setX(x);
        this.rectangle.setY(y);
        this.rectangle.setWidth(Config.TILE_SIZE);
        this.rectangle.setHeight(Config.TILE_SIZE);
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.attackRange = attackRange;
        this.upgradeTime = upgradeTime;
        this.upgradeCost = upgradeCost;
        this.sellCost = sellCost;
        this.rangeCircle.setRadius(attackRange);
    }

    public abstract void updateTower();

    @Override
    public void drawRectangle(GraphicsContext graphicsContext, Color color) {
        drawer.draw(graphicsContext, color, this.getX(), this.getY());
    }

    //get+set
}