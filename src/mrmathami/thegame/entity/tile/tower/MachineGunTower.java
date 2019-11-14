package mrmathami.thegame.entity.tile.tower;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.Config;
import mrmathami.thegame.drawer.towerDrawer.MachineGunTowerDrawer;

public final class MachineGunTower extends AbstractTower {
    MachineGunTowerDrawer drawer = new MachineGunTowerDrawer();
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

    @Override
    public void draw(GraphicsContext graphicsContext) {
        drawer.draw(graphicsContext, getX(), getY(), 32, 32);
        //Path.drawPath(graphicsContext);
    }
}