import processing.core.PApplet;
import processing.core.PVector;

public class Logica {
	private PApplet app;
	private int puntaje;
	private Personaje personaje;
	private SistemaParticula sp;
	
	
	public Logica(PApplet app) {
		this.app = app;
		this.sp = new SistemaParticula(new PVector(app.width/2, 50), app);
	}
	
	/**
	 * este metodo se encarga de pintar en el lienzo
	 */
	public void pintar() {
		
		sp.addParticle();
		sp.run();
	}
}
