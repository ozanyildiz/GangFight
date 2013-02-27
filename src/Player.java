import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;


public class Player extends Entity {
	
	private float speed = 0.2f;

	Player (GameWorld gameWorld, float x, float y) {
		super(gameWorld);
		this.x = x;
		this.y = y;
	}
	
	public void init() throws SlickException {
		image = new Image("assets/player.png");
	}
	
	@Override
	public boolean update(GameContainer container, int deltaTime) {
		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_W)) {
			y -= speed * deltaTime;
		} 
		else if (input.isKeyDown(Input.KEY_S)) {
			y += speed * deltaTime;
		}
		
		if (input.isKeyDown(Input.KEY_A)) {
			x -= speed * deltaTime;
		}
		else if (input.isKeyDown(Input.KEY_D)) {
			x += speed * deltaTime;
		}
		
		if (input.isMousePressed(0)) {
			try {
				shootBullet(input.getMouseX(), input.getMouseY());
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public void render(GameContainer container, Graphics g) {
		image.draw(x, y);
		
	}
		
	private void shootBullet(float mouseX, float mouseY) throws SlickException {
		//double angleInDegrees = Math.toDegrees(Math.atan2(mouseY - y, mouseX - x));
		//System.out.println("Angle: " + angleInDegrees);
		Vector2f direction = new Vector2f (mouseX - x, mouseY - y);
		Projectile bullet = new Projectile(gameWorld, x, y, direction);
		bullet.init();
		gameWorld.addEntity(bullet);
	}
}
