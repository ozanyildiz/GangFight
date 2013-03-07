import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


public class MainClass {
	public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new GameStateController());
        app.setDisplayMode(640, 480, false);
        app.start();
	}
}
