import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;


public class EnemyManager {
	
	private GameWorld gameWorld;
	private Random random;
	
	private float lastSpawnTime;
	private float spawnEveryT = 3000.0f;
	
	public EnemyManager(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		random = new Random();
	}
	
	public void update(GameContainer container, int deltaTime) throws SlickException {
		lastSpawnTime += deltaTime;
		if (lastSpawnTime >= spawnEveryT) {
			spawnEnemies();
			lastSpawnTime = 0;
		}
		
	}
	
	public void spawnEnemies() throws SlickException {
		int numberOfEnemies = random.nextInt(3) + 1;
		for (int i = 0; i < numberOfEnemies; i++) {
			float enemyY = gameWorld.getYMovementLimit() + random.nextInt(gameWorld.getHeight() - gameWorld.getYMovementLimit());
			gameWorld.addEntity(new Enemy(gameWorld, gameWorld.getWidth(), enemyY));
		}
	}
}
