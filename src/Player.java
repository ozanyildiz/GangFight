import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Vector2f;


public class Player extends Entity {
	
	private float speed = 0.2f;
	private boolean onGround = true;
	private Vector2f velocity;
	private float gravity = 0.01f;
	private float jumpSpeed = 0.4f;
	
	private Point positionBeforeJump = new Point(0.0f, 0.0f);
	
	Player (GameWorld gameWorld, float x, float y) throws SlickException {
		super(gameWorld, x, y);
		velocity = new Vector2f(0.2f, 0.2f);
		image = new Image("assets/player.png");
	}
		
	@Override
	public boolean update(GameContainer container, int deltaTime) {
		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_W) && onGround && y > gameWorld.getYMovementLimit()) {
			y -= velocity.y * deltaTime;
		} 
		else if (input.isKeyDown(Input.KEY_S) && onGround && y < gameWorld.getHeight() - 32) {
			y += velocity.y * deltaTime;
		}
		
		if (input.isKeyDown(Input.KEY_A)) {
			x -= velocity.x * deltaTime;
		}
		else if (input.isKeyDown(Input.KEY_D)) {
			x += velocity.x * deltaTime;
		}
		
		if (input.isKeyDown(Input.KEY_SPACE) && onGround) {
			velocity.y = -1.2f;
			onGround = false;
			positionBeforeJump.setLocation(x, y);
		}
		
		if (input.isMousePressed(0)) {
			try {
				shootBullet(input.getMouseX(), input.getMouseY());
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (!onGround) {
			velocity.y += gravity;
			y += velocity.y;
			if (y >= positionBeforeJump.getY()) {
				onGround = true;
				velocity.y = 0.2f;
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
		gameWorld.addEntity(bullet);
		Sounds.getInstance().playSound("pistol_shot.wav");
	}
	
}
