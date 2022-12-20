package domain;

public abstract class Transaccion {

	
	private int numeroCuentaActual;
	private Pantalla pantalla;
	private BaseDatosBanco saldo;
	
	
	
	public Transaccion(int numeroCuentaActual, Pantalla pantalla, BaseDatosBanco saldo) {
		
		this.numeroCuentaActual = numeroCuentaActual;
		this.pantalla = pantalla;
		this.saldo = saldo;
	}



	
	public int getNumeroCuentaActual() {
		return numeroCuentaActual;
	}




	public void setNumeroCuentaActual(int numeroCuentaActual) {
		this.numeroCuentaActual = numeroCuentaActual;
	}




	public Pantalla getPantalla() {
		return pantalla;
	}




	public void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}




	public BaseDatosBanco getSaldo() {
		return saldo;
	}




	public void setSaldo(BaseDatosBanco saldo) {
		this.saldo = saldo;
	}




	public abstract void ejecutar();
	 	
	   
}
