package main;

import java.awt.EventQueue;

import javax.sound.midi.Synthesizer;
import javax.sound.midi.VoiceStatus;

import vista.Login;

public class EjecutarPrograma {

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



