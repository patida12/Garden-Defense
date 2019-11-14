package mrmathami.thegame.entity.enemy;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.Config;
import mrmathami.thegame.GameField;
import mrmathami.thegame.drawer.enemyDrawer.NormalEnemyDrawer;
import mrmathami.thegame.entity.Path;
import mrmathami.thegame.entity.Point;

public class NormalEnemy extends AbstractEnemy {
    //private Direction direction;
    NormalEnemyDrawer drawer = new NormalEnemyDrawer();
    int nodeDirection = 0;



    public NormalEnemy(double posX, double posY, String direction, long numOfSpawn) {
        super(posX, posY,  Config.NORMAL_ENEMY_SIZE, numOfSpawn, Config.NORMAL_ENEMY_HEALTH, Config.NORMAL_ENEMY_ARMOR, Config.NORMAL_ENEMY_SPEED, Config.NORMAL_ENEMY_REWARD);
        this.direction = setDirection(direction);
    }

    public void createEnemy(GameField gameField) {
        while(super.numOfSpawn-- == 0) {
            gameField.addEntity(this);
        }
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

            if (deltaX > Config.NORMAL_ENEMY_SPEED) setDirection(Direction.RIGHT);
            else if (deltaX < -Config.NORMAL_ENEMY_SPEED) setDirection(Direction.LEFT);
            else if (deltaY > Config.NORMAL_ENEMY_SPEED) setDirection(Direction.DOWN);
            else if (deltaY <= -Config.NORMAL_ENEMY_SPEED) setDirection(Direction.UP);
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
                    setY(getY() - Config.NORMAL_ENEMY_SPEED);
                    break;
                case DOWN:
                    setY(getY() + Config.NORMAL_ENEMY_SPEED);
                    break;
                case LEFT:
                    setX(getX() - Config.NORMAL_ENEMY_SPEED);
                    break;
                case RIGHT:
                    setX(getX() + Config.NORMAL_ENEMY_SPEED);
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