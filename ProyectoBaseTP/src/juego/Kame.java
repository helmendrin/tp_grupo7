package juego;

import java.awt.Color;

import entorno.Entorno;

public class Kame  {
	private int x;
	private int y;
	private int diametro;
	private int velocidad;
	
	Kame (int diametro, int velocidad){
		this.x=0;
		this.y=0;
		this.diametro= diametro;
		this.velocidad=velocidad;
	}
	 void setX (int x) {
		 this.x=x;
		 
	 }
	 void setY (int y) {
		 this.y=y;
		 
	 }
	 void disparar() {
		 this.y=this.y-this.velocidad;
	 }
	 void dibujarse(Entorno entorno) {
			entorno.dibujarCirculo(x, y, diametro, Color.GRAY);
		}
}