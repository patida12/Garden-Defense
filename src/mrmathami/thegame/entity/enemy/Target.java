package mrmathami.thegame.entity.enemy;

public class Target extends AbstractEnemy{

    public Target(double posX, double posY, double size, long numOfSpawn, long health, long armor, double speed, long reward) {
        super(posX, posY, size, numOfSpawn, health, armor, speed, reward);
    }

    public Target(double posX, double posY){
        super(posX, posY);
    }

    @Override
    public void update() {

    }
}
