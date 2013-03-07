import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class MenuState extends BasicGameState {

	public static final int ID = 1;
	private Image menuImage;
	private Image startButtonImage;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		menuImage = new Image("assets/menu/background.png");
		startButtonImage = new Image("assets/menu/start_button.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(menuImage, 0, 0);
		Rectangle buttonRect = getStartButtonRect(container);
		startButtonImage.draw(buttonRect.getX(), buttonRect.getY());
		g.setColor(Color.blue);
		//g.drawRect(buttonRect.getX(), buttonRect.getY(), buttonRect.getWidth(), buttonRect.getHeight());
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int arg2) throws SlickException {
		Input input = container.getInput();
		if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			Rectangle buttonRect = getStartButtonRect(container);
			if (buttonRect.contains(input.getMouseX(), input.getMouseY())) {
				sbg.enterState(NGameState.ID);
			}
		}
	}

	@Override
	public int getID() {
		return ID;
	}
	
	private Rectangle getStartButtonRect(GameContainer container) {
		int buttonWidth = 200;
		int buttonHeight = 60;
		return new Rectangle(container.getWidth() / 2 - buttonWidth / 2, container.getHeight() / 2 - buttonHeight / 2, buttonWidth, buttonHeight);
	}

}
