package org.millan.sena.juan.vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import org.millan.sena.juan.controlador.ControladorPrimeraVentana;

import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;

import utiles.Utiles;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class PrimeraVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblUsuario;
	public String informacion;
	public JCalendar Calendario;
	public JLabel lblError;
	public IntroducirDatos datos;
	public CitaConfirmada citaConfirmada;
	public ControladorPrimeraVentana controlador = new ControladorPrimeraVentana(this);

	/**
	 * Create the frame.
	 */
	public PrimeraVentana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrimeraVentana.class.getResource("/org/millan/sena/juan/imagenes/iconoAplicacion.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 378);
		
		contentPane = new JPanel();
		contentPane.setBackground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Calendario que usaremos para elegir el dia de la cita
		Calendario = new JCalendar();
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
		
		//jlabel lblError, que nos mostrara un mensaje con los posibles errores que pueden ocurrir en esta ventana
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(109, 288, 260, 18);
		contentPane.add(lblError);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Utiles.convertirColorJava(Utiles.COLOR_VERDE));
		menuBar.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		setJMenuBar(menuBar);
		
		JMenu menuDatos = new JMenu("Datos");
		menuDatos.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		menuBar.add(menuDatos);
		
		
		
	    //JMenuItem menuItemInsertarDatos con el que podremos introducir los datos de nuestra cita  
		JMenuItem menuItemInsertarDatos = new JMenuItem("Introducir datos");
		menuItemInsertarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Llamamos al metodo insertarDatos
				insertarDatos();
				
			}
		});
		menuItemInsertarDatos.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		menuItemInsertarDatos.setBackground(Utiles.convertirColorJava(Utiles.COLOR_VERDE));
		menuDatos.add(menuItemInsertarDatos);
		
		//JMenu menuCita que contendra el JMenuItem menuItemEstablecerCita
		JMenu menuCita = new JMenu("Cita");
		menuCita.setForeground(new Color(222, 239, 232));
		menuBar.add(menuCita);
		
		//JMenuItem menuItemEstablecerCita con el que podremos establecer la cita
		JMenuItem menuItemEstablecerCita = new JMenuItem("Establecer cita");
		menuItemEstablecerCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Llamamos al metodo establecerCita
				establecerCita();
				
			}
		});
		menuItemEstablecerCita.setBackground(Utiles.convertirColorJava(Utiles.COLOR_VERDE));
		menuItemEstablecerCita.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		menuCita.add(menuItemEstablecerCita);

		
		
		//jlabel lblElegirDia que nos mostrara un texto indicando que debemos elegir un dia del calendario
		JLabel lblElegirDia = new JLabel("Elija el dia de tu cita");
		lblElegirDia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblElegirDia.setForeground(Utiles.convertirColorJava(Utiles.COLOR_VERDE));
		lblElegirDia.setBounds(160, 78, 124, 23);
		contentPane.add(lblElegirDia);
	
		
		//jbutton btnEstablecerCita, este boton lo usaremos para guardar la configuracion de la cita y pasar a la ventana de confirmacion
		JButton btnEstablecerCita = new JButton("Establecer cita");
		btnEstablecerCita.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		btnEstablecerCita.setBackground(Utiles.convertirColorJava(Utiles.COLOR_VERDE));
		btnEstablecerCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
							
				establecerCita();
			
				
			}
		});
		btnEstablecerCita.setBounds(282, 262, 142, 23);
		contentPane.add(btnEstablecerCita);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		panel_1.setBounds(434, 66, 144, 251);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//Etiqueta que muestra la imagen del banner
		JLabel lblImagenBanner = new JLabel("");
		lblImagenBanner.setIcon(new ImageIcon(PrimeraVentana.class.getResource("/org/millan/sena/juan/imagenes/imagenBanner.png")));
		lblImagenBanner.setBounds(10, 0, 111, 128);
		panel_1.add(lblImagenBanner);
		
		//Etiqueta que muestra el texto del banner
		JLabel lblBanner = new JLabel("<html>¡Visita nuestra página Web y registrate para poder obtener un descuento en los productos que te recetamos!</html>");
		lblBanner.setForeground(Utiles.convertirColorJava(Utiles.COLOR_VERDE));
		lblBanner.setFont(new Font("MV Boli", Font.BOLD, 11));
		lblBanner.setBounds(16, 139, 128, 112);
		panel_1.add(lblBanner);
		
		JPanel panel = new JPanel();
		panel.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		panel.setBounds(0, 0, 578, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//jlabel lblTextoHeader que mostrara un texto al principio de la ventana
		JLabel lblTextoHeader = new JLabel("<html>Bienvenid@ a Cita Médica de Salud Responde, una aplicación indicada para la solicitud de cita previa en el Servicio Andaluz de Salud.</html>");
		lblTextoHeader.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		lblTextoHeader.setBounds(185, 0, 287, 67);
		panel.add(lblTextoHeader);
		
		//Etiqueta lblUsuario que se usara para mostrar el nombre de usuario que he escrito en la ventana del login, por eso esta etiqueta esta publica
		lblUsuario = new JLabel("");
		lblUsuario.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		lblUsuario.setBounds(10, 11, 183, 45);
		panel.add(lblUsuario);
		
		//Boton para reproducir el audio de ayuda
		JButton btnAudio = new JButton("");
		btnAudio.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		btnAudio.setIcon(new ImageIcon(Login.class.getResource("/org/millan/sena/juan/imagenes/imagenAudio.png")));
		btnAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Almacenamos el archivo de audio en una variable File
				File archivoAudio = new File("src/main/java/org/millan/sena/juan/audio/audioPrimeraVentana.wav");
				
				try {
					//Almacenamos el audio en un objeto AudioInputStream
					AudioInputStream audio = AudioSystem.getAudioInputStream(archivoAudio);
					//Obtenemos un clip con el que podremos reproducir el sonido
					Clip clip = AudioSystem.getClip();
					//Abrimos el flujo de audio
					clip.open(audio);
					//Reproduzco el audio
					clip.start();
				
				} catch (Exception exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}

				
			}
		});
		
		btnAudio.setBounds(479, 12, 89, 44);
		panel.add(btnAudio);
		
		//Boton IntroducirDatos
		JButton btnIntroducirDatos = new JButton("Introducir datos");
		btnIntroducirDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				insertarDatos();
				
				
			}
		});
		btnIntroducirDatos.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		btnIntroducirDatos.setBackground(Utiles.convertirColorJava(Utiles.COLOR_VERDE));
		btnIntroducirDatos.setBounds(10, 262, 142, 23);
		contentPane.add(btnIntroducirDatos);
		
		//JPopupMenu menuContextual que contendra los JMenuItem menuItemCitaEstablecer y menuItemDatosInsertar y al que podremos acceder haciendo click derecho
		JPopupMenu menuContextual = new JPopupMenu();
		
		//JMenuItem menuItemCitaEstablecer con el que podremos establecer nuestra cita
		JMenuItem menuItemCitaEstablecer = new JMenuItem("Establecer cita");
		menuItemCitaEstablecer.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		menuItemCitaEstablecer.setBackground(Utiles.convertirColorJava(Utiles.COLOR_VERDE));
		menuItemCitaEstablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Llamamos al metodo establecerCita
				establecerCita();
				
				
			}
		});
		
		//JMenuItem menuItemDatosInsertar con el que podremos insertar los datos de la cita
		JMenuItem menuItemDatosInsertar = new JMenuItem("Introducir datos");
		menuItemDatosInsertar.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		menuItemDatosInsertar.setBackground(Utiles.convertirColorJava(Utiles.COLOR_VERDE));
		menuItemDatosInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Llamamos al metodo insertarDatos
				insertarDatos();
				
			}
		});

		menuContextual.add(menuItemCitaEstablecer);
		menuContextual.add(menuItemDatosInsertar);
		
		
		contentPane.setComponentPopupMenu(menuContextual);
		
		//Aniado ToolTips mediante el metodo de la clase Utiles
		Utiles.toolTip(Calendario.getDayChooser().getDayPanel(), "Indica el dia de tu cita");
		Utiles.toolTip(menuItemInsertarDatos, "Introduce los datos de tu cita");
		Utiles.toolTip(menuItemEstablecerCita, "Confirma los datos de la cita");
		Utiles.toolTip(btnEstablecerCita, "Confirma los datos de la cita");
		Utiles.toolTip(btnAudio, "Reproducir audio que explica el funcionamiento de esta ventana");
		Utiles.toolTip(btnIntroducirDatos, "Introduce los datos de tu cita");
		Utiles.toolTip(menuItemCitaEstablecer, "Confirma los datos de la cita");
		Utiles.toolTip(menuItemDatosInsertar, "Introduce los datos de tu cita");

		
	
	}
	
	public void insertarDatos() {
		
		controlador.insertarDatos();
		
	}
	
	public void establecerCita() {
		
		controlador.establecerCita();
		
		
	}
}