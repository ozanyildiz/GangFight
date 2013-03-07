import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;


public class Projectile extends Entity {
	
	private Vector2f direction;
	private float speed = 1.5f;
	
	public Projectile(GameWorld gameWorld, float x, float y, Vector2f direction) throws SlickException {
		super(gameWorld, x, y, 5, 5);
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
		g.draw(entityPolygon);
	}
	
	private boolean isOutOfScreen() {
		if (x < 0 || x > gameWorld.getWidth() || y < 0 || y > gameWorld.getHeight()) 
			return true;
		else
			return false;
	}
	
	@Override
	protected void onCollide(Entity entity) {
		if (!isRemoved()) {
			if (entity instanceof Enemy) {
				setRemoved();
				Enemy enemy = (Enemy) entity;
				enemy.setRemoved();
			}
		}
	}
}
