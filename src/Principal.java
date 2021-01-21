import java.util.Scanner;

public class Principal {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		crearLinea();

	}

	public static void crearLinea() {

		System.out.println("Introduzca las coordenadas del primer punto: ");
		double xA = pedirX();
		double yA = pedirY();

		System.out.println("\nIntroduzca las coordenadas del segundo punto: ");
		double xB = pedirX();
		double yB = pedirY();

		Punto puntoA = new Punto(xA, yA);

		Punto puntoB = new Punto(xB, yB);

		Linea linea1;

		try {
			linea1 = new Linea(puntoA, puntoB);
			mostrarMenu(linea1);
		} catch (LineaException e) {

			e.printStackTrace();
		}

	}

	public static double pedirX() {
		double x;
		System.out.println("\nIntroduzca la posición del punto X:  ");
		x = Double.parseDouble(teclado.nextLine());
		return x;
	}

	public static double pedirY() {
		double x;
		System.out.println("Introduzca la posición del punto Y:  ");
		x = Double.parseDouble(teclado.nextLine());
		return x;
	}

	public static void mostrarMenu(Linea linea1) {
		int respuesta;
		char respuesta2;
		boolean salir = false;

		do {

			System.out
					.println("\nBuenas. ¿Qué opción desea elegir? " + "\n1. Mover línea \n2. Mostrar línea \n3. Salir");
			respuesta = Integer.parseInt(teclado.nextLine());

			switch (respuesta) {

			case 1:
				System.out.println("\nElige una opción: \nA-Arriba \nB-Abajo \nI-Izquierda \nD-Derecha ");
				respuesta2 = teclado.nextLine().charAt(0);
				respuesta2 = Character.toUpperCase(respuesta2);
				llamarMenu2(respuesta2, linea1);
				break;

			case 2:
				System.out.println(linea1);
				break;

			case 3:
				System.out.println("Hasta la próxima");
				salir = true;
				break;

			default:
				System.out.println("Dato incorrecto");

			}
		} while (salir == false);

	}

	public static void llamarMenu2(char respuesta2, Linea linea1) {
		double moverArriba, moverAbajo, moverIzquierda, moverDerecha;

		try {

			switch (respuesta2) {
			case 'A':
				System.out.println("¿Cuánto quiere moverla arriba?");
				moverArriba = Double.parseDouble(teclado.nextLine());
				linea1.moverArriba(moverArriba);
				break;

			case 'B':
				System.out.println("¿Cuánto quiere bajarla?");
				moverAbajo = Double.parseDouble(teclado.nextLine());
				linea1.moverAbajo(moverAbajo);
				break;

			case 'I':
				System.out.println("¿Cuánto quiere mover hacia la izquierda?");
				moverIzquierda = Double.parseDouble(teclado.nextLine());
				linea1.moverIzquierda(moverIzquierda);
				break;

			case 'D':
				System.out.println("¿Cuánto quiere mover hacia la derecha?");
				moverDerecha = Double.parseDouble(teclado.nextLine());
				linea1.moverDerecha(moverDerecha);
				break;

			default:
				System.out.println("Dato incorrecto");
			}
		} catch (LineaException e) {

			e.printStackTrace();
		}
	}

}
