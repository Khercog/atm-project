package domain;

import java.util.Scanner;

public class Atm {

	   private boolean usuarioAutenticado; // indica si el usuario es autenticado
	   private int numeroCuentaActual; // current user's account number
	   private Pantalla pantalla; // pantalla del ATM
	   private Teclado teclado; // teclado del ATM
	   private BaseDatosBanco baseDatosBanco; //  base de datos de información de las cuentas
	   boolean usuarioSalio = false;
	   
	   // constantes correspondientes a las opciones del menú principal
	   private static final int SOLICITUD_SALDO = 1;
	   private static final int RETIRO = 2;
	   private static final int DEPOSITO = 3;
	   private static final int SALIR = 4;
	 
	
	   // el constructor sin argumentos de ATM inicializa las variables de instancia
	   public Atm() {
		
		usuarioAutenticado = false;
		numeroCuentaActual = 0;
		pantalla = new Pantalla();
		teclado = new Teclado();
		baseDatosBanco = new BaseDatosBanco();
	} // fin del constructor sin argumentos de ATM

	   public int mostrarMenuPrincipal()
	   {
		  pantalla.mostrarMensaje( "\n************************************" );
		  pantalla.mostrarMensaje( "Bienvenido: " + numeroCuentaActual );
	      pantalla.mostrarMensaje( "\nMenu principal:" );
	      pantalla.mostrarMensaje( "1 - Ver mi saldo" );
	      pantalla.mostrarMensaje( "2 - Retirar efectivo" );
	      pantalla.mostrarMensaje( "3 - Depositar fondos" );
	      pantalla.mostrarMensaje( "4 - Salir" );
	      pantalla.mostrarMensaje( "************************************" );
	      pantalla.mostrarMensaje( "Escriba una opcion: " );
	      return teclado.obtenerEntrada(); // devuelve la opcion seleccionada por el usuario
	   } // fin del método mostrarMenuPrincipal
	   
	   public void presionarEnter() 
	   {
		
		   System.out.println("\nPresiona Enter para volver al menu principal...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		   
		   
	   }
	   
	   private void autenticarUsuario() 
	   {
		   
		  pantalla.mostrarMensaje( "\nBienvenido!" ); 
	      pantalla.mostrarMensaje( "\nEscriba su numero de cuenta: " );
	      Integer numeroCuenta = teclado.obtenerEntrada(); // recibe como entrada el número de cuenta
	      pantalla.mostrarMensaje( "\nEscriba su NIP: " ); // pide el NIP
	      Integer nip = teclado.obtenerEntrada(); // recibe como entrada el NIP
	      
	      // establece usuarioAutenticado con el valor booleano devuelto por la base de datos
	      usuarioAutenticado = 
	         baseDatosBanco.autenticarUsuario( numeroCuenta, nip );
	      
	      // verifica si la autenticación tuvo éxito
	      if ( usuarioAutenticado == true )
	      {
	         numeroCuentaActual = numeroCuenta; // guarda el # de cuenta del usuario	         
	      } // fin de if
	      else
	         pantalla.mostrarMensaje( 
	             "\n###################################################"
	             + "\nNumero de cuenta o NIP invalido. Intente de nuevo."
	             + "\n###################################################" );
	   } // fin del método autenticarUsuario
	   
	   public Transaccion crearTransaccion( int tipo )
		
	   {
	      Transaccion temp = null; // variable temporal Transaccion
	      
	      // determina qué tipo de Transaccion crear     
	      switch ( tipo )
	      {
	         case SOLICITUD_SALDO: // crea una nueva transacción SolicitudSaldo
	            temp = new SolicitudSaldo( 
	               numeroCuentaActual, pantalla, baseDatosBanco );
	            break;
	         case RETIRO: // crea una nueva transacción Retiro
	            temp = new Retiro( numeroCuentaActual, pantalla, 
	               baseDatosBanco, teclado );
	            break; 
	         case DEPOSITO: // crea una nueva transacción Deposito
	            temp = new Deposito( numeroCuentaActual, pantalla, 
	               baseDatosBanco, teclado );
	            break;
	      } // fin de switch

	      return temp; // devuelve el obejto recién creado
	   } // fin del método crearTransaccion
	// devuelve un objeto de la subclase especificada de Transaccion
	
	public void realizarTransacciones() 
	   {
	      // variable local para almacenar la transacción que se procesa actualmente
	      Transaccion transaccionActual = null;
	      
	      //boolean usuarioSalio = false; // el usuario no ha elegido salir

	      // itera mientras que el usuario no haya elegido la opción para salir del sistema
	      while ( !usuarioSalio )
	      {     
	         // muestra el menú principal y obtiene la selección del usuario
	         int seleccionMenuPrincipal = mostrarMenuPrincipal();

	         // decide cómo proceder, con base en la opción del menú seleccionada por el usuario
	         switch ( seleccionMenuPrincipal )
	         {
	            // el usuario eligió realizar uno de tres tipos de transacciones
	            case SOLICITUD_SALDO: 
	            case RETIRO: 
	            case DEPOSITO:

	               // inicializa como nuevo objeto del tipo elegido
	               transaccionActual = 
	                  crearTransaccion( seleccionMenuPrincipal );

	               transaccionActual.ejecutar(); // ejecuta la transacción
	               presionarEnter();
	               break; 
	            case SALIR: // el usuario eligió terminar la sesión
	               pantalla.mostrarMensaje( "\nCerrando el sistema..." );
	               usuarioSalio = true; // esta sesión con el ATM debe terminar
	               break;
	            default: // el usuario no introdujo un entero de 1 a 4
	               pantalla.mostrarMensaje( 
	                  "\nNo introdujo una seleccion valida. Intente de nuevo." );
	               break;
	         } // fin de switch
	      } // fin de while
	   } // fin del método realizarTransacciones
	   
	   public void run()
	   {
		   
		   do {
			   
			   while ( !usuarioAutenticado ) 
		         {    
				   
				   	autenticarUsuario();
				   
		         } // fin de while
			   
			
			  
			  realizarTransacciones(); // ahora el usuario está autenticado 
		      usuarioAutenticado = false; // restablece antes de la siguiente sesión con el ATM
		      numeroCuentaActual = 0; // restablece antes de la siguiente sesión con el ATM 
		      pantalla.mostrarMensaje( "\nGracias! Adios!" );
			   
		   } while(!usuarioSalio);
		   
	   } 
	   	   
}
