package mrmathami.thegame.entity.enemy;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.Config;
import mrmathami.thegame.drawer.enemyDrawer.TankerEnemyDrawer;
import mrmathami.thegame.entity.Path;
import mrmathami.thegame.entity.Point;

public class TankerEnemy extends AbstractEnemy {
    //private Direction direction;
    TankerEnemyDrawer drawer = new TankerEnemyDrawer();
    int nodeDirection = 0;


    public TankerEnemy(double posX, double posY, String direction, long numOfSpawn) {
        super(posX, posY,  Config.TANKER_ENEMY_SIZE, numOfSpawn, Config.TANKER_ENEMY_HEALTH, Config.TANKER_ENEMY_ARMOR, Config.TANKER_ENEMY_SPEED, Config.TANKER_ENEMY_REWARD);
        this.direction = setDirection(direction);
    }

    public Point getNextWayPoint() {
        if (nodeDirection < Path.path.length - 1)
            return Path.path[++nodeDirection];
        return null;
    }



    public void calculateDirection() {
        Point currentWP = Path.path[nodeDirection];

        //System.out.println(distance(getX(), getY(), currentWP.getExactX(), currentWP.getExactY()) +" getx= " + getX() + " get y= "+getY() + " currx= " + currentWP.getExactX() + " cuurY= " + currentWP.getExactY());
        if (distance(getX(), getY(), currentWP.getExactX(), currentWP.getExactY()) <= 5) {
            setX(currentWP.getExactX());
            setY(currentWP.getExactY());

            Point nextWayPoint = getNextWayPoint();
            if (nextWayPoint == null) {
                setPathFinished(true);
                super.isDead = true;
                return;
            }

            double deltaX = nextWayPoint.getExactX() - getX();
            double deltaY = nextWayPoint.getExactY() - getY();

            if (deltaX > Config.TANKER_ENEMY_SPEED) setDirection(Direction.RIGHT);
            else if (deltaX < -Config.TANKER_ENEMY_SPEED) setDirection(Direction.LEFT);
            else if (deltaY > Config.TANKER_ENEMY_SPEED) setDirection(Direction.DOWN);
            else if (deltaY <= -Config.TANKER_ENEMY_SPEED) setDirection(Direction.UP);
            //System.out.println(direction);
        }
    }
    //

    @Override
    public void update() {
        {
            calculateDirection();

            switch (getDirection()) {
                case UP:
                    setY(getY() - Config.TANKER_ENEMY_SPEED);
                    break;
                case DOWN:
                    setY(getY() + Config.TANKER_ENEMY_SPEED);
                    break;
                case LEFT:
                    setX(getX() - Config.TANKER_ENEMY_SPEED);
                    break;
                case RIGHT:
                    setX(getX() + Config.TANKER_ENEMY_SPEED);
                    break;
            }
        }
        if (this.isDead() || this.isPathFinished()) {
            onDestroy();
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        drawer.draw(graphicsContext, getX(), getY(), 32, 32);
        Path.drawPath(graphicsContext);
    }

}