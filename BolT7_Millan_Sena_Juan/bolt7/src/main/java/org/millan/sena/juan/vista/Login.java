package org.millan.sena.juan.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.millan.sena.juan.controlador.ControladorLogin;

import utiles.Utiles;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JPasswordField;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	public JTextField tfUsuario;
	public JPasswordField pfContrasenia;
	public JLabel lbError;
	public PrimeraVentana primeraVentana;
	private ControladorLogin controlador = new ControladorLogin(this);

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/org/millan/sena/juan/imagenes/iconoAplicacion.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 366);
		contentPane = new JPanel();
		contentPane.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//textfield para insertar el usuario
		tfUsuario = new JTextField();
		tfUsuario.setBounds(38, 102, 235, 25);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		
		//jlabel usuario para el textfield usuario
		JLabel lbUsuario = new JLabel("Usuario");
		lbUsuario.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		lbUsuario.setBounds(38, 77, 46, 14);
		contentPane.add(lbUsuario);
		
		//jlabel contrasenia para el passwordField contrasenia
		JLabel lbContrasenia = new JLabel("Contrasenia");
		lbContrasenia.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		lbContrasenia.setBounds(38, 171, 112, 14);
		contentPane.add(lbContrasenia);
		
		//Etiqueta que al principio sera invisible, pero en caso de error a la hora de insertar las credenciales mostrara un mensaje
		lbError = new JLabel("");
		lbError.setForeground(Color.RED);
		lbError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbError.setBounds(10, 232, 313, 25);
		contentPane.add(lbError);
		
		//jlabel Login
		JLabel lbTitulo = new JLabel("Login");
		lbTitulo.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbTitulo.setBounds(38, 26, 82, 40);
		contentPane.add(lbTitulo);
		
		//Boton iniciar sesion
		JButton btnIniciarSesion = new JButton("");
		btnIniciarSesion.setIcon(new ImageIcon(Login.class.getResource("/org/millan/sena/juan/imagenes/iniciarSesionImagenBoton.png")));
		btnIniciarSesion.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		btnIniciarSesion.setForeground(new Color(255, 255, 255));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				iniciarSesion();
				
				
				
			}
		});
		btnIniciarSesion.setBounds(110, 268, 112, 48);
		contentPane.add(btnIniciarSesion);
		
		//PasswordField pfContrasenia donde insertare la contraseña de inicio de sesion
		pfContrasenia = new JPasswordField();
		pfContrasenia.setBounds(38, 196, 235, 25);
		contentPane.add(pfContrasenia);
		
		//Boton para reproducir el audio de ayuda
		JButton btnAudio = new JButton("");
		btnAudio.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		btnAudio.setIcon(new ImageIcon(Login.class.getResource("/org/millan/sena/juan/imagenes/imagenAudio.png")));
		btnAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Almacenamos el archivo de audio en una variable File
				File archivoAudio = new File("src/main/java/org/millan/sena/juan/audio/audioLogin.wav");
				
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
		btnAudio.setBounds(254, 11, 59, 40);
		contentPane.add(btnAudio);
		
		//Aniado ToolTips mediante el metodo de la clase Utiles
		Utiles.toolTip(tfUsuario, "Inserta el nombre de usuario");
		Utiles.toolTip(btnIniciarSesion, "Iniciar sesion");
		Utiles.toolTip(pfContrasenia, "Inserta la contraseña");
		Utiles.toolTip(btnAudio, "Reproducir audio que explica el funcionamiento de esta ventana");
		
	}
	
	public void iniciarSesion() {
		
		controlador.iniciarSesion();
		
	}
	
	
	
}
