import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class ParteCuerpo {
	private PApplet app;
	private float xi;
	private float yi;
	private float[] x = new float[3];
	private float[] y = new float[3];
	private float segLength = 100;
	private PImage head, armSupIzq, armSupDer, legSupIzq, legSupDer, armInfIzq, armInfDer, legInfIzq, legInfDer, manoDer, manoIzq; // imagenes extremidades
	private PImage[][] image; 								// arreglo de imagenes de extremidades
	int sexo;												// será 1 para definir si es hombre y 2 si es mujer			
	int parteCuerpo; 										// identificar que parte de cuerpo es 
																//0: pierna izquierda
																//1: brazo izquierdo
																//2: cabeza
																//3: brazo derecho
																//4: pierna derecha
						
	public ParteCuerpo(PApplet app, float xi, float yi, int parteCuerpo, int sexo){
		this.app = app;
		this.xi = xi;
		this.yi = yi;
		this.parteCuerpo = parteCuerpo;
		this.sexo = sexo;
		image = new PImage[5][3];
		
		if(sexo == 2){
			
			head = app.loadImage("data/dollGirl/cabeza.png");
			
			legSupIzq = app.loadImage("data/dollGirl/piernaIzquierdaSuperior.png");
			legInfIzq = app.loadImage("data/dollGirl/piernaIzquierdaInferior.png");
			armSupIzq = app.loadImage("data/dollGirl/brazoIzquierdoSuperior.png");
			armInfIzq = app.loadImage("data/dollGirl/brazoIzquierdoInferior.png");
			manoIzq = app.loadImage("data/dollGirl/manoIzquierda.png");
			
			armSupDer = app.loadImage("data/dollGirl/brazoDerechoSuperior.png");
			armInfDer = app.loadImage("data/dollGirl/brazoDerechoInferior.png");
			legSupDer = app.loadImage("data/dollGirl/piernaDerechaSuperior.png");
			legInfDer = app.loadImage("data/dollGirl/piernaDerechaInferior.png");
			manoDer = app.loadImage("data/dollGirl/manoDerecha.png");
			
		}
		
		if(sexo == 1){
			
			head = app.loadImage("data/dollBoy/cabeza.png");
			
			legSupIzq = app.loadImage("data/dollBoy/piernaIzquierdaSuperior.png");
			legInfIzq = app.loadImage("data/dollBoy/piernaIzquierdaInferior.png");
			armSupIzq = app.loadImage("data/dollBoy/brazoIzquierdoSuperior.png");
			armInfIzq = app.loadImage("data/dollBoy/brazoIzquierdoInferior.png");
			manoIzq = app.loadImage("data/dollBoy/manoIzquierda.png");
			
			armSupDer = app.loadImage("data/dollBoy/brazoDerechoSuperior.png");
			armInfDer = app.loadImage("data/dollBoy/brazoDerechoInferior.png");
			legSupDer = app.loadImage("data/dollBoy/piernaDerechaSuperior.png");
			legInfDer = app.loadImage("data/dollBoy/piernaDerechaInferior.png");
			manoDer = app.loadImage("data/dollBoy/manoDerecha.png");
			
		}
		
		image[0][0] =  legSupIzq;
		image[0][1] =  legInfIzq;
		image[1][0] =  armSupIzq;
		image[1][1] =  armInfIzq;
		image[1][2] =  manoIzq;
		image[2][0] =  head;
		image[3][0] =  armSupDer;
		image[3][1] =  armInfDer;
		image[3][2] =  manoDer;
		image[4][0] =  legSupDer;
		image[4][1] =  legInfDer;
	}
	
	public void pintar(float xf, float yf){
		dragSegment(0, xi, yi);
		
		if(parteCuerpo != 2){
			dragSegment(1, x[0], y[0]);
			app.imageMode(PConstants.CORNER);
		}else{
			app.imageMode(PConstants.CENTER);
		}
		
		if(parteCuerpo == 1 || parteCuerpo == 3){
			dragSegment(2, x[1], y[1]);
		}
		//app.line(xi, yi, xf, yf);
		
		 float angle = app.atan2(yi-yf, xi-xf);
		 
		 app.pushMatrix();
		 app.translate(xi, yi);
		 app.rotate(angle);
		 app.image(image[parteCuerpo][0], 0, 0);
		 app.popMatrix();
	}
	
	void dragSegment(int i, float xin, float yin) {
	  float dx = xin - x[i];
	  float dy = yin - y[i];
	  float angle = app.atan2(dy, dx);
	  x[i] = xin - app.cos(angle) * segLength;
	  y[i] = yin - app.sin(angle) * segLength;
	  segment(i, x[i], y[i], angle);
	}

	void segment(int i, float x, float y, float a) {
	  app.pushMatrix();
	  app.translate(x, y); 
	  app.ellipse(0, 0,5,5);
	  app.rotate(a);
	  app.line(0, 0, segLength, 0);
	  app.imageMode(PConstants.CORNER);
	  app.rotate(a);
	  //app.image(image[parteCuerpo][i], 0, 0);
	  app.popMatrix();
	}

	public float getXi() {
		return xi;
	}

	public void setXi(float xi) {
		this.xi = xi;
	}

	public float getYi() {
		return yi;
	}

	public void setYi(float yi) {
		this.yi = yi;
	}

	public int getParteCuerpo() {
		return parteCuerpo;
	}

	public void setParteCuerpo(int parteCuerpo) {
		this.parteCuerpo = parteCuerpo;
	}
}
