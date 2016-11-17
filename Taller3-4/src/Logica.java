import com.leapmotion.leap.Frame;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Logica {
	private PApplet app;
	private int puntaje;
	private SistemaParticula sp;
	private Personaje personaje;
	private int pantalla;
	private PImage inicio, instrucciones, personajes, fondo, puntuacion, fondo2;
	private int aciertos;
	private Minim musica;
	private AudioPlayer song;
	private PImage[] gestos;
	private int r1,r2,r3;
	private int tiempo, contador;
	private int tint;
	public Logica(PApplet app) {
		this.app = app;
		personaje = new Personaje(app, 2);
		this.sp = new SistemaParticula(new PVector(app.width/2, 50), app);
		musica = new Minim(app);
		song = musica.loadFile("Taller3-4/data/song.mp3");
		inicio = app.loadImage("Taller3-4/data/fondo/inicio-01-01.png");
		inicio.resize(1200, 700);
		instrucciones = app.loadImage("Taller3-4/data/fondo/instrucciones-01.png");
		instrucciones.resize(1200, 700);
		personajes = app.loadImage("Taller3-4/data/fondo/elegirPj-06.png");
		personajes.resize(1200, 700);
		fondo = app.loadImage("Taller3-4/data/fondo/fondo-01.png");
		fondo.resize(1200, 700);
		puntuacion = app.loadImage("Taller3-4/data/fondo/puntuacion-01.png");
		puntuacion.resize(1200, 700);
		gestos = new PImage[20];
		for(int i=1;i<=gestos.length;i++){
			gestos[i-1] = app.loadImage("Taller3-4/data/gestos/mano"+i+"-02.png");
			gestos[i-1].resize(100, 100);
		}
		r1 = (int) app.random(20);
		r2 = (int) app.random(20);
		r3 = (int) app.random(20);
		tint = 255;
		
	}
	
	public void pintar() {
		switch (pantalla) {
		case 0:
			app.image(inicio, 0, 0);
			break;
		case 1:
			app.image(instrucciones, 0, 0);
			break;
		case 2:
			app.image(personajes, 0, 0);
			break;
		case 3:
            if(puntaje == 0){
				
			}else if(puntaje>=25){
				
			}else if(puntaje>=75){
				
			}
            if(app.frameCount%60 == 0){
            	tiempo++;
            	if(tiempo%2 == 0){
                	if(aciertos<contador){
                    	if(tint>5){
                		tint-=15;
                    	}
                	}
                	contador++;
                }
            }
            
            if(tint <=5){
            	pantalla= 4;
            }
            app.tint(tint);
			app.image(fondo, 0, 0);
			app.tint(255);
			if(!song.isPlaying()){
				song.play();
			}
			personaje.pintar();
			app.image(gestos[r1], 1000, 136);
			app.image(gestos[r2], 1000, 256);
			app.image(gestos[r3], 1000, 376);
			app.fill(255);
			app.textSize(50);
			app.text("Puntaje: " + puntaje, 100, 100);
			
			break;
		case 4:
			app.image(puntuacion, 0, 0);
			break;

		default:
			break;
		}
		
	}
	
	public void mousePressed(){
		if(app.mouseX<516 && app.mouseX>364 && app.mouseY<622 && app.mouseY>562 && pantalla==0){
			pantalla = 2;
		}else if(app.mouseX<854 && app.mouseX>699 && app.mouseY<622 && app.mouseY>562&& pantalla == 0){
			pantalla = 1;
		}else if(pantalla == 1){
			pantalla = 0;
		}else if(pantalla == 2 && app.mouseX<539 && app.mouseX>337 && app.mouseY<662 && app.mouseY>262){
			personaje = new Personaje(app, 2);
			pantalla  = 3;
		}else if(pantalla == 2 && app.mouseX<865 && app.mouseX>651 && app.mouseY<662 && app.mouseY>262){
			personaje = new Personaje(app, 1);
			pantalla = 3;
		}
		personaje.mouse();
	}
}
