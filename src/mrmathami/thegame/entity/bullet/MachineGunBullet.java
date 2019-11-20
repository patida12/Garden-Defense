package mrmathami.thegame.entity.bullet;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.Config;
import mrmathami.thegame.drawer.bulletDrawer.MachineGunBulletDrawer;
import mrmathami.thegame.entity.Path;

public class MachineGunBullet extends AbstractBullet{
    MachineGunBulletDrawer drawer = new MachineGunBulletDrawer();

    public MachineGunBullet(){}

    public  MachineGunBullet(double startX, double startY, double endX, double endY){
        super(startX, startY, endX, endY, Config.MACHINE_GUN_BULLET_SPEED,Config.MACHINE_GUN_BULLET_STRENGTH);
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
