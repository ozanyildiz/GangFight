import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class NGameState extends BasicGameState {

	private GameWorld gameWorld;
	public static int ID = 2;
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
    	gameWorld = new GameWorld();
    	gameWorld.init();
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		gameWorld.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int deltaTime) throws SlickException {
		gameWorld.update(container, deltaTime);
	}

	@Override
	public int getID() {
		return ID;
	}
	
//    public Main() {
//        super("GangFight");
//    }
    
//    @Override
//    public void init(GameContainer container) throws SlickException {
//    	gameWorld = new GameWorld();
//    	gameWorld.init();
//    }
//
//    @Override
//    public void update(GameContainer container, int delta) throws SlickException {
//    	gameWorld.update(container, delta);
//    }
//
//    @Override
//    public void render(GameContainer container, Graphics g) throws SlickException {
//    	gameWorld.render(container, g);
//    }

//    public static void main(String[] args) {
//        try {
//            AppGameContainer app = new AppGameContainer(new Main());
//            app.setShowFPS(false);
//            app.start();
//        } catch (SlickException e) {
//            e.printStackTrace();
//        }
//    }
}
