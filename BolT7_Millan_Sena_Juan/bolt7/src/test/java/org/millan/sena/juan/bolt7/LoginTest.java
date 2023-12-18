package org.millan.sena.juan.bolt7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.millan.sena.juan.vista.Login;
import org.millan.sena.juan.vista.PrimeraVentana;


class LoginTest {
	

	private Login login; 
	

	@BeforeEach
    public void setUp() {
        login = new Login();
    }

    //Aqui comprobamos que al querer iniciar sesion sin antes introducir datos nos muestre un mensaje de error especifico y que no se abra la ventana
	//primeraVentana
    @Test
    public void testLoginSinInsertarDatos() {
    	
    	login.iniciarSesion();
    	assertEquals("ERROR, debe rellenar los dos campos de texto", login.lbError.getText());
        assertEquals(login.primeraVentana, null);
    }
    
    //Aqui comprobamos que al querer iniciar sesion introduciendo una contrasenia incorrecta nos muestre un mensaje de error especifico y que tampoco 
    //se abra la ventana primeraVentana
    @Test
    public void testLoginContraseniaIncorrecta() {
    	
    	login.tfUsuario.setText("Juan");
    	login.pfContrasenia.setText("Incorrecta");
    	login.iniciarSesion();
    	assertEquals("ERROR, contrasenia incorrecta", login.lbError.getText());
        assertEquals(login.primeraVentana, null);
        
    }
    
    //Aqui comprobamos que al querer iniciar sesion introduciendo los datos correctamente se abra la ventana primeraVentana
    @Test
    public void testLoginCorrecto() {
    	
    	login.tfUsuario.setText("Juan");
    	login.pfContrasenia.setText("Contrasenia");
    	login.iniciarSesion();
        assertTrue(login.primeraVentana.isVisible());
    	
    }


}
