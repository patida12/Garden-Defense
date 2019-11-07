package mrmathami.thegame.entity.tile.tower;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.Config;
import mrmathami.thegame.drawer.towerDrawer.NormalTowerDrawer;

public final class NormalTower extends AbstractTower {
    NormalTowerDrawer drawer = new NormalTowerDrawer();
    public NormalTower(double x , double y){
        super(x, y, Config.NORMAL_BULLET_STRENGTH, Config.NORMAL_TOWER_SPEED, Config.NORMAL_TOWER_RANGE, Config.NORMAL_TOWER_UPGRADE_TIME, Config.NORMAL_TOWER_UPGRADE_COST, Config.NORMAL_TOWER_SELL_COST);
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