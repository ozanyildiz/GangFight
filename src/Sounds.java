import java.util.HashMap;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


public class Sounds {
	
	private static final String FOLDER = "assets/sounds/";
	public static String PISTOL_SHOT = "pistol_shot.wav";
	private HashMap<String, Sound> sounds = new HashMap<String, Sound>();
	
	private static Sounds instance;
	
    public static Sounds getInstance() {
        if (instance == null) {
            instance = new Sounds();
        }
        return instance;
    }
    
    public void playSound(String name) {
    	Sound sound = sounds.get(name);
        if (sound == null) {
            try {
                sound = new Sound(FOLDER + name);
            } catch (SlickException e) {
                System.err.println("Error, unable to load sound \"" + name + "\"");
                return;
            }
            sounds.put(name, sound);
        }
        sound.play();
    }
}
