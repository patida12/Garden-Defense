package mrmathami.thegame.entity.tile.tower;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.Config;
import mrmathami.thegame.GameField;
import mrmathami.thegame.drawer.towerDrawer.SniperTowerDrawer;
import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.bullet.SniperBullet;
import mrmathami.thegame.entity.enemy.AbstractEnemy;

public final class SniperTower extends AbstractTower {
    SniperTowerDrawer drawer = new SniperTowerDrawer();
    SniperBullet sniperBullet = null;
    AbstractEnemy enemyTarget;
    int timeNewBullet = 0;
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
    @Override
    public void draw(GraphicsContext graphicsContext) {
        drawer.draw(graphicsContext, getX(), getY(), 32, 32);
        //Path.drawPath(graphicsContext);
    }

    public double getDistance(AbstractEntity entity){
        double X = getX() - entity.getX();
        double Y = getY() - entity.getY();

        return Math.sqrt(X*X + Y*Y);
    }
    @Override
    public void update() {
        AbstractEnemy target = null;
        double min_distance = 10000;

        for (AbstractEntity entity : GameField.entities){
            if (entity instanceof AbstractEnemy){
                double distance = getDistance(entity);

                if ((distance < attackRange) && (distance < min_distance)){

                    target = (AbstractEnemy)entity;
                    min_distance = distance;
                }
            }
        }


        if (sniperBullet != null && sniperBullet.isDestroy()){
            if(enemyTarget != null && timeNewBullet == Config.SNIPER_TOWER_SPEED) {
                enemyTarget.takeDamage((int)attackDamage);
            }
            GameField.removeEntity(sniperBullet);
            if (timeNewBullet == 0){
                sniperBullet = null;
                enemyTarget = null;
            }else
                timeNewBullet--;
        }
        if ((target != null) && (sniperBullet == null)){
            String direction= target.getDirectionStr();
            timeNewBullet = (int) Config.SNIPER_TOWER_SPEED;
            enemyTarget = target;
            switch (direction) {
                case "UP":
                    sniperBullet = new SniperBullet(getCenterX(), getCenterY(), target.getCenterX(), target.getCenterY() );
                    break;
                case "DOWN":
                    sniperBullet = new SniperBullet(getCenterX(), getCenterY(), target.getCenterX(), target.getCenterY());
                    break;
                case "LEFT":
                    sniperBullet = new SniperBullet(getCenterX(), getCenterY(), target.getCenterX() , target.getCenterY());
                    break;
                case "RIGHT":
                    sniperBullet = new SniperBullet(getCenterX(), getCenterY(), target.getCenterX() , target.getCenterY());
                    break;
                default:
                    break;
            }


            GameField.addEntity(sniperBullet);

        }
    }

}