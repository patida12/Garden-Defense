package mrmathami.thegame;

public final class Config {
	/**
	 * Game name. Change it if you want.
	 */
	public static final String GAME_NAME = "Garden Defense";
	/**
	 * Ticks per second
	 */
	public static final long GAME_TPS = 20;
	/**
	 * Nanoseconds per tick
	 */
	public static final long GAME_NSPT = Math.round(1000000000.0 / GAME_TPS);

	/**
	 * Size of the tile, in pixel.
	 * 1.0 field unit == TILE_SIZE pixel on the screen.
	 * Change it base on your texture size.
	 */
	public static final long TILE_SIZE = 32;
	/**
	 * Num of tiles the screen can display if fieldZoom is TILE_SIZE,
	 * in other words, the texture will be display as it without scaling.
	 */
	public static final int TILE_HORIZONTAL = 30;
	/**
	 * Num of tiles the screen can display if fieldZoom is TILE_SIZE,
	 * in other words, the texture will be display as it without scaling.
	 */
	public static final int TILE_VERTICAL = 20;
	/**
	 * An arbitrary number just to make some code run a little faster.
	 * Do not touch.
	 */
	public static final int _TILE_MAP_COUNT = (int) (TILE_HORIZONTAL * TILE_VERTICAL);

	/**
	 * Size of the screen.
	 */
	public static final long SCREEN_WIDTH = TILE_SIZE * TILE_HORIZONTAL;//960
	/**
	 * Size of the screen.
	 */
	public static final long SCREEN_HEIGHT = TILE_SIZE * TILE_VERTICAL;//640


	/**
	 * Game state flags
	 */
	public static final int IS_RUNNING = 1;    //game is active
	public static final int IS_PAUSED = 2;     //game is temporarily not active
	public static final int IS_STOPPED = 3;    //game is over and halted

	/**
	 * Game Speed
	 */
	public static final int GAME_SPEED = 1;
	public static final int WAITING_TIME = 5 / GAME_SPEED;

	//Other config related to other entities in the game.

	enum Direction {
		LEFT(180), UP(270), RIGHT(0), DOWN(90);

		int degree;

		Direction(int i) {
			degree = i;
		}

		int getDegree() {
			return degree;
		}
	}

	//region Bullet
	public static final long NORMAL_BULLET_TTL = 30;
	public static final long NORMAL_BULLET_STRENGTH = 30;
	public static final double NORMAL_BULLET_SPEED = 0.3 * GAME_SPEED;

	public static final long MACHINE_GUN_BULLET_TTL = 15;
	public static final long MACHINE_GUN_BULLET_STRENGTH = 20;
	public static final double MACHINE_GUN_BULLET_SPEED = 0.4 * GAME_SPEED;

	public static final long SNIPER_BULLET_TTL = 60;
	public static final long SNIPER_BULLET_STRENGTH = 120;
	public static final double SNIPER_BULLET_SPEED = 0.5 * GAME_SPEED;
	//endregion

	//region Tower
	public static final long NORMAL_TOWER_SPEED = 30 * GAME_SPEED;
	public static final double NORMAL_TOWER_RANGE = 5.0;
	public static final int NORMAL_TOWER_UPGRADE_TIME = 5000 * GAME_SPEED;
	public static final int NORMAL_TOWER_UPGRADE_COST = 2;
	public static final int NORMAL_TOWER_SELL_COST = 1;

	public static final long MACHINE_GUN_TOWER_SPEED = 5 * GAME_SPEED;
	public static final double MACHINE_GUN_TOWER_RANGE = 4.0;
	public static final int MACHINE_TOWER_UPGRADE_TIME = 7000 * GAME_SPEED;
	public static final int MACHINE_TOWER_UPGRADE_COST = 5;
	public static final int MACHINE_TOWER_SELL_COST = 3;

	public static final long SNIPER_TOWER_SPEED = 60 * GAME_SPEED;
	public static final double SNIPER_TOWER_RANGE = 8.0;
	public static final int SNIPER_TOWER_UPGRADE_TIME = 10000 * GAME_SPEED;
	public static final int SNIPER_TOWER_UPGRADE_COST = 10;
	public static final int SNIPER_TOWER_SELL_COST = 6;
	//endregion

	//region Enemy
	public static final int ENEMY_DURATION_SPAWN = 10 * GAME_SPEED;

	public static final double NORMAL_ENEMY_SIZE = 0.9;
	public static final long NORMAL_ENEMY_HEALTH = 100;
	public static final long NORMAL_ENEMY_ARMOR = 2;
	public static final double NORMAL_ENEMY_SPEED = 1.5 * GAME_SPEED;
	public static final long NORMAL_ENEMY_REWARD = 1;

	public static final double SMALLER_ENEMY_SIZE = 0.7;
	public static final long SMALLER_ENEMY_HEALTH = 50;
	public static final long SMALLER_ENEMY_ARMOR = 0;
	public static final double SMALLER_ENEMY_SPEED = 1.8 * GAME_SPEED;
	public static final long SMALLER_ENEMY_REWARD = 2;

	public static final double TANKER_ENEMY_SIZE = 1.1;
	public static final long TANKER_ENEMY_HEALTH = 300;
	public static final long TANKER_ENEMY_ARMOR = 5;
	public static final double TANKER_ENEMY_SPEED = 0.7 * GAME_SPEED;
	public static final long TANKER_ENEMY_REWARD = 3;

	public static final double BOSS_ENEMY_SIZE = 1.3;
	public static final long BOSS_ENEMY_HEALTH = 500;
	public static final long BOSS_ENEMY_ARMOR = 8;
	public static final double BOSS_ENEMY_SPEED = 0.4 * GAME_SPEED;
	public static final long BOSS_ENEMY_REWARD = 10;

	//endregion

	//source of image
	public static final String ROAD_SRC = "assets\\images\\bomb1.png";

	private Config() {
	}


}
