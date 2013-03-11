import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class CreditState extends BasicGameState {

	public static final int ID = 3;
	
	private Image creditBackground;
	private Image backButtonImage;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		creditBackground = new Image("assets/credit/credit_background.png");
		backButtonImage = new Image("assets/credit/back_button.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		creditBackground.draw();
		Rectangle backButtonRect = getBackButtonRect(container);
		backButtonImage.draw(backButtonRect.getX(), backButtonRect.getY());
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int arg2) throws SlickException {
		Input input = container.getInput();
		if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			Rectangle buttonRect = getBackButtonRect(container);
			if (buttonRect.contains(input.getMouseX(), input.getMouseY())) {
				sbg.enterState(MenuState.ID);
			}
		}
	}

	@Override
	public int getID() {
		return ID;
	}
	
	int backButtonWidth = 160;
	int backButtonHeight = 80;
	
	private Rectangle getBackButtonRect(GameContainer container) {
		return new Rectangle(container.getWidth() / 2 - backButtonWidth / 2, container.getHeight() - backButtonHeight, backButtonWidth, backButtonHeight);
	}

}
