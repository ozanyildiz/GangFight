import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;


public class Projectile extends Entity {
	
	private Vector2f direction;
	private float speed = 0.90f;
	
	public Projectile(GameWorld gameWorld, float x, float y, Vector2f direction) throws SlickException {
		super(gameWorld, x, y);
		this.direction = direction;
		image = new Image("assets/pistol_bullet.png");
	}
	
	@Override
	public boolean update(GameContainer container, int deltaTime) {
		x += Math.cos(Math.toRadians(direction.getTheta())) * speed * deltaTime;
		y += Math.sin(Math.toRadians(direction.getTheta())) * speed * deltaTime;
		
		if (!isOutOfScreen()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void render(GameContainer container, Graphics g) {
		image.draw(x, y);
	}
	
	private boolean isOutOfScreen() {
		if (x < 0 || x > gameWorld.getWidth() || y < 0 || y > gameWorld.getHeight()) 
			return true;
		else
			return false;
	}
}
