package org.millan.sena.juan.controlador;

import javax.swing.JOptionPane;

import org.millan.sena.juan.vista.Login;
import org.millan.sena.juan.vista.PrimeraVentana;

import utiles.Utiles;

public class ControladorLogin {
	
	Login login;
	
	public ControladorLogin(Login login) {
		
		this.login=login;
		
	}
	
	public void iniciarSesion() {
		
		//Al hacer click en este boton obtenemos el texto del passwordField de insertar la contraseña, hacemos un if
		//indicando que si el texto que recojemos en el passwordField Contrasenia es "Contrasenia" se inicializara la ventana principal y 
		//esta ventana se cerrara
		if (login.pfContrasenia.getText().equals("Contrasenia")) {
			
			//Mensaje de prueba unitaria 
			System.out.println(Utiles.ANSI_GREEN +"Has introducido los datos correctamente");
			
			
			login.primeraVentana = new PrimeraVentana();
			login.primeraVentana.lblUsuario.setText("Bienvenido " + login.tfUsuario.getText());
			login.primeraVentana.setVisible(true);
			login.primeraVentana.setLocationRelativeTo(null);
			login.dispose();
			
		//En cambio, si el texto que recojemos de los campos de texto esta vacio mostramos un mensaje de error indicandolo
		}else if (login.tfUsuario.getText().length()==0 || login.pfContrasenia.getText().length()==0) {
			
			login.lbError.setText("ERROR, debe rellenar los dos campos de texto");
		
			//Mensaje de prueba unitaria
			System.out.println(Utiles.ANSI_RED + "Error, no has rellenado los campos de texto");
			
			//JOptionPane que se mostrara al usuario
			JOptionPane.showMessageDialog(null, "Error, no has rellenado los campos de texto");
			
			
		//Si pasa cualquier otra cosa, osea, el error que nos queda es que hayamos insertado una contraseña incorrecta
		//y si eso ocurre mostramos un mensaje de error indicandolo
		}else {
			
			login.lbError.setText("ERROR, contrasenia incorrecta");
			
			//Mensaje de prueba unitaria
			System.out.println(Utiles.ANSI_RED + "Error, has insertado una contraseña incorrecta");
			
			//JOptionPane que se mostrara al usuario
			JOptionPane.showMessageDialog(null, "ERROR, contrasenia incorrecta");
			
		}
		
		
	}
	
	
	

}
