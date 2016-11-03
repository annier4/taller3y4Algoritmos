import processing.core.PApplet;
import processing.core.PVector;

public class Logica {
	private PApplet app;
	private int puntaje;
	private Personaje personaje;
	private SistemaParticula sp;
	private SistemaParticula sp2;

	public Logica(PApplet app) {
		this.app = app;
		this.sp = new SistemaParticula(new PVector( 20, -5), app);
		this.sp2 = new SistemaParticula(new PVector( 1100, -5), app);
	}

	/**
	 * este metodo se encarga de pintar en el lienzo
	 */
	public void pintar() {
		if (app.frameCount % 10 == 0) {
			sp.addParticle();
			sp2.addParticle();
		}

		sp.run();
		sp2.run();
	}
}
