import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameWorld {
	private Player player;
	private Image backgroundImage;
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Entity> newEntities = new ArrayList<Entity>();
	
	EnemyManager enemyManager;
	
	private int width;
	private int height;
	
	private int yMovementLimit = 265;
	
	public void init() throws SlickException {
    	player = new Player(this, 50, 400);
    	backgroundImage = new Image("assets/background.png");
    	addEntity(player);
    	
    	width = backgroundImage.getWidth();
    	height = backgroundImage.getHeight();
    	
    	enemyManager = new EnemyManager(this);
	}
	
    public void update(GameContainer container, int deltaTime) throws SlickException {
    	Iterator<Entity> entityIterator = entities.iterator();
    	while (entityIterator.hasNext()) {
    		Entity entity = entityIterator.next();    		
    		if (!entity.update(container, deltaTime) || entity.isRemoved()) {
    			entity.setRemoved();
    			entityIterator.remove();
    		}
    	}
    	entities.addAll(newEntities);
    	newEntities.clear();
    	
    	enemyManager.update(container, deltaTime);
    }
    
    public void render(GameContainer container, Graphics g) {
    	backgroundImage.draw();
    	Iterator<Entity> entityIterator = entities.iterator();
    	while (entityIterator.hasNext()) {
    		Entity entity = entityIterator.next();
    		entity.render(container, g);
    	}
    }
    
    public void addEntity(Entity e) {
    	newEntities.add(e);
    }
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
    
    public int getYMovementLimit() {
    	return yMovementLimit;
    }
}
