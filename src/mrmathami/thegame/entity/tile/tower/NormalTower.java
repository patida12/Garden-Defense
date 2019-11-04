package mrmathami.thegame.entity.tile.tower;

import mrmathami.thegame.Config;

public final class NormalTower extends AbstractTower {
    private long attackDamage;                       // Determines amount of health to reduce from monsters per attack
    private double attackSpeed;                     // Determines the time a tower must wait after an attack
    private double attackRange;                        // Sets the minimum range the tower can make attacks in
    private int upgradeTime;                        // Time in milliseconds it takes to complete an upgrade.
    private int upgradeCost;                        // Determines the resource cost to upgrade the tower
    private int sellCost;                           // Determines the resources gained by selling the tower


    public NormalTower(double x , double y, long attackDamage, double attackSpeed, double attackRange, int upgradeTime, int upgradeCost, int sellCost){
        super(x, y);
        this.attackDamage = Config.NORMAL_BULLET_STRENGTH;
        this.attackSpeed = Config.NORMAL_TOWER_SPEED;
        this.attackRange = Config.NORMAL_TOWER_RANGE;
        this.upgradeTime = Config.NORMAL_TOWER_UPGRADE_TIME;
        this.upgradeCost = Config.NORMAL_TOWER_UPGRADE_COST;
        this.sellCost = Config.NORMAL_TOWER_SELL_COST;
    }

    @Override
    public void updateTower() {
        //example
        attackDamage++;
        attackSpeed = attackSpeed - 0.1;
        attackRange = attackRange + 50;
        upgradeTime += 3000;
        upgradeCost += 20;
    }
}