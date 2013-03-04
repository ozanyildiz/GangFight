import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


public abstract class Entity {
	protected float x;
	protected float y;
	protected Image image;
	protected GameWorld gameWorld;
	protected boolean isRemoved;
	
    public Entity(GameWorld gameWorld, float x, float y) {
		this.gameWorld = gameWorld;
		this.x = x;
		this.y = y;
	}

	public abstract boolean update(GameContainer container, int deltaTime) ;
    
    public abstract void render(GameContainer container, Graphics g);
    
    public void setRemoved() {
    	isRemoved = true;
    }
    
    public boolean isRemoved() {
    	return isRemoved;
    }
}
