package mrmathami.thegame.entity.tile.tower;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.Config;
import mrmathami.thegame.GameField;
import mrmathami.thegame.drawer.towerDrawer.NormalTowerDrawer;
import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.bullet.NormalBullet;
import mrmathami.thegame.entity.enemy.AbstractEnemy;

public final class NormalTower extends AbstractTower {
    NormalTowerDrawer drawer = new NormalTowerDrawer();
    NormalBullet normalBullet = null;
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


        if (normalBullet != null && normalBullet.isDestroy()){
            if(target != null) {
                target.takeDamage((int)attackDamage);
            }
            GameField.removeEntity(this.normalBullet);
            normalBullet = null;
        }
        if ((target != null) && (normalBullet == null)){
            String direction= target.getDirectionStr();
            switch (direction) {
                case "UP":
                    normalBullet = new NormalBullet(getCenterX(), getCenterY(), target.getCenterX(), target.getCenterY() - Config.NORMAL_BULLET_SPEED);
                    break;
                case "DOWN":
                    normalBullet = new NormalBullet(getCenterX(), getCenterY(), target.getCenterX() , target.getCenterY() + Config.NORMAL_BULLET_SPEED);
                    break;
                case "LEFT":
                    normalBullet = new NormalBullet(getCenterX(), getCenterY(), target.getCenterX() - Config.NORMAL_BULLET_SPEED, target.getCenterY());
                    break;
                case "RIGHT":
                    normalBullet = new NormalBullet(getCenterX(), getCenterY(), target.getCenterX() + Config.NORMAL_BULLET_SPEED, target.getCenterY());
                    break;
                default:
                    break;
            }

            GameField.addEntity(normalBullet);

        }
    }
}