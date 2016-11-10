import de.voidplus.leapmotion.*;
import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {
	private PApplet app;
	private Logica ap;
	
	@Override
	public void settings() {
		size(1200,700);
	}
	
	@Override
	public void setup() {
		app = this;
		ap = new Logica(app);
	}
	
	@Override
	public void draw() {
		background(255);
		ap.pintar();
	}
	
	public static void main(String[] args) {
		PApplet.main("Main");
	}

}
