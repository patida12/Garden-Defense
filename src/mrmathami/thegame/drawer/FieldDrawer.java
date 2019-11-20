package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import mrmathami.thegame.GameController;
import mrmathami.thegame.GameField;

import javax.annotation.Nonnull;

public class FieldDrawer implements EntityDrawer {
    @Override
    public void draw(@Nonnull GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
    }

    public void draw(@Nonnull GraphicsContext graphicsContext) {
        graphicsContext.setFont(Font.loadFont("file:src/assets/text/Diavlo_BOLD_II_37.otf", 20));
        graphicsContext.drawImage(LoadImage.display, 7 * 32, 17 * 32);
        if (GameController.isReady) graphicsContext.setFill(Color.RED);
        else graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillText("Ready", 29 * 32 - 32, 19 * 32, 3 * 32);

        graphicsContext.setFill(Color.DARKGOLDENROD);
        graphicsContext.fillText("Cash: " + String.valueOf(GameField.cash) + " $", 3 * 32, 18 * 32 - 6);
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillText("Live: " + String.valueOf(GameField.countEnemies()) , 3 * 32, 19 * 32 - 6);
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillText("Health: " + String.valueOf(GameField.health) , 3 * 32, 20 * 32 - 6);
    }
}
