package mrmathami.thegame.entity.bullet;

import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.tile.Target;

public abstract class AbstractBullet extends AbstractEntity {
    double speed;
    double strength;
    Target target;
    double len;
    double alpha;
    boolean isdestroy = false;
    protected AbstractBullet(double posX, double posY, double deltaX, double deltaY, double speed, long strength) {
        super( posX, posY, 0.2, 0.2);
        setX(posX);
        setY(posY);
        target = new Target(deltaX, deltaY);
        this.speed = speed;
        this.strength = strength;

        len = Math.sqrt((posX - deltaX) * (posX - deltaX) + (posY - deltaY) * (posY - deltaY));
        alpha = 0;
    }

    public boolean isDestroy(){

        return isdestroy;
    }
    @Override
    public void update() {
        //System.out.println(alpha);
        if(target.getX() < this.getX()){
            if(target.getY() < this.getY()){
                /*this.setX(this.getX() - len*Math.cos(alpha));
                this.setY(this.getY() - len*Math.sin(alpha));*/
                this.setX(this.getX() - speed);
                this.setY(this.getY() - speed);
                if (target.getX() > this.getX() || target.getY() > this.getY()) isdestroy = true;
            }
            else{
                /*this.setX(this.getX() - len*Math.cos(alpha));
                this.setY(this.getY() + len*Math.sin(alpha));*/
                this.setX(this.getX() - speed);
                this.setY(this.getY() + speed);
                if (target.getX() > this.getX() || target.getY() < this.getY()) isdestroy = true;
            }
        }
        else{
            if(target.getY() < this.getY()){
                /*this.setX(this.getX() + len*Math.cos(alpha));
                this.setY(this.getY() - len*Math.sin(alpha));*/
                this.setX(this.getX() + speed);
                this.setY(this.getY() - speed);
                if (target.getX() < this.getX() || target.getY() > this.getY()) isdestroy = true;
            }
            else{
                /*this.setX(this.getX() + len*Math.cos(alpha));
                this.setY(this.getY() + len*Math.sin(alpha));*/
                this.setX(this.getX() + speed);
                this.setY(this.getY() + speed);
                if (target.getX() < this.getX() || target.getY() < this.getY()) isdestroy = true;
            }
        }




    }
}