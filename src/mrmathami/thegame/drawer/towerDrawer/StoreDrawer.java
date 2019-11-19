package mrmathami.thegame.drawer.towerDrawer;

import javafx.scene.canvas.GraphicsContext;
import mrmathami.thegame.drawer.EntityDrawer;

import javax.annotation.Nonnull;

public class StoreDrawer implements EntityDrawer {
    NormalTowerDrawer normalTowerDrawer = new NormalTowerDrawer();
    MachineGunTowerDrawer machineGunTowerDrawer = new MachineGunTowerDrawer();
    SniperTowerDrawer sniperTowerDrawer = new SniperTowerDrawer();
    @Override
    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {

    }

    public void draw(@Nonnull GraphicsContext graphicsContext){
        normalTowerDrawer.draw(graphicsContext, 64, 48);
        machineGunTowerDrawer.draw(graphicsContext, 64, 112);
        sniperTowerDrawer.draw(graphicsContext, 64, 176, 20, 50);
    }
}
