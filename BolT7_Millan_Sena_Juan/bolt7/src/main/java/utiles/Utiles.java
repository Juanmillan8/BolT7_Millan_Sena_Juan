package utiles;

import java.awt.Color;

import javax.swing.JComponent;

public class Utiles {
	
	
	//Colores
	public static String COLOR_AZUL = "339999";
	public static String COLOR_CLARO = "D6EAE2";
	public static String COLOR_VERDE = "3F8671";
	
	// COLORES CONSOLA
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";

	//Metodo para convertir un color en formato hexadecimal a un color java
	public static Color convertirColorJava(String color) {
		
		//Primero convertimos el color hexadecimal a decimal
		 int colorDecimal = Integer.parseInt(color, 16);
		 
		 //Dicho color decimal lo pasamos a String
		 String colorDecimalString = String.valueOf(colorDecimal);
		 
		 //Utilizamos el medoto decode e introducimos el string del color para devolver un objeto Color de java
		Color colorJava = Color.decode(colorDecimalString);
		
		//Por ultimo este metodo devolvera el objeto Color
		return colorJava;
		
	}
	
	//Metodo para aniadir ToolTips a los componentes que yo quiera
	public static void toolTip(JComponent componente, String mensaje) {
		
		//Le aniado el ToolTip (que sera el string que yo le paso al metodo por parametro) al componente, (que tambien sera el que le paso al metodo por 
		//parametro) 
		componente.setToolTipText("<html><p>" + mensaje + "</p></html>");

		
	}
	
	
}
