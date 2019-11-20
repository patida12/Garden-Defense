package mrmathami.thegame.entity.bullet;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.Config;
import mrmathami.thegame.drawer.bulletDrawer.NormalBulletDrawer;
import mrmathami.thegame.entity.Path;

public class NormalBullet extends AbstractBullet{
    NormalBulletDrawer drawer = new NormalBulletDrawer();
    public  NormalBullet(double startX, double startY, double endX, double endY){

        super(startX, startY, endX, endY, Config.NORMAL_BULLET_SPEED,Config.NORMAL_BULLET_STRENGTH);

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
