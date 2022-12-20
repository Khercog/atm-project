package domain;

public class SolicitudSaldo extends Transaccion {

	public SolicitudSaldo(int numeroCuentaActual, Pantalla pantalla, BaseDatosBanco saldo) {
		super(numeroCuentaActual, pantalla, saldo);
		
	}

	@Override
	public void ejecutar() {
		
		System.out.print("\n" + getPantalla().mostrarSaldo());
		getSaldo().obtenerSaldo(getNumeroCuentaActual());
		
	}

}
