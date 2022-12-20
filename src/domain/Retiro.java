package domain;

public class Retiro extends Transaccion {

	Integer retirarDinero;
    Teclado teclado; 
	
	public Retiro(int numeroCuentaActual, Pantalla pantalla, BaseDatosBanco saldo, Teclado teclado) {
		super(numeroCuentaActual, pantalla, saldo);
		this.teclado = teclado;
	}

	@Override
	public void ejecutar() {
		
		System.out.println("\nIngrese el monto que desea retirar: ");
		
		retirarDinero = teclado.obtenerEntrada();
	
		if ((retirarDinero % 20) != 0) {
			
			System.out.println("Solo se aceptan multiplos de 20");
			
		} else if (retirarDinero >= 20 && retirarDinero <= 2147483647) {
			
			getSaldo().retiro(getNumeroCuentaActual(), retirarDinero);
		
		} else {
			System.out.println("\nIngrese un monto mayor o igual a 20");
		}
		
	}
	 
}
