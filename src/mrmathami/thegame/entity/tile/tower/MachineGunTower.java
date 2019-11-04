package mrmathami.thegame.entity.tile.tower;

import mrmathami.thegame.Config;

public final class MachineGunTower extends AbstractTower {
    private long attackDamage;                       // Determines amount of health to reduce from monsters per attack
    private double attackSpeed;                     // Determines the time a tower must wait after an attack
    private double attackRange;                        // Sets the minimum range the tower can make attacks in
    private int upgradeTime;                        // Time in milliseconds it takes to complete an upgrade.
    private int upgradeCost;                        // Determines the resource cost to upgrade the tower
    private int sellCost;                           // Determines the resources gained by selling the tower


    public MachineGunTower(double x , double y, long attackDamage, double attackSpeed, double attackRange, int upgradeTime, int upgradeCost, int sellCost){
        super(x, y);
        this.attackDamage = Config.MACHINE_GUN_BULLET_STRENGTH;
        this.attackSpeed = Config.MACHINE_GUN_TOWER_SPEED;
        this.attackRange = Config.MACHINE_GUN_TOWER_RANGE;
        this.upgradeTime = Config.MACHINE_TOWER_UPGRADE_TIME;
        this.upgradeCost = Config.MACHINE_TOWER_UPGRADE_COST;
        this.sellCost = Config.MACHINE_TOWER_SELL_COST;
    }

    @Override
    public void updateTower() {
        //to do
    }
}