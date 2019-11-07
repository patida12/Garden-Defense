package mrmathami.thegame.entity.tile.tower;

import mrmathami.thegame.entity.Point;
import mrmathami.thegame.entity.tile.AbstractTile;

public abstract class AbstractTower extends AbstractTile {
    long attackDamage;                       // Determines amount of health to reduce from monsters per attack
    double attackSpeed;                     // Determines the time a tower must wait after an attack
     double attackRange;                        // Sets the minimum range the tower can make attacks in
     int upgradeTime;                        // Time in milliseconds it takes to complete an upgrade.
     int upgradeCost;                        // Determines the resource cost to upgrade the tower
     int sellCost;
     Point point;                            // Represents the coordinates of the tower on the map

    public AbstractTower(double x, double y) {
        super(x, y);
        this.point = new Point(x, y);
    }

    public AbstractTower(double x , double y, long attackDamage, double attackSpeed, double attackRange, int upgradeTime, int upgradeCost, int sellCost){
        super(x, y);
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.attackRange = attackRange;
        this.upgradeTime = upgradeTime;
        this.upgradeCost = upgradeCost;
        this.sellCost = sellCost;
    }
    
    public abstract void updateTower();

    //get+set
}