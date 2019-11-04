package mrmathami.thegame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import mrmathami.thegame.drawer.GameDrawer;

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
		final GameDrawer gd = new GameDrawer();

		gd.render(graphicsContext);
		

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

		/*AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long l) {
				gd.render(graphicsContext);

			}
		};
		timer.start();
*/
	}


}