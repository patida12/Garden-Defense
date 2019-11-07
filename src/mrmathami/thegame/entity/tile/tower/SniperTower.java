package mrmathami.thegame.entity.tile.tower;

import mrmathami.thegame.Config;

public final class SniperTower extends AbstractTower {

    public SniperTower(double x , double y){
        super(x, y, Config.SNIPER_BULLET_STRENGTH, Config.SNIPER_TOWER_SPEED, Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_UPGRADE_TIME, Config.SNIPER_TOWER_UPGRADE_COST, Config.SNIPER_TOWER_SELL_COST);
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