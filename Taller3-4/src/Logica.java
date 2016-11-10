import processing.core.PApplet;
import processing.core.PVector;

public class Logica {
	private PApplet app;
	private int puntaje;
	//private SistemaParticula sp;
	private Personaje personaje;
	
	
	public Logica(PApplet app) {
		this.app = app;
		personaje = new Personaje(app, 2);
		//this.sp = new SistemaParticula(new PVector(app.width/2, 50), app);
	}
	
	public void pintar() {
		//sp.addParticle();
		//sp.run();
		personaje.pintar();
	}
}
