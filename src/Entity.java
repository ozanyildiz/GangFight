import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;


public abstract class Entity {
	protected float x;
	protected float y;
	protected Image image;
	protected GameWorld gameWorld;
	protected boolean isRemoved;
	protected Polygon entityPolygon;
	
    public Entity(GameWorld gameWorld, float x, float y, int width, int height) {
		this.gameWorld = gameWorld;
		this.x = x;
		this.y = y;
		
		entityPolygon = new Polygon(new float[] {
				x, y,
				x + width, y,
				x + width, y + height,
				x, y + height
		});
    }

	public abstract boolean update(GameContainer container, int deltaTime);
    
    public abstract void render(GameContainer container, Graphics g);
    
    public void setRemoved() {
    	isRemoved = true;
    }
    
    public boolean isRemoved() {
    	return isRemoved;
    }
    
    public void checkCollisions(List<Entity> entities) {
    	for (Entity e : entities) {
    		if (entityPolygon.intersects(e.entityPolygon)) {
    			onCollide(e);
    		}
    	}
    }
    
    protected void onCollide(Entity e) {
		
	}

	public void updatePolygon() {
    	if (entityPolygon != null)
    		entityPolygon.setLocation(x, y);
    }
    
    public void createPolygon() {
		entityPolygon = new Polygon(new float[] {
				x, y,
				x + image.getWidth(), y,
				x + image.getWidth(), y + image.getHeight(),
				x, y + image.getHeight()
		});
    }
}
