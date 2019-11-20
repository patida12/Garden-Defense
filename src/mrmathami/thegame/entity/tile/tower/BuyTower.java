package mrmathami.thegame.entity.tile.tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import mrmathami.thegame.Config;
import mrmathami.thegame.GameField;
import mrmathami.thegame.GameStage;
import mrmathami.thegame.drawer.LoadImage;
import mrmathami.thegame.drawer.towerDrawer.ChoosingTowerDrawer;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;


public class BuyTower extends AbstractTower {

    @Nonnull
    public static ArrayList<AbstractTower> storeTower = new ArrayList<AbstractTower>();
    ChoosingTowerDrawer drawer = new ChoosingTowerDrawer();

    private boolean buyable = false;
    private boolean isHolding = false;
    private int type;
    private double range;
    private Image image;

    public BuyTower(){
        super(0,0);
    }

    public BuyTower(double posX, double posY, int type) {
        super(posX, posY);
        this.rectangle.setX(posX);
        this.rectangle.setY(posY);
        this.rectangle.setWidth(Config.TILE_SIZE);
        this.rectangle.setHeight(Config.TILE_SIZE);
        this.type = type;
        this.isHolding = false;
        this.buyable = false;
        if (type == 0) {
            this.rangeCircle.setRadius(Config.NORMAL_TOWER_RANGE);
            this.image = LoadImage.normalTower;
        } else if (type == 1) {
            this.rangeCircle.setRadius(Config.MACHINE_GUN_TOWER_RANGE);
            this.image = LoadImage.machineGunTower;
        } else if (type == 2) {
            this.rangeCircle.setRadius(Config.SNIPER_TOWER_RANGE);
            this.image = LoadImage.sniperTower;
        }
    }

    public void chooseTower(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        if(x <= 3 * 32 && y <= 7 * 32 && y >= 0) {
            if ( y >= 1 *32 && y <= 3 *32 && GameField.score >= Config.NORMAL_TOWER_SELL_COST) {
                this.type = 0;
                this.rangeCircle.setRadius(Config.NORMAL_TOWER_RANGE);
                this.image = LoadImage.normalTower;
                storeTower.add(new BuyTower(x, y, 0));
                isHolding = !isHolding;
            }
            else if ( y > 3 * 32 && y <= 5 * 32 && GameField.score >= Config.MACHINE_TOWER_SELL_COST) {
                this.type = 1;
                this.rangeCircle.setRadius(Config.MACHINE_GUN_TOWER_RANGE);
                this.image = LoadImage.machineGunTower;
                storeTower.add(new BuyTower(x, y, 1));
                isHolding = !isHolding;
            }
            else if ( y > 5 * 32 && y <= 7 * 32 && GameField.score >= Config.SNIPER_TOWER_SELL_COST) {
                this.type = 2;
                this.rangeCircle.setRadius(Config.SNIPER_TOWER_RANGE);
                this.image = LoadImage.sniperTower;
                storeTower.add(new BuyTower(x, y, 2));
                isHolding = !isHolding;
            }
        } else if (isHolding && x >= 3 *32 && y <= 18 * 32) {
            HashMap<Integer, Integer> temHashMap = new HashMap<>();
            temHashMap.put((int) x/32, (int) y/32);
            if (GameStage.hashMap.get(temHashMap) == null){
                buyable = true;
                if (this.type == 0) {
                    GameField.score -= Config.NORMAL_TOWER_SELL_COST;
                    GameField.addEntity(new NormalTower(x, y));
                    isHolding = false;
                }
                else if (this.type == 1) {
                    GameField.score -= Config.MACHINE_TOWER_SELL_COST;
                    GameField.addEntity(new MachineGunTower(x, y));
                    isHolding = false;
                } else if (this.type == 2) {
                    GameField.score -= Config.SNIPER_TOWER_SELL_COST;
                    GameField.addEntity(new SniperTower(x, y));
                    isHolding = false;
                }
                GameStage.hashMap.put(temHashMap, true);
            }
            else buyable = false;
        }
    }

    public void holdTower(MouseEvent mouseEvent, GraphicsContext graphicsContext){
        this.setX(mouseEvent.getX());
        this.setY(mouseEvent.getY());
        draw(graphicsContext);
    }

    public void draw(GraphicsContext graphicsContext) {
        if (isHolding) {
            graphicsContext.setGlobalAlpha(0.3);
            graphicsContext.drawImage(image, this.getX(), this.getY());
            drawer.draw(graphicsContext, this.getX(), this.getY(), this.range, this.range, buyable);
            System.out.println("isHolding");
        }else {
            graphicsContext.setGlobalAlpha(1);
            System.out.println("notHolding");
        }

    }

    //don't need
    @Override
    public void updateTower() {

    }
}
