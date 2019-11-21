package mrmathami.thegame.entity.enemy;

import mrmathami.thegame.GameController;
import mrmathami.thegame.GameField;
import mrmathami.thegame.GameStage;

import java.util.ArrayList;

public class Wave {
    private float timeSinceLastSpawn, spawnTime;
    private int index;
    ArrayList<ArrayList<AbstractEnemy>> waves = GameStage.waves;

    public Wave(){}

    public Wave(float spawnTime){
        this.spawnTime = spawnTime;
        timeSinceLastSpawn = 0;
        index = 0;
    }

    public void update(){
        //System.out.println("update");
        timeSinceLastSpawn += 0.1;

        if (timeSinceLastSpawn > spawnTime) {
            //System.out.println("spawn");
            Spawn();
            timeSinceLastSpawn = 0;
        }
    }

    public void Spawn(){
        System.out.println(GameField.curWave);
        System.out.println(waves.size());
        if (GameField.curWave <= waves.size()) {
            if (GameField.curWave <= 0) GameField.curWave = 1;

            if (index < waves.get(GameField.curWave - 1).size()){
                GameField.addEntity(waves.get(GameField.curWave - 1).get(index++));
            } else if (GameField.live == 0) {
                GameController.isReady = false;
                index = 0;
            }
        }
    }
}
