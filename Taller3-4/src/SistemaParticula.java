import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class SistemaParticula {
	PApplet app;
	ArrayList<Particula> particulas;
	  PVector origen;

	  SistemaParticula(PVector posicion, PApplet app) {
		this.app = app;
	    origen = posicion.copy();
	    particulas = new ArrayList<Particula>();
	  }

	  void addParticle() {
		  Particula p=new Particula(origen, app);
	    particulas.add(p);
	    p.start();
	  }

	  void run() {
	    for (int i = particulas.size()-1; i >= 0; i--) {
	    	Particula p = particulas.get(i);
	    	
	      if (p.isDead()) {
	        particulas.remove(i);
	      }else{
	    	  p.display();
	      }
	    }
	  }
		
}
