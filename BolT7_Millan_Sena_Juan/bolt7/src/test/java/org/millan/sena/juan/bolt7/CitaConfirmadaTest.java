package org.millan.sena.juan.bolt7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.millan.sena.juan.vista.CitaConfirmada;

class CitaConfirmadaTest {
	
	private CitaConfirmada citaConfirmada;
	
	@BeforeEach
    public void setUp() {
        citaConfirmada = new CitaConfirmada();
    }
	
    //Aqui comprobamos que al hacer click en el boton para cancelar la cita se abra la ventana primeraVentana de nuevo y los datos se pierdan
    @Test
    public void testCancelarCita() {
    	
    	citaConfirmada.cancelarCita();
        assertTrue(citaConfirmada.primeraVentana.isVisible());
        assertTrue(citaConfirmada.primeraVentana.informacion==null);    
        
    }
    
    //Ahora comprobamos que al hacer click en el boton para confirmar la cita se cierre la ventana citaConfirmada
    @Test
    public void testConfirmarCita() {
    	
    	citaConfirmada.confirmarCita();
        assertFalse(citaConfirmada.isVisible());
        
    }

}
