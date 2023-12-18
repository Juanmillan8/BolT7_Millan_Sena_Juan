package org.millan.sena.juan.bolt7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.millan.sena.juan.vista.IntroducirDatos;

class IntroducirDatosTest {

	private IntroducirDatos introducirDatos;
	
	@BeforeEach
    public void setUp() {
        introducirDatos = new IntroducirDatos();
    }
	
    //Aqui comprobamos que al querer confirmar los datos sin antes introducir datos nos muestre un mensaje de error especifico y que no se abra la 
	//ventana primeraVentana
    @Test
    public void testConfirmarDatosSinInsertarDatos() {
    	
    	introducirDatos.confirmarDatos();
    	assertEquals("ERROR, debes rellenar los campos de texto", introducirDatos.lblError.getText());
        assertEquals(introducirDatos.primeraVentana, null);

    }
	
    //Aqui comprobamos que al querer confirmar los datos sin seleccionar un tipo de profesional nos muestre un mensaje de error especifico y que no 
    //se abra la ventana primeraVentana
    @Test
    public void testConfirmarDatosSinElegirProfesional() {
    	
    	introducirDatos.tfTarjeta.setText("Datos de prueba");
    	introducirDatos.tfMotivo.setText("Datos de prueba");
    	
    	introducirDatos.confirmarDatos();
    	assertEquals("ERROR, debes seleccionar el tipo de profesional", introducirDatos.lblError.getText());
        assertEquals(introducirDatos.primeraVentana, null);

    }
    
    //Aqui comprobamos que al querer confirmar los datos correctamente se abra la ventana primeraVentana
    @Test
    public void testConfirmarDatosCorrectamente() {
    	
    	introducirDatos.tfTarjeta.setText("Datos de prueba");
    	introducirDatos.tfMotivo.setText("Datos de prueba");
    	introducirDatos.rbMatrona.setSelected(true);
    	
    	introducirDatos.confirmarDatos();
        assertTrue(introducirDatos.primeraVentana.isVisible());

    }

}
