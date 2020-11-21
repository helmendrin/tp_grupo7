package juego;


import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Conejo conejo;
	private Kame [] kame;
	private Auto [] IzqUno;
	private Auto [] IzqDos;
	private Auto [] IzqTres;
	private Auto [] IzqCuatro;
	private Auto [] DerUno;
	private Auto [] DerDos;
	private Auto [] DerTres;
	private Auto [] DerCuatro;
	private int distKame;

	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo ... - v1", 800, 600);
		this.conejo= new Conejo (400,525,80,50);
		this.distKame=0;
		IzqUno= new Auto [3];
		this.kame=new Kame[3];
		int distancia=50; //esta bien inicializar aca?
		for(int i=0;i<IzqUno.length;i++) {
			IzqUno[i]=new Auto(30*i+distancia, 320, 30, 100);
			distancia=distancia+300;	
		}
		for(int i=0;i<this.kame.length;i++) {
			this.kame[i]=new Kame( 30, 3);	
		}
		
		
		
		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	
	{
		for (int i = 0; i < IzqUno.length; i++) {
			this.IzqUno[i].moverseIzq();
			this.IzqUno[i].dibujarse(entorno);
			
		}
		reapareceAutoIzq(IzqUno);
		this.conejo.dibujarse(this.entorno);
		if (this.entorno.estaPresionada (this.entorno.TECLA_ARRIBA) && conejo.getEstaSubiendo()==false) {
			this.conejo.avanza();
			this.conejo.setEstaSubiendo(true);
		}

		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)&& entorno.sePresiono(entorno.TECLA_IZQUIERDA)) {
			conejo.moverseIzq();
		}
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)&& entorno.sePresiono(entorno.TECLA_DERECHA)) {
			conejo.moverseDer();
		}
		conejo.bajando();
		
		if(this.entorno.estaPresionada(this.entorno.TECLA_ESPACIO) || this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)) {
			iniciarKame();
		}
		for(int i=0;i<this.kame.length;i++) {
			this.kame[i].dibujarse(entorno);
			this.kame[i].disparar();
		}
		

		
		
		}
		// Procesamiento de un instante de tiempo
		// ...
		
	
	void reapareceAutoIzq(Auto [] a) {
		for(int i=0;i<a.length;i++) {
			if(a[i].getX()+a[i].getAncho()/2==0) {
				a[i].setX(800);
			}
		}
	}
	//cuando se dispara tienen que salir todos los kame del arreglo o solo de a uno por presion de tecla??
	void iniciarKame() {
		int posCoX = this.conejo.getX();
		int posCoY=this.conejo.getY();
		int d=0;
		for (int i = 0; i < this.kame.length; i++) {
			this.kame[i].setX(posCoX);
			this.kame[i].setY(posCoY-d);
			d=d+40 ;
		}
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
