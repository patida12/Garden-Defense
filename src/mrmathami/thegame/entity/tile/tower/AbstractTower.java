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
    long attackDamage;                       // Determines amount of health to reduce from monsters per attack
    double attackSpeed;                     // Determines the time a tower must wait after an attack
    double attackRange;                        // Sets the minimum range the tower can make attacks in
    int upgradeTime;                        // Time in milliseconds it takes to complete an upgrade.
    int upgradeCost;                        // Determines the resource cost to upgrade the tower
    int sellCost;
    Point point;                            // Represents the coordinates of the tower on the map

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