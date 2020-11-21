package juego;

import java.awt.Color;

import entorno.Entorno;

public class Auto {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	
	Auto (int x, int y, int alto, int ancho){
		this.x=x;
		this.y=y;
		this.alto= alto;
		this.ancho=ancho;
		this.velocidad=2;
	}
	void moverseIzq () {
		this.x=this.x - this.velocidad;
	}
	void moverseDer () {
		this.x=this.x + this.velocidad;
	}
	void moverAbajo() {
		this.y=this.y+3;
	}
	void iniciarVelocidad(int x) {
		this.velocidad=x;
	}
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto,0, Color.pink);
	}
	int getX() {
		return this.x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

}
