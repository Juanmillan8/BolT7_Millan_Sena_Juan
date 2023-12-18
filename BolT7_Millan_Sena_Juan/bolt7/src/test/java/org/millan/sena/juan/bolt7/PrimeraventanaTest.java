package org.millan.sena.juan.bolt7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.millan.sena.juan.vista.PrimeraVentana;

class PrimeraventanaTest {

	private PrimeraVentana ventana;
	
	@BeforeEach
    public void setUp() {
        ventana = new PrimeraVentana();
    }
	
	//Aqui comprobamos que el metodo insertarDatos de la clase PrimeraVentana abre la ventana IntroducirDatos
    @Test
    public void testVentanaInsertarDatosVisible() {

        ventana.insertarDatos();
        assertTrue(ventana.datos.isVisible());
    }
    
    //Aqui comprobamos que al querer realizar una cita para antes de maniana nos muestre un mensaje de error especifico
    //y no se abra la ventana citaConfirmada
    @Test
    public void testCitaAntesDeManiana() {
    	
    	Calendar diaAnteriorHoy = Calendar.getInstance();
    	diaAnteriorHoy.add(Calendar.DAY_OF_MONTH, -1);
    	
    	ventana.Calendario.setDate(diaAnteriorHoy.getTime());
    	ventana.informacion="Datos de prueba";
    	ventana.establecerCita();
    	assertEquals("<html>Error, la cita debe ser minimo para maniana</html>", ventana.lblError.getText());
        assertEquals(ventana.citaConfirmada, null);
        
    }
    
    //Aqui comprobamos que al querer establecer una cita sin antes introducir datos nos muestre un mensaje de error especifico y que tambien la ventana
    //citaConfirmada no se muestre
    @Test
    public void testEstablecerCitaSinDatos() {
    	
    	ventana.establecerCita();
    	assertEquals("<html>Error, primero debes rellenar los datos</html>", ventana.lblError.getText());
        assertEquals(ventana.citaConfirmada, null);
        
    }
    
    //Aqui comprobamos que al configurar la cita correctamente se abra la ventana citaConfirmada
    @Test
    public void testEstablecerCitaCorrectamente() {
    	
    	Calendar diaPosteriorHoy = Calendar.getInstance();
    	diaPosteriorHoy.add(Calendar.DAY_OF_MONTH, +1);
    	
    	ventana.Calendario.setDate(diaPosteriorHoy.getTime());
    	ventana.informacion="Datos de prueba";
    	ventana.establecerCita();
        assertTrue(ventana.citaConfirmada.isVisible());
        
    }
    
}
