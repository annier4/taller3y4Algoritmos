import java.util.ArrayList;

import de.voidplus.leapmotion.Finger;
import de.voidplus.leapmotion.Hand;
import de.voidplus.leapmotion.LeapMotion;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Personaje {
	private PApplet app;									// instancia de PApplet
	private LeapMotion leap;								// instancia de leapMotion
	private ArrayList<ParteCuerpo> extremidades; 			// arreglo de partes del cuerpo del muñeco
	private int centroX; 											// cordenada X inicial para las extremidades
	private int centroY; 											// cordenada Y inicial para las extremidades
	private int sexo; 												// será 1 para definir si es hombre y 2 si es mujer
	private PImage cuerpo;											// imagen del cuerpo del personaje
	
	public Personaje(PApplet app, int sexo){
		this.app = app;
		this.sexo = sexo;
		centroX = app.width/2;
		centroY =app.height/2;
		leap = new LeapMotion(app);
		extremidades = new ArrayList<ParteCuerpo>();
		extremidades.add(new ParteCuerpo(app, centroX, centroY, 0, sexo)); // pierna izquierda
		extremidades.add(new ParteCuerpo(app, centroX, centroY, 1, sexo)); // brazo izquierdo
		extremidades.add(new ParteCuerpo(app, centroX, centroY, 2, sexo)); // cabeza
		extremidades.add(new ParteCuerpo(app, centroX, centroY, 3, sexo)); // brazo derecho
		extremidades.add(new ParteCuerpo(app, centroX, centroY, 4, sexo)); // pierna derecha
		
		// escoger la imagen del cuerpo dependiendo del sexo
		switch (sexo) {
		case 2: //si es 2 es mujer 
			cuerpo = app.loadImage("data/dollGirl/tronco.png");
			break;
		default:
			cuerpo = app.loadImage("data/dollBoy/tronco.png");
			break;
		}
	}
	
	public void pintar(){
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
			    
			    
			    float manoX = handPosition.x;
			    float manoY = handPosition.y+100;
			    app.imageMode(PConstants.CENTER);
			    app.image(cuerpo,manoX, manoY);
			    
			    moverCuerpo(hand, manoX, manoY);
			    //app.fill(255,0,0);
				//app.ellipse(manoX, manoY, 50, 50);
				
			    
			    
			    
				
			    
			    //dedoPulgar.getPosition();
			    //app.fill(255,0,0);
			    //app.ellipse(handPosition.x, handPosition.y+200, 50, 50);
			    
			    
			    //app.strokeWeight((float) 20.0);
				//app.stroke(0, 100);
			    //dragSegment(0, dedoPulgar.getPosition().x+200, dedoPulgar.getPosition().y+200);
				//dragSegment(1, x[0], y[0]);
		}
		

	    
	}
	
	
	public void moverCuerpo(Hand hand, float manoX, float manoY){
		
		   	Finger dedoPulgar = hand.getFinger(0); 		// pierna izquierda
		    Finger dedoIndice = hand.getFinger(1); 		// brazo izquierdo
		    Finger dedoCorazon = hand.getFinger(2); 	// cabeza
		    Finger dedoAnular = hand.getFinger(3); 		// brazo derecho
		    Finger dedoMenique = hand.getFinger(4); 	// pierna derecha
		    int x = 0;
		    int y = 0;
		
	    for (int i = 0; i < extremidades.size(); i++) {
	    	int parteDelCuerpo = extremidades.get(i).getParteCuerpo();
	    	switch(parteDelCuerpo){
	    	
	    	case 0: // pierna izquierda
	    		
	    		if(sexo==2){ // Si el personaje es mujer
	    			x = -50;
	    			y = 70;
	    		}
	    		
	    		extremidades.get(i).setXi(manoX+x);
	    		extremidades.get(i).setYi(manoY+y);
	    		extremidades.get(i).pintar(dedoCorazon.getPosition().x, dedoCorazon.getPosition().y);
	    		break;
	    	case 1: // brazo izquierdo
	    		
	    		if(sexo==2){ // Si el personaje es mujer
	    			x = 50;
	    			y = -70;
	    		}
	    		
	    		extremidades.get(i).setXi(manoX+x);
	    		extremidades.get(i).setYi(manoY+y);
	    		extremidades.get(i).pintar(dedoAnular.getPosition().x, dedoAnular.getPosition().y);
	    		break;
	    		
	    	case 2: // cabeza
	    		
	    		if(sexo==2){ // Si el personaje es mujer
	    			x = 0;
	    			y = -160;
	    		}
	    		
	    		extremidades.get(i).setXi(manoX+x);
	    		extremidades.get(i).setYi(manoY+y);
	    		extremidades.get(i).pintar(dedoIndice.getPosition().x, dedoIndice.getPosition().y);
	    		break;
	    	case 3: // brazo derecho
	    		
	    		if(sexo==2){ // Si el personaje es mujer
	    			x = -50;
	    			y = -70;
	    		}
	    		
	    		extremidades.get(i).setXi(manoX+x);
	    		extremidades.get(i).setYi(manoY+y);
	    		extremidades.get(i).pintar(dedoMenique.getPosition().x, dedoMenique.getPosition().y);
	    		break;
	    	case 4: // pierna derecha
	    		
	    		if(sexo==2){ // Si el personaje es mujer
	    			x = 50;
	    			y = 70;
	    		}
	    		
	    		extremidades.get(i).setXi(manoX+x);
	    		extremidades.get(i).setYi(manoY+y);
	    		extremidades.get(i).pintar(dedoPulgar.getPosition().x, dedoPulgar.getPosition().y);
	    		break;
	    		
	    	}
	    	
		}
	}
	
	
	// ======================================================
		// 1. Callbacks

		void leapOnInit() {
		   app.println("Leap Motion Init");
		}
		void leapOnConnect() {
		   app.println("Leap Motion Connect");
		}
		void leapOnFrame() {
		   app.println("Leap Motion Frame");
		}
		void leapOnDisconnect() {
		   app.println("Leap Motion Disconnect");
		}
		void leapOnExit() {
		   app.println("Leap Motion Exit");
		}
}
