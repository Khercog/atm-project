package domain;

import java.util.Scanner;

public class Teclado {

	
	public int obtenerEntrada() {
		
		Scanner scanner = new Scanner(System.in);
		
		return scanner.nextInt();
		
	}
	
}
