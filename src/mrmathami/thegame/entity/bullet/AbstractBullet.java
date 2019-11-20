package mrmathami.thegame.entity.bullet;

import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.enemy.Target;

public abstract class AbstractBullet extends AbstractEntity {
    double speed;
    int strength;
    Target target;
    double len;
    double alpha;
    protected boolean isdestroy = false;
    protected AbstractBullet(double posX, double posY, double deltaX, double deltaY, double speed, long strength) {
        super( posX, posY, 0.2, 0.2);
        setX(posX);
        setY(posY);
        target = new Target(deltaX, deltaY);
        this.speed = speed;
        System.out.println(speed + "*");
        this.strength = (int)strength;

        len = Math.sqrt((posX - deltaX) * (posX - deltaX) + (posY - deltaY) * (posY - deltaY));
        alpha = 0;
    }

    protected AbstractBullet() {
    }

    public boolean isDestroy(){

        return isdestroy;
    }
    @Override
    public void update() {

        if(target.getX() < this.getX()){
            if(target.getY() < this.getY()){
                /*this.setX(this.getX() - len*Math.cos(alpha));
                this.setY(this.getY() - len*Math.sin(alpha));*/
                this.setX(this.getX() - speed);
                this.setY(this.getY() - speed);
                if (target.getX() > this.getX() || target.getY() > this.getY())
                    isdestroy = true;
            }
            else{
                /*this.setX(this.getX() - len*Math.cos(alpha));
                this.setY(this.getY() + len*Math.sin(alpha));*/
                this.setX(this.getX() - speed);
                this.setY(this.getY() + speed);
                if (target.getX() > this.getX() || target.getY() < this.getY())
                    isdestroy = true;
            }
        }
        else{
            if(target.getY() < this.getY()){
                /*this.setX(this.getX() + len*Math.cos(alpha));
                this.setY(this.getY() - len*Math.sin(alpha));*/
                this.setX(this.getX() + speed);
                this.setY(this.getY() - speed);
                if (target.getX() < this.getX() || target.getY() > this.getY())
                    isdestroy = true;
            }
            else{
                /*this.setX(this.getX() + len*Math.cos(alpha));
                this.setY(this.getY() + len*Math.sin(alpha));*/
                this.setX(this.getX() + speed);
                this.setY(this.getY() + speed);
                if (target.getX() < this.getX() || target.getY() < this.getY())
                    isdestroy = true;
            }
        }




    }
}