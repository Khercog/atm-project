package domain;

import java.util.ArrayList;

public class BaseDatosBanco {
	
	private ArrayList<Cuenta> cuentas;
	
	private Cuenta cuenta1 = new Cuenta(12345, 12345);
	private Cuenta cuenta2 = new Cuenta(67890, 67890);
	
	
	public BaseDatosBanco() {
		
		this.cuentas = new ArrayList<>();
		cuentas.add(cuenta1);
		cuentas.add(cuenta2);
		
	}

	
	
	public void obtenerSaldo(int nroDeCta) {
		
		
		
		for (Cuenta c : cuentas) {
			
			if (c.getNroDeCuenta() == nroDeCta) {
				
				System.out.println(c.getSaldo()); 
				
			} 
		}
		
	}
	
	
	public void deposito(int nroDeCta, Integer dineroIngresado) {
		
		
		
		for (Cuenta c : cuentas) {
			
			if (c.getNroDeCuenta() == nroDeCta) {
				
					
					Integer nuevoSaldo = c.getSaldo() + dineroIngresado;
					
					System.out.println("\nSu nuevo saldo total: " + nuevoSaldo);
					
					c.setSaldo(nuevoSaldo);
				} 
				
		
			
		}
		
		
	}
	
	
	public void retiro(int nroDeCta, Integer retirarDinero) {
		
		
			
			
			for (Cuenta c : cuentas) {
				
				if (c.getNroDeCuenta() == nroDeCta) {
					if (!(c.getSaldo() < retirarDinero)) {
						
							Integer nuevoSaldo = c.getSaldo() - retirarDinero;
							
							System.out.println("\nHa retirado el monto de: " + retirarDinero);
							
							System.out.println("\nSu nuevo saldo total: " + nuevoSaldo);
							
							c.setSaldo(nuevoSaldo);
						
					} else {
						System.out.println("\nEl monto que intenta retirar es mayor al que posee en cuenta.");
					}
				}
						
					
			}

		
	}


	


	public boolean autenticarUsuario(Integer nroDeCta, Integer nip) {
			
		
		
		System.out.println("\nNúmero de cuenta ingresado: " + nroDeCta + " " + "\nNúmero de NIP ingresado: " + nip);
		
		boolean result = false;
		
		for (Cuenta c : cuentas) {
			
			if (c.getNroDeCuenta() == nroDeCta && c.getNip() == nip) {
				
				result = true;
				
				break;
			}
		}
		
		return result;
		
	}
	
	

}

class Cuenta {
	private int nroDeCuenta;
	private int nip;
	private Integer saldo;
	
	public Cuenta(int nroDeCuenta, int nip) {
		
		this.nroDeCuenta = nroDeCuenta;
		this.nip = nip;
		this.saldo = 0; 
		
	}

	public int getNroDeCuenta() {
		return nroDeCuenta;
	}


	public int getNip() {
		return nip;
	}


	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	
	
}
