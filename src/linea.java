
public class Linea {

	private Punto puntoA;
	private Punto puntoB;

	public Linea(Punto puntoA, Punto puntoB) throws LineaException {
		
		if(puntoA.equals(puntoB)) {
			throw new LineaException("Los puntos no pueden ser iguales");
		}
		
		this.puntoA = puntoA;
		this.puntoB = puntoB;
		
	}

	public Punto getPuntoA() {
		return puntoA;
	}

	public void setPuntoA(Punto puntoA) {
		this.puntoA = puntoA;
	}

	public Punto getPuntoB() {
		return puntoB;
	}

	public void setPuntoB(Punto puntoB) {
		this.puntoB = puntoB;
	}
	
	public boolean equals (Linea otra) {
		boolean esIgual=false;
		
		if(this.puntoA==otra.puntoB && this.puntoB==otra.puntoB) {
			esIgual=true;
		}
		
		return esIgual;
		
	}
	
	public void moverDerecha(double moverDerecha) throws LineaException {
	
		movimientoPositivo(moverDerecha);
		
		this.puntoA.setX(this.puntoA.getX()+moverDerecha);
		this.puntoB.setX(this.puntoB.getX()+moverDerecha);
		
	}
	
	public void moverIzquierda(double moverIzquierda) throws LineaException {
		
		movimientoPositivo(moverIzquierda);

		this.puntoA.setX(this.puntoA.getX()-moverIzquierda);
		this.puntoB.setX(this.puntoB.getX()-moverIzquierda);
		
	}
	
	public void moverArriba(double moverArriba) throws LineaException {
		
		movimientoPositivo(moverArriba);
		
		this.puntoA.setY(this.puntoA.getY()+moverArriba);
		this.puntoB.setY(this.puntoB.getY()+moverArriba);
		
	}
	
	public void moverAbajo(double moverAbajo) throws LineaException {
		
		movimientoPositivo(moverAbajo);
		
		this.puntoA.setY(this.puntoA.getY()-moverAbajo);
		this.puntoB.setY(this.puntoB.getY()-moverAbajo);
		
	}
	
	public String toString() {
		return "[ "+puntoA+","+puntoB+" ]";
	}
	
	public void movimientoPositivo(double movimiento) throws LineaException{
		if(movimiento<0) {
			throw new LineaException("El movimiento ha de ser positivo");
		}
	}
	
}
