package org.millan.sena.juan.controlador;

import org.millan.sena.juan.vista.CitaConfirmada;
import org.millan.sena.juan.vista.PrimeraVentana;

public class ControladorCitaConfirmada {
	
	CitaConfirmada citaConfirmada;
	
	public ControladorCitaConfirmada(CitaConfirmada citaConfirmada) {
		
		this.citaConfirmada=citaConfirmada;
		
	}
	
	public void cancelarCita() {
		
		citaConfirmada.primeraVentana = new PrimeraVentana();
		citaConfirmada.primeraVentana.setLocationRelativeTo(null);
		citaConfirmada.primeraVentana.setVisible(true);
		citaConfirmada.dispose();
		
	}
	
	public void confirmarCita() {
		
		citaConfirmada.dispose();
		
	}
	

}
