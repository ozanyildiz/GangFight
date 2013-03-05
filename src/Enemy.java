import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;


public class Enemy extends Entity {

	private Vector2f velocity;
	
	public Enemy(GameWorld gameWorld, float x, float y) throws SlickException {
		super(gameWorld, x, y, 32, 32);
		velocity = new Vector2f(0.05f, 0.2f);
		image = new Image("assets/enemy01.png");
		image.getFlippedCopy(false, true);
	}
	
	@Override
	public boolean update(GameContainer container, int deltaTime) {
		x -= velocity.x * deltaTime;
		return true;
	}

	@Override
	public void render(GameContainer container, Graphics g) {
		image.draw(x, y);
	}

}
