package vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class PrimeraVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblUsuario;
	public String informacion;
	

	/**
	 * Create the frame.
	 */
	public PrimeraVentana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrimeraVentana.class.getResource("/imagenes/iconoAplicacion.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 369);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Calendario que usaremos para elegir el dia de la cita
		JCalendar Calendario = new JCalendar();
		Calendario.getDayChooser().getDayPanel().setToolTipText("Indica el dia de tu cita");
		Calendario.getMonthChooser().getSpinner().setBackground(new Color(255, 255, 255));
		Calendario.getYearChooser().getSpinner().setBackground(new Color(255, 255, 255));
		Calendario.setWeekOfYearVisible(false);
		Calendario.setTodayButtonVisible(true);
		Calendario.setDecorationBackgroundVisible(false);
		Calendario.getDayChooser().setBackground(new Color(255, 255, 255));
		Calendario.getDayChooser().setDecorationBackgroundVisible(false);
		Calendario.getDayChooser().getDayPanel().setForeground(new Color(255, 255, 255));
		Calendario.setDecorationBackgroundColor(new Color(255, 255, 255));
		Calendario.getDayChooser().setDecorationBackgroundColor(new Color(255, 255, 255));
		Calendario.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		Calendario.getYearChooser().setStartYear(2023);
		Calendario.getYearChooser().setMinimum(2023);
		Calendario.setBounds(109, 113, 226, 138);
		contentPane.add(Calendario);
		
		//jlabel lblElegirDia que nos mostrara un texto indicando que debemos elegir un dia del calendario
		JLabel lblElegirDia = new JLabel("Elija el dia de tu cita");
		lblElegirDia.setForeground(new Color(0, 0, 0));
		lblElegirDia.setBounds(160, 78, 124, 23);
		contentPane.add(lblElegirDia);
		
		//jlabel lblError, que nos mostrara un mensaje con los posibles errores que pueden ocurrir en esta ventana
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(120, 296, 260, 23);
		contentPane.add(lblError);
		
		//jbutton btnEstablecerCita, este boton lo usaremos para guardar la configuracion de la cita y pasar a la ventana de confirmacion
		JButton btnEstablecerCita = new JButton("Establecer cita");
		btnEstablecerCita.setToolTipText("Confirma los datos de la cita");
		btnEstablecerCita.setForeground(new Color(255, 255, 255));
		btnEstablecerCita.setBackground(new Color(51, 153, 153));
		btnEstablecerCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//aqui lo que hago es recoger la fecha actual y guardarla en una variable tipo Date, esto lo hago para comparar la fecha de hoy con la 
				//recogida en el jcalendar
				Date today = new Date();
				
				//Para que dicho boton sea funcional, primero debemos de asegurarnos de que el String informacion tenga contenido osea, tenemos 
				//que haber introducido datos del usuario y de la cita y tambien nos aseguramos de que para la cita hemos elegido una fecha de 
				//como minimo para el dia siguiente
				if (informacion!=null && Calendario.getDate().after(today)) {
					
					
					//Mensaje de prueba unitaria
					System.out.println("\u001B[32mLa fecha de la cita se ha configurado correctamente\u001B[0m");
					  
					//En cambio si ya hemos introducido todos los datos de la cita, el String informacion tiene contenido y la fecha
					//es para el dia siguiente como minimo haremos lo siguiente:
					//recogeremos la fecha de la cita en un string para pasarlo al lblFecha del jdialog CitaConfirmada y mostrarlo
					//en dicho jdialog, para ello la etiqueta lblFecha en el jdialog CitaConfirmada tiene que ser publica
					//lo mismo hacemos con el string informacion, se lo pasamos al lblInformacionUsuario para mostrarlo en el jdialog
					//luego hacemos visible el jdialog y cerramos este
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String fecha = sdf.format(Calendario.getDate());
					CitaConfirmada cf = new CitaConfirmada();
					cf.setLocationRelativeTo(null);
					cf.setVisible(true);
					cf.lblFecha.setText("Para el dia " + fecha);
					cf.lblInformacionUsuario.setText(informacion);
					
					
					dispose();
				
				//De lo contrario, si el string informacion esta a nulo significa que no nos hemos dirijido todavia a la ventana IntroducirDatos y por 
				//lo tanto no hemos introducido los datos, por lo que mostramos un mensaje de error
				}else if (informacion==null) {
					
					
					lblError.setText("<html>Error, primero debes rellenar los datos</html>");
				
					//Mensaje de prueba unitaria
					System.err.println("Error, no se han reyenado los datos");
					
				//en el caso de que la fecha que he elegido en el calendario sea anterior a la fecha actual mostramos otro mensaje de error
				}else if (Calendario.getDate().before(today)) {
					
					lblError.setText("<html>Error, la cita debe ser minimo para maniana</html>");
					
					//Mensaje de prueba unitaria
					System.err.println("Error, la cita se ha configurado para antes de maniana");
				}
				
				
			
				
			}
		});
		btnEstablecerCita.setBounds(282, 262, 142, 23);
		contentPane.add(btnEstablecerCita);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(434, 66, 144, 264);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//Etiqueta que muestra la imagen del banner
		JLabel lblImagenBanner = new JLabel("");
		lblImagenBanner.setIcon(new ImageIcon(PrimeraVentana.class.getResource("/imagenes/imagenBanner.png")));
		lblImagenBanner.setBounds(0, 0, 128, 141);
		panel_1.add(lblImagenBanner);
		
		//Etiqueta que muestra el texto del banner
		JLabel lblBanner = new JLabel("<html>¡Visita nuestra página Web y registrate para poder obtener un descuento en los productos que te recetamos!</html>");
		lblBanner.setFont(new Font("MV Boli", Font.BOLD, 11));
		lblBanner.setBounds(16, 141, 128, 123);
		panel_1.add(lblBanner);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, 0, 578, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//jlabel lblTextoHeader que mostrara un texto al principio de la ventana
		JLabel lblTextoHeader = new JLabel("<html>Bienvenid@ a Cita Médica de Salud Responde, una aplicación indicada para la solicitud de cita previa en el Servicio Andaluz de Salud.</html>");
		lblTextoHeader.setForeground(new Color(255, 255, 255));
		lblTextoHeader.setBounds(158, 0, 375, 67);
		panel.add(lblTextoHeader);
		
		//Etiqueta lblUsuario que se usara para mostrar el nombre de usuario que he escrito en la ventana del login, por eso esta etiqueta esta publica
		lblUsuario = new JLabel("");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(10, 11, 183, 45);
		panel.add(lblUsuario);
		
		//Boton IntroducirDatos
		JButton btnIntroducirDatos = new JButton("Introducir datos");
		btnIntroducirDatos.setToolTipText("Introduce los datos de tu cita");
		btnIntroducirDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Este boton abrira la ventana IntroducirDatos para insertar datos del cliente que quiere realizar la cita y demas
				IntroducirDatos datos = new IntroducirDatos();
				datos.setLocationRelativeTo(null);
				datos.setVisible(true);
				dispose();
				
				
				
			}
		});
		btnIntroducirDatos.setForeground(Color.WHITE);
		btnIntroducirDatos.setBackground(new Color(51, 153, 153));
		btnIntroducirDatos.setBounds(10, 262, 142, 23);
		contentPane.add(btnIntroducirDatos);
		
		
		
	
	}
}
