package org.millan.sena.juan.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.millan.sena.juan.vista.CitaConfirmada;
import org.millan.sena.juan.vista.IntroducirDatos;
import org.millan.sena.juan.vista.PrimeraVentana;

import utiles.Utiles;

public class ControladorPrimeraVentana {
	
	PrimeraVentana primeraVentana;
	
	public ControladorPrimeraVentana(PrimeraVentana primeraVentana) {
		
		this.primeraVentana=primeraVentana;
		
	}
	
	public void establecerCita() {
		
		//aqui lo que hago es recoger la fecha actual y guardarla en una variable tipo Date, esto lo hago para comparar la fecha de hoy con la 
				//recogida en el jcalendar
				Date today = new Date();
				
				//Para que dicho boton sea funcional, primero debemos de asegurarnos de que el String informacion tenga contenido osea, tenemos 
				//que haber introducido datos del usuario y de la cita y tambien nos aseguramos de que para la cita hemos elegido una fecha de 
				//como minimo para el dia siguiente
				if (primeraVentana.informacion!=null && primeraVentana.Calendario.getDate().after(today)) {
					
					
					//Mensaje de prueba unitaria
					System.out.println(Utiles.ANSI_GREEN + "La fecha de la cita se ha configurado correctamente");
					  
					//En cambio si ya hemos introducido todos los datos de la cita, el String informacion tiene contenido y la fecha
					//es para el dia siguiente como minimo haremos lo siguiente:
					//recogeremos la fecha de la cita en un string para pasarlo al lblFecha del jdialog CitaConfirmada y mostrarlo
					//en dicho jdialog, para ello la etiqueta lblFecha en el jdialog CitaConfirmada tiene que ser publica
					//lo mismo hacemos con el string informacion, se lo pasamos al lblInformacionUsuario para mostrarlo en el jdialog
					//luego hacemos visible el jdialog y cerramos este
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String fecha = sdf.format(primeraVentana.Calendario.getDate());
					primeraVentana.citaConfirmada = new CitaConfirmada();
					primeraVentana.citaConfirmada.setLocationRelativeTo(null);
					primeraVentana.citaConfirmada.setVisible(true);
					primeraVentana.citaConfirmada.lblFecha.setText("Para el dia " + fecha);
					primeraVentana.citaConfirmada.lblInformacionUsuario.setText(primeraVentana.informacion);
					
					
					primeraVentana.dispose();
				
				//De lo contrario, si el string informacion esta a nulo significa que no nos hemos dirijido todavia a la ventana IntroducirDatos y por 
				//lo tanto no hemos introducido los datos, por lo que mostramos un mensaje de error
				}else if (primeraVentana.informacion==null) {
					
					
					primeraVentana.lblError.setText("<html>Error, primero debes rellenar los datos</html>");
				
					//Mensaje de prueba unitaria
					System.out.println(Utiles.ANSI_RED + "Error, no se han reyenado los datos");
					
				//en el caso de que la fecha que he elegido en el calendario sea anterior a la fecha actual mostramos otro mensaje de error
				}else if (primeraVentana.Calendario.getDate().before(today)) {
					
					primeraVentana.lblError.setText("<html>Error, la cita debe ser minimo para maniana</html>");
					
					//Mensaje de prueba unitaria
					System.out.println(Utiles.ANSI_RED + "Error, la cita se ha configurado para antes de maniana");
				}
		
	}
	
	public void insertarDatos() {
		
		
		//Con esto abrimos la ventana IntroducirDatos para insertar datos del cliente que quiere realizar la cita y demas
		primeraVentana.datos = new IntroducirDatos();
		primeraVentana.datos.setLocationRelativeTo(null);
		primeraVentana.datos.setVisible(true);
		primeraVentana.dispose();
		
	}
	

}
