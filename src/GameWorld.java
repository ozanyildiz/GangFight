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
	
	public void init() throws SlickException {
    	player = new Player(this, 100, 100);
    	player.init();
    	backgroundImage = new Image("assets/background.png");
    	addEntity(player);
	}
	
    public void update(GameContainer container, int deltaTime) {
    	Iterator<Entity> entityIterator = entities.iterator();
    	while (entityIterator.hasNext()) {
    		Entity entity = entityIterator.next();    		
    		if (!entity.update(container, deltaTime)) {
    			entityIterator.remove();
    			System.out.println("LOL");
    		}
    	}
    	entities.addAll(newEntities);
    	newEntities.clear();
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
}
