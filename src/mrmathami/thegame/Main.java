package mrmathami.thegame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 * Main class. Entry point of the game.
 */

public final class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		final Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        final GameController gameController = new GameController(graphicsContext);

        // Tao root container
		Group root = new Group();
		root.getChildren().add(canvas);

		// Tao scene
		Scene scene = new Scene(root);

		// Them scene vao stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("Garden Defense");
		primaryStage.setResizable(false);
		primaryStage.show();


	}
}
/*


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		final Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

		final int CIRCLE_CENTER_X = 300 ;
		final int CIRCLE_CENTER_Y = 300 ;

		final Duration MONTH = Duration.seconds(2);
		final Duration YEAR = MONTH.multiply(13);

		Group root = new Group();
		root.getChildren().add(canvas);

		// Tao scene
		Scene scene = new Scene(root);
		Circle sun = new Circle(CIRCLE_CENTER_X, CIRCLE_CENTER_Y, 50, Color.GOLD);
		Circle earth = new Circle(CIRCLE_CENTER_X + 200, CIRCLE_CENTER_Y, 20, Color.CADETBLUE);
		Circle moon = new Circle(CIRCLE_CENTER_X + 240, CIRCLE_CENTER_Y, 5, Color.IVORY);

		Group earthAndMoon = new Group(earth, moon);

		Pane pane = new Pane(sun, earthAndMoon);
		pane.setMinSize(600, 600);

		Rotate earthRotate = new Rotate(0, CIRCLE_CENTER_X, CIRCLE_CENTER_Y);
		earthAndMoon.getTransforms().add(earthRotate);

		Rotate moonRotate = new Rotate(0, CIRCLE_CENTER_X + 200, CIRCLE_CENTER_Y);
		moon.getTransforms().add(moonRotate);

		Timeline earthTimeline = new Timeline(new KeyFrame(YEAR, new KeyValue(earthRotate.angleProperty(), 360)));
		earthTimeline.setCycleCount(Animation.INDEFINITE);
		earthTimeline.play();

		Timeline moonTimeline = new Timeline(new KeyFrame(MONTH, new KeyValue(moonRotate.angleProperty(), 360)));
		moonTimeline.setCycleCount(Animation.INDEFINITE);
		moonTimeline.play();

		primaryStage.setScene( new Scene(pane) );
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}*/