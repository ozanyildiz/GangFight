import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


public abstract class Entity {
	protected float x;
	protected float y;
	protected Image image;
	protected GameWorld gameWorld;
	
    public Entity(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

	public abstract boolean update(GameContainer container, int deltaTime) ;
    
    public abstract void render(GameContainer container, Graphics g);
}
