package org.millan.sena.juan.controlador;

import org.millan.sena.juan.vista.IntroducirDatos;
import org.millan.sena.juan.vista.PrimeraVentana;

import utiles.Utiles;

public class ControladorIntroducirDatos {
	
	IntroducirDatos intorducirDatos;
	
	public ControladorIntroducirDatos(IntroducirDatos introducirDatos){
		
		this.intorducirDatos=introducirDatos;
		
	}
	
	public void introducirDatos() {
		
		//Si pulsamos este boton pero no hemos insertado nada en los campos de texto usaremos el jlabel lbError para mostrar un 
				//mensaje de error
				if (intorducirDatos.tfTarjeta.getText().length()==0 | intorducirDatos.tfMotivo.getText().length()==0) {
					
					intorducirDatos.lblError.setText("ERROR, debes rellenar los campos de texto");
				
					//Mensaje de prueba unitaria
					System.out.println(Utiles.ANSI_RED + "ERROR, los campos de texto no han sido rellenados");
					
				//Y si no hemos elejido ningun profesional mostraremos otro mensaje de error
				}else if (!intorducirDatos.rbMatrona.isSelected() && !intorducirDatos.rbTest.isSelected() && !intorducirDatos.rbEnfermeria.isSelected()) {
					
					intorducirDatos.lblError.setText("ERROR, debes seleccionar el tipo de profesional");
					
					//Mensaje de prueba unitaria
					System.err.println(Utiles.ANSI_RED + "ERROR, no se ha seleccionado ningun radioButton");
					
				}else {
					
					//Mensaje de prueba unitaria
					System.out.println(Utiles.ANSI_GREEN + "Se ha rellenado toda la informacion correctamente");
					  
					
					
					//String profesional para almacenar el profesional que hemos elejido 
					String profesional;
					
					//Si el radiobutton tbMatrona ha sido seleccionado insertamos el texto matrona en el String profesional
					if (intorducirDatos.rbMatrona.isSelected()) {
						
						profesional="matrona";
					
					//En cambio si hemos seleccionado el radiobutton rbTest insertamos el texto text antigenos en el String profesional
					}else if (intorducirDatos.rbTest.isSelected()) {
						
						profesional="test antigenos";
					
					//Si no hemos seleccionado ningun radiobutton de los anteriores nos queda el rbEnfermeria, insertamos en el String 
					//profesional el texto enfermeria
					}else {
						
						profesional="enfermeria";
						
						
					}
					
					
					
					
					//Posteriormente volvemos a la ventana PrimeraVentana y le pasamos a traves del String informacion de dicha ventana
					//toda la informacion que acabamos de configurar 
					intorducirDatos.primeraVentana = new PrimeraVentana();
					intorducirDatos.primeraVentana.setLocationRelativeTo(null);
					intorducirDatos.primeraVentana.setVisible(true);
					intorducirDatos.primeraVentana.informacion=("<html>el usuario con tarjeta sanitaria " + intorducirDatos.tfTarjeta.getText() + " ha configurado una cita "
							+ "con motivo: \"" + intorducirDatos.tfMotivo.getText() + "\"   y profesional " + profesional + " </html>");
					
					intorducirDatos.dispose();
					
				}
		
		
	}
	
	

}
