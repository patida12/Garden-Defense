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
        graphicsContext.setFont(new Font("assets/text/zorque.ttf", 20));
        graphicsContext.drawImage(LoadImage.display, 7 * 32, 17 * 32);
        if (GameController.isReady) graphicsContext.setStroke(Color.RED);
        else graphicsContext.setStroke(Color.BLACK);
        graphicsContext.strokeText("Ready", 29 * 32 - 16, 19 * 32, 3 * 32);
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillText("Cash: " + String.valueOf(GameField.score) + " $", 3 * 32, 18 * 32 - 6);
        graphicsContext.fillText("Live: " + String.valueOf(GameField.countEnemies()) , 3 * 32, 19 * 32 - 6);
        graphicsContext.fillText("Health: " + String.valueOf(GameField.health) , 3 * 32, 20 * 32 - 6);
    }
}
