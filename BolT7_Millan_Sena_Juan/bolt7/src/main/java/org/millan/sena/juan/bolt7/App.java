package org.millan.sena.juan.bolt7;

import java.awt.EventQueue;

import org.millan.sena.juan.vista.Login;

public class App {

	public static void main(String[] args) {
		// Invoca la ejecución de la aplicación en el hilo de despacho de eventos de
				// Swing.
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							//Aqui lo que hago es iniciar la ventana principal de la aplicacion
							Login login = new Login();
							login.setLocationRelativeTo(null);
							login.setVisible(true);
							
						} catch (Exception e) {
							// Captura y muestra cualquier excepción que ocurra durante la ejecución.

							e.printStackTrace();
						}
					}
				});

	}

}



