package domain;

public class Deposito extends Transaccion {
 
	Integer dineroIngresado;
	Teclado teclado;
	
	public Deposito(int numeroCuentaActual, Pantalla pantalla, BaseDatosBanco saldo, Teclado teclado) {
		super(numeroCuentaActual, pantalla, saldo);
		this.teclado = teclado;
	}

	


	@Override
	public void ejecutar() {
		
		System.out.println("\nIngrese el monto que desea depositar: ");
		
		dineroIngresado = teclado.obtenerEntrada();

		if ((dineroIngresado % 20) != 0) {
			
			System.out.println("Solo se aceptan multiplos de 20");
			
		} else if (dineroIngresado >= 20 && dineroIngresado <= 2147483647) {
		
			System.out.println("\nHa ingresado el monto de: " + dineroIngresado);
			getSaldo().deposito(getNumeroCuentaActual(), dineroIngresado);
	
		} else {
			System.out.println("\nIngrese un monto mayor o igual a 20");
		}
	}

}
