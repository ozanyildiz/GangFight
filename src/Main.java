import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.AppGameContainer;

public class Main extends BasicGame {

	private GameWorld gameWorld;
	
    public Main() {
        super("GangFight");
        System.out.println("AMK: " + Math.toDegrees(Math.atan2(15, 20)));
    }
    
    @Override
    public void init(GameContainer container) throws SlickException {
    	gameWorld = new GameWorld();
    	gameWorld.init();
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    	gameWorld.update(container, delta);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
    	gameWorld.render(container, g);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Main());
            app.setShowFPS(false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
