package mrmathami.thegame.entity.tile.tower;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.Config;
import mrmathami.thegame.GameField;
import mrmathami.thegame.drawer.towerDrawer.MachineGunTowerDrawer;
import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.bullet.MachineGunBullet;
import mrmathami.thegame.entity.enemy.AbstractEnemy;

public final class MachineGunTower extends AbstractTower {
    MachineGunTowerDrawer drawer = new MachineGunTowerDrawer();
    MachineGunBullet machineGunBullet = null;
    AbstractEnemy enemyTarget;
    int timeNewBullet = 0;
    public MachineGunTower(double x , double y){
        super(x, y, Config.MACHINE_GUN_BULLET_STRENGTH, Config.MACHINE_GUN_TOWER_SPEED, Config.MACHINE_GUN_TOWER_RANGE, Config.MACHINE_TOWER_UPGRADE_TIME, Config.MACHINE_TOWER_UPGRADE_COST, Config.MACHINE_TOWER_SELL_COST);
    }

    enum Direction {
        LEFT(180), UP(270), RIGHT(0), DOWN(90);

        int degree;

        Direction(int i) {
            degree = i;
        }

        int getDegree() {
            return degree;
        }
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

                    target = (AbstractEnemy) entity;
                    min_distance = distance;
                }
            }
        }


        if (machineGunBullet != null && machineGunBullet.isDestroy()){
            if(enemyTarget != null && timeNewBullet == Config.MACHINE_GUN_TOWER_SPEED) {
                enemyTarget.takeDamage((int)attackDamage);
            }
            GameField.removeEntity(machineGunBullet);
            if (timeNewBullet == 0){
                machineGunBullet = null;
                enemyTarget = null;
            }else
                timeNewBullet--;
        }
        if ((target != null) && (machineGunBullet == null)){
            String direction= target.getDirectionStr();
            timeNewBullet = (int) Config.MACHINE_GUN_TOWER_SPEED;
            enemyTarget = target;
            switch (direction){
                case "UP":
                    machineGunBullet = new MachineGunBullet(getCenterX(),getCenterY(),target.getCenterX(), target.getCenterY());
                    break;
                case "DOWN":
                    machineGunBullet = new MachineGunBullet(getCenterX(),getCenterY(),target.getCenterX(), target.getCenterY());
                    break;
                case "LEFT":
                    machineGunBullet = new MachineGunBullet(getCenterX(),getCenterY(),target.getCenterX(), target.getCenterY());
                    break;
                case "RIGHT":
                    machineGunBullet = new MachineGunBullet(getCenterX(),getCenterY(),target.getCenterX(), target.getCenterY());
                    break;
                default:
                    break;
            }
            GameField.addEntity(machineGunBullet);
        }
    }
}