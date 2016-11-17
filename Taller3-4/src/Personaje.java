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
	private String texto;
	
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
			cuerpo = app.loadImage("Taller3-4/data/dollGirl/tronco.png");
			break;
		default:
			cuerpo = app.loadImage("Taller3-4/data/dollBoy/tronco.png");
			break;
		}
	}
	
	public void pintar(){
		
//		app.image(cuerpo, centroX-cuerpo.width/2, centroY-cuerpo.height/2);
//		for(int i=0;i<extremidades.size();i++){
//			extremidades.get(i).pintar(0, 0);
//		}
		
		for (Hand hand : leap.getHands ()){
		
			  // ==================================================
			// 2. Hand
//			int     handId             = hand.getId();
			PVector handPosition       = hand.getPosition();
//			PVector handStabilized     = hand.getStabilizedPosition();
//			PVector handDirection      = hand.getDirection();
//			PVector handDynamics       = hand.getDynamics();
//			float   handRoll           = hand.getRoll();
//			float   handPitch          = hand.getPitch();
//			float   handYaw            = hand.getYaw();
//			boolean handIsLeft         = hand.isLeft();
//			boolean handIsRight        = hand.isRight();
//			float   handGrab           = hand.getGrabStrength();
//			float   handPinch          = hand.getPinchStrength();
//			float   handTime           = hand.getTimeVisible();
//			PVector spherePosition     = hand.getSpherePosition();
//			float   sphereRadius       = hand.getSphereRadius();
			
			// --------------------------------------------------
			// Drawing
//			    hand.draw();
			    
			    
			    float manoX = handPosition.x;
			    float manoY = handPosition.y+100;
			    app.imageMode(PConstants.CENTER);
			    app.image(cuerpo,manoX, manoY);
			    Finger dedoPulgar = hand.getFinger(0); 		// pierna izquierda
			    Finger dedoIndice = hand.getFinger(1); 		// brazo izquierdo
			    Finger dedoCorazon = hand.getFinger(2); 	// cabeza
			    Finger dedoAnular = hand.getFinger(3); 		// brazo derecho
			    Finger dedoMenique = hand.getFinger(4); 	// pierna derecha
			   
			    
                    extremidades.get(0).setAngulo(app.radians(dedoPulgar.getPosition().x-manoX)*-8);	
					extremidades.get(0).pintar(manoX, manoY);
					extremidades.get(1).setAngulo(app.radians(dedoIndice.getPosition().x-manoX)*-5);	
					extremidades.get(1).pintar(manoX, manoY);
					extremidades.get(2).setAngulo(app.radians(dedoCorazon.getPosition().x-manoX)*8);	
					extremidades.get(2).pintar(manoX, manoY);
					extremidades.get(3).setAngulo(app.radians((dedoAnular.getPosition().x-manoX)*5)*-1);	
					extremidades.get(3).pintar(manoX, manoY);
					extremidades.get(4).setAngulo(app.radians((dedoMenique.getPosition().x-manoX)*8)*-1);	
					extremidades.get(4).pintar(manoX, manoY);
			    
			   float dif1x = dedoPulgar.getPosition().x-manoX;
			   float dif1y = dedoPulgar.getPosition().y-manoY;
			   float dif2x = dedoIndice.getPosition().x-manoX;
			   float dif2y = dedoIndice.getPosition().y-manoY;
			   float dif3x = dedoCorazon.getPosition().x-manoX;
			   float dif3y = dedoCorazon.getPosition().y-manoY;
			   float dif4x = dedoAnular.getPosition().x-manoX;
			   float dif4y = dedoAnular.getPosition().y-manoY;
			   float dif5x = dedoMenique.getPosition().x-manoX;
			   float dif5y = dedoMenique.getPosition().y-manoY; 
				
			    
			    
			    
				
			    
//			    dedoPulgar.getPosition();
//			    app.fill(255,0,0);
//			    app.ellipse(handPosition.x, handPosition.y+200, 50, 50);
//			    
//			    
//			    app.strokeWeight((float) 20.0);
//				app.stroke(0, 100);
//			    dragSegment(0, dedoPulgar.getPosition().x+200, dedoPulgar.getPosition().y+200);
//				dragSegment(1, x[0], y[0]);
		}
		

	    
	}
	
	
//	public void moverCuerpo(Hand hand, float manoX, float manoY){
//		
//		   	Finger dedoPulgar = hand.getFinger(0); 		// pierna izquierda
//		    Finger dedoIndice = hand.getFinger(1); 		// brazo izquierdo
//		    Finger dedoCorazon = hand.getFinger(2); 	// cabeza
//		    Finger dedoAnular = hand.getFinger(3); 		// brazo derecho
//		    Finger dedoMenique = hand.getFinger(4); 	// pierna derecha
//		    int x = 0;
//		    int y = 0;
//		
//	    for (int i = 0; i < extremidades.size(); i++) {
//	    	int parteDelCuerpo = extremidades.get(i).getParteCuerpo();
//	    	switch(parteDelCuerpo){
//	    	
//	    	case 0: // pierna izquierda
//	    		
//	    		if(sexo==2){ // Si el personaje es mujer
//	    			x = -50;
//	    			y = 70;
//	    		}
//	    		
//	    		extremidades.get(i).setXi(manoX+x);
//	    		extremidades.get(i).setYi(manoY+y);
//	    		extremidades.get(i).pintar(dedoCorazon.getPosition().x, dedoCorazon.getPosition().y);
//	    		break;
//	    	case 1: // brazo izquierdo
//	    		
//	    		if(sexo==2){ // Si el personaje es mujer
//	    			x = 50;
//	    			y = -70;
//	    		}
//	    		
//	    		extremidades.get(i).setXi(manoX+x);
//	    		extremidades.get(i).setYi(manoY+y);
//	    		extremidades.get(i).pintar(dedoAnular.getPosition().x, dedoAnular.getPosition().y);
//	    		break;
//	    		
//	    	case 2: // cabeza
//	    		
//	    		if(sexo==2){ // Si el personaje es mujer
//	    			x = 0;
//	    			y = -160;
//	    		}
//	    		
//	    		extremidades.get(i).setXi(manoX+x);
//	    		extremidades.get(i).setYi(manoY+y);
//	    		extremidades.get(i).pintar(dedoIndice.getPosition().x, dedoIndice.getPosition().y);
//	    		break;
//	    	case 3: // brazo derecho
//	    		
//	    		if(sexo==2){ // Si el personaje es mujer
//	    			x = -50;
//	    			y = -70;
//	    		}
//	    		
//	    		extremidades.get(i).setXi(manoX+x);
//	    		extremidades.get(i).setYi(manoY+y);
//	    		extremidades.get(i).pintar(dedoMenique.getPosition().x, dedoMenique.getPosition().y);
//	    		break;
//	    	case 4: // pierna derecha
//	    		
//	    		if(sexo==2){ // Si el personaje es mujer
//	    			x = 50;
//	    			y = 70;
//	    		}
//	    		
//	    		extremidades.get(i).setXi(manoX+x);
//	    		extremidades.get(i).setYi(manoY+y);
//	    		extremidades.get(i).pintar(dedoPulgar.getPosition().x, dedoPulgar.getPosition().y);
//	    		break;
//	    		
//	    	}
//	    	
//		}
//	}
//	
	public void mouse(){
		
	}
	
	// ======================================================
		// 1. Callbacks

		public void leapOnInit() {
		   app.println("Leap Motion Init");
		}
		public void leapOnConnect() {
		   app.println("Leap Motion Connect");
		}
		public void leapOnFrame() {
		   app.println("Leap Motion Frame");
		}
		public void leapOnDisconnect() {
		   app.println("Leap Motion Disconnect");
		}
		public void leapOnExit() {
		   app.println("Leap Motion Exit");
		}
}
