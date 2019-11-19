package mrmathami.thegame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
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
		final Group root = new Group();
		final GameController gameController = new GameController(primaryStage, canvas, root);

	}

}
