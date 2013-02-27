import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;


public class Projectile extends Entity {
	
	private double angleInDegrees;
	private Vector2f direction;
	private float speed = 0.05f;
	
	public Projectile(GameWorld gameWorld, float x, float y, Vector2f direction) {
		super(gameWorld);
		this.x = x;
		this.y = y;
//		this.angleInDegrees = angleInDegrees;
		this.direction = direction;
	}
	
	public void init() throws SlickException {
		image = new Image("assets/pistol_bullet.png");
	}

	@Override
	public boolean update(GameContainer container, int deltaTime) {
		x += Math.cos(Math.toRadians(direction.getTheta())) * speed * deltaTime;
		y += Math.sin(Math.toRadians(direction.getTheta())) * speed * deltaTime;
		return true;
	}

	@Override
	public void render(GameContainer container, Graphics g) {
		image.draw(x, y);
	}
	
}
