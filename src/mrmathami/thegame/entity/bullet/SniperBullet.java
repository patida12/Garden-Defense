package mrmathami.thegame.entity.bullet;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.Config;
import mrmathami.thegame.drawer.bulletDrawer.SniperBulletDrawer;
import mrmathami.thegame.entity.Path;

public class SniperBullet extends AbstractBullet{
    SniperBulletDrawer drawer = new SniperBulletDrawer();
    public  SniperBullet(double startX, double startY, double endX, double endY){
        super(startX, startY, endX, endY, Config.SNIPER_BULLET_SPEED,Config.SNIPER_BULLET_STRENGTH);
    }
    public void draw(GraphicsContext graphicsContext){

        drawer.draw(graphicsContext, getX(), getY(), 10,10);
        Path.drawPath(graphicsContext);
    }


    @Override
    public void update() {
        super.update();
    }
}