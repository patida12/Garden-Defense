package mrmathami.thegame.drawer.mapDrawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import mrmathami.thegame.GameStage;
import mrmathami.thegame.drawer.LoadImage;
import mrmathami.thegame.drawer.towerDrawer.StoreDrawer;

import java.io.IOException;

public class MapDrawer {

    public static final String[][] MAP_SPRITES = GameStage.Map;
    public static StoreDrawer storeDrawer = new StoreDrawer();

    public MapDrawer() throws IOException {
    }

    private static void drawMap(GraphicsContext gc) {

        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                int index = Integer.parseInt(MAP_SPRITES[i][j]);
                gc.drawImage(LoadImage.map[index], j * 32, i * 32, 32, 32);
                
                //System.out.print(MAP_SPRITES[i][j] + " ");
            }
            //System.out.println();
        }
        storeDrawer.draw(gc);
        gc.setFill(Color.BLUEVIOLET);
        gc.fillText("MENU", 20,20);
    }

    public static void render(GraphicsContext graphicsContext) {
        drawMap(graphicsContext);
    }
}
