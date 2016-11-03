import processing.core.PApplet;
import processing.core.PVector;

public class Particula {
	PApplet app;
	PVector position;
	PVector velocity;
	PVector acceleration;
	float lifespan;

	  public Particula(PVector l, PApplet app) {
		  this.app = app;
		  acceleration = new PVector(0, (float) 0.05);
		  velocity = new PVector((float) app.random(-1, 1), (float) app.random(-2, 0));
		  position = l.copy();
		  lifespan = (float) 255.0;
	  }

	  void run() {
	    update();
	    display();
	  }

	  // Method to update position
	  void update() {
	    velocity.add(acceleration);
	    position.add(velocity);
	    lifespan -= 1.0;
	  }

	  // Method to display
	  void display() {
	    app.stroke(255, lifespan);
	    app.fill(255, lifespan);
	    app.ellipse(position.x, position.y, 8, 8);
	  }

	  // Is the particle still useful?
	  boolean isDead() {
	    if (lifespan < 0.0) {
	      return true;
	    } else {
	      return false;
	    }
	  }

}
