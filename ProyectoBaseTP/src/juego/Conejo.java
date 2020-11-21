package juego;

import java.awt.Color;

import entorno.Entorno;

public class Conejo {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	private boolean estaSubiendo;
	
	Conejo (int x, int y, int alto, int ancho){
		this.x=x;
		this.y=y;
		this.alto= alto;
		this.ancho=ancho;
		this.velocidad=0;
		this.estaSubiendo=false;
	}
	void moverseIzq () {
		this.x=this.x - this.velocidad;
	}
	void moverseDer () {
		this.x=this.x + this.velocidad;
	}
	void avanza () {
		this.y=this.y - 10;
	}
	 void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto,0, Color.blue);
	}
	 public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	void bajando() {
		 this.y=this.y+1;
	 }
	 void setEstaSubiendo(boolean e) {
		 this.estaSubiendo=e;
	 }
	 boolean getEstaSubiendo() {
		 return this.estaSubiendo;
	 }
	
}
