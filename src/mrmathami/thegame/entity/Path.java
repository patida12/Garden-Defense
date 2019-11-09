package mrmathami.thegame.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Path {
    public static final Point[] path = new Point[] {

            new Point(28 * 32, 3 * 32),
            new Point(4 * 32, 3 * 32),
            new Point(4 * 32, 6 * 32),
            new Point(29 * 32, 6 * 32),
            new Point(29 * 32, 9 * 32),
            new Point(3 * 32, 9 * 32),
            new Point(3 * 32, 12 * 32),
            new Point(28 * 32, 12 * 32),
            new Point(28 * 32, 18 * 32),
    };

    public static void drawPath(GraphicsContext graphicsContext) {
        for(Point point : path) {
            graphicsContext.setFill(Color.RED);
            graphicsContext.fillOval(point.getTileX(), point.getTileY(),10, 10);
        }
    }



}
