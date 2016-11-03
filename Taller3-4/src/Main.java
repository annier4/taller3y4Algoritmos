import de.voidplus.leapmotion.*;
import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {
	PApplet app;
	Logica ap;
	LeapMotion leap;
	
	@Override
	public void settings() {
		size(1200,500);
	}
	
	@Override
	public void setup() {
		app = this;
		ap = new Logica(app);
		leap = new LeapMotion(this);
	}
	
	@Override
	public void draw() {
		background(255,0,0);
		ap.pintar();
		
		int fps = leap.getFrameRate();
		  for (Hand hand : leap.getHands ()) {
			  
			  // ==================================================
			    // 2. Hand

			    int     handId             = hand.getId();
			    PVector handPosition       = hand.getPosition();
			    PVector handStabilized     = hand.getStabilizedPosition();
			    PVector handDirection      = hand.getDirection();
			    PVector handDynamics       = hand.getDynamics();
			    float   handRoll           = hand.getRoll();
			    float   handPitch          = hand.getPitch();
			    float   handYaw            = hand.getYaw();
			    boolean handIsLeft         = hand.isLeft();
			    boolean handIsRight        = hand.isRight();
			    float   handGrab           = hand.getGrabStrength();
			    float   handPinch          = hand.getPinchStrength();
			    float   handTime           = hand.getTimeVisible();
			    PVector spherePosition     = hand.getSpherePosition();
			    float   sphereRadius       = hand.getSphereRadius();

			    // --------------------------------------------------
			    // Drawing
			    hand.draw();
			    Finger dedo = hand.getFinger(0);
			    dedo.getPosition();
			    fill(255,0,0);
			   ellipse(handPosition.x, handPosition.y+200, 50, 50);
			   fill(0,0,255);
			    ellipse(dedo.getPosition().x, dedo.getPosition().y+200, 50, 50);
			  
		  }
	}
	
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	
	// ======================================================
	// 1. Callbacks

	void leapOnInit() {
	   println("Leap Motion Init");
	}
	void leapOnConnect() {
	   println("Leap Motion Connect");
	}
	void leapOnFrame() {
	   println("Leap Motion Frame");
	}
	void leapOnDisconnect() {
	   println("Leap Motion Disconnect");
	}
	void leapOnExit() {
	   println("Leap Motion Exit");
	}
}
