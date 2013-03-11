import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;


public class GameStateController extends StateBasedGame{

	public GameStateController() {
		super("GangFight");
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new MenuState());
		addState(new NGameState());
		addState(new CreditState());
	}
	
}
