package mrmathami.thegame.entity.tile.tower;

import mrmathami.thegame.Config;

public final class MachineGunTower extends AbstractTower {

    public MachineGunTower(double x , double y){
        super(x, y, Config.MACHINE_GUN_BULLET_STRENGTH, Config.MACHINE_GUN_TOWER_SPEED, Config.MACHINE_GUN_TOWER_RANGE, Config.MACHINE_TOWER_UPGRADE_TIME, Config.MACHINE_TOWER_UPGRADE_COST, Config.MACHINE_TOWER_SELL_COST);
    }

    @Override
    public void updateTower() {
        //example
        super.attackDamage++;
        attackSpeed = attackSpeed - 0.1;
        attackRange = attackRange + 50;
        upgradeTime += 3000;
        upgradeCost += 20;
    }
}