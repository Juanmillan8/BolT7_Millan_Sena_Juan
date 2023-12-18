package org.millan.sena.juan.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.millan.sena.juan.controlador.ControladorIntroducirDatos;

import utiles.Utiles;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class IntroducirDatos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField tfTarjeta;
	public JTextField tfMotivo;
	private ButtonGroup bg = new ButtonGroup();
	public JLabel lblError;
	private JButton btnAceptar;
	public JRadioButton rbTest;
	public JRadioButton rbMatrona;
	public JRadioButton rbEnfermeria;
	public PrimeraVentana primeraVentana;
	private ControladorIntroducirDatos controlador = new ControladorIntroducirDatos(this);

	/**
	 * Create the dialog.
	 */
	public IntroducirDatos() {
		setBounds(100, 100, 507, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		//jtextfield tfTarjeta usada para introducir el numero de tarjeta sanitaria del usuario
		tfTarjeta = new JTextField();
		tfTarjeta.setBounds(10, 71, 202, 25);
		contentPanel.add(tfTarjeta);
		tfTarjeta.setColumns(10);
		
		//jradiobutton rbMatrona
		rbMatrona = new JRadioButton("Matrona");
		rbMatrona.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		rbMatrona.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		rbMatrona.setBounds(376, 92, 109, 23);
		contentPanel.add(rbMatrona);
		
		//jradiobutton rbTest
		rbTest = new JRadioButton("Test antigenos");
		rbTest.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		rbTest.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		rbTest.setBounds(376, 118, 109, 23);
		contentPanel.add(rbTest);
		
		//jradiobutton rbEnfermeria
		rbEnfermeria = new JRadioButton("Enfermería");
		rbEnfermeria.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		rbEnfermeria.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		rbEnfermeria.setBounds(376, 144, 109, 23);
		contentPanel.add(rbEnfermeria);
		
		//buttongroup en el que introduciremos los radiobutton vistos anteriormente
		bg.add(rbMatrona);
		bg.add(rbTest);
		bg.add(rbEnfermeria);
		
		
		//jlabel lblTarjeta, aqui indicamos al usuario donde debe insertar el numero de su tarjeta sanitaria
		JLabel lblTarjeta = new JLabel("Nº de tarjeta sanitaria:");
		lblTarjeta.setBackground(new Color(255, 255, 255));
		lblTarjeta.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		lblTarjeta.setBounds(10, 46, 156, 14);
		contentPanel.add(lblTarjeta);
		
		//jtextfield tfMotivo, en este campo de texto el usuario debe insertar el motivo de su cita
		tfMotivo = new JTextField();
		tfMotivo.setColumns(10);
		tfMotivo.setBounds(10, 161, 202, 25);
		contentPanel.add(tfMotivo);
		
		//jlabel lblMotivo, aqui indicamos al usuario donde debe insertar el motivo de su consulta
		JLabel lblMotivo = new JLabel("Motivo de la consulta:");
		lblMotivo.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		lblMotivo.setBounds(10, 136, 156, 14);
		contentPanel.add(lblMotivo);
		
		//jlabel lblProfesional, aqui indicamos al usuario el profesional a elejir para su consulta
		JLabel lblProfesional = new JLabel("Profesional");
		lblProfesional.setBackground(new Color(72, 139, 118));
		lblProfesional.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		lblProfesional.setBounds(379, 71, 86, 14);
		contentPanel.add(lblProfesional);
		
		
			//jpanel buttonPane, aqui es donde ira el boton para confirmar todos los datos
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
			buttonPane.setBounds(0, 228, 491, 33);
			contentPanel.add(buttonPane);
			{
				//jbutton btnAceptar
				btnAceptar = new JButton("OK");
				btnAceptar.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
				btnAceptar.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
				btnAceptar.setBounds(405, 5, 76, 23);
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					confirmarDatos();
						
						
					}
				});
				buttonPane.setLayout(null);
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			
			//jlabel lblError, que al principio estara invisible asta que ocurra algun error, como por ejemplo hacer click en el boton btnAceptar sin haber
			//insertado datos
			lblError = new JLabel("");
			lblError.setBounds(106, 197, 313, 25);
			contentPanel.add(lblError);
			lblError.setForeground(new Color(255, 0, 0));
			lblError.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JButton btnAudio = new JButton("");
			btnAudio.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
			btnAudio.setIcon(new ImageIcon(IntroducirDatos.class.getResource("/org/millan/sena/juan/imagenes/imagenAudio.png")));
			btnAudio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Almacenamos el archivo de audio en una variable File
					File archivoAudio = new File("src/main/java/org/millan/sena/juan/audio/audioIntroducirDatos.wav");
					
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
			btnAudio.setBounds(411, 11, 54, 42);
			contentPanel.add(btnAudio);
			
			//Aniado ToolTips mediante el metodo de la clase Utiles
			Utiles.toolTip(tfTarjeta, "Introduce tu numero de tarjeta sanitaria");
			Utiles.toolTip(rbMatrona, "Seleccione una de las opciones");
			Utiles.toolTip(rbTest, "Seleccione una de las opciones");
			Utiles.toolTip(rbEnfermeria, "Seleccione una de las opciones");
			Utiles.toolTip(tfMotivo, "Explica el motivo o problema por el que desea realizar la consulta");
			Utiles.toolTip(btnAceptar, "Guarda los datos de la cita");
			Utiles.toolTip(btnAudio, "Reproducir audio que explica el funcionamiento de esta ventana");
			
			
		}
	
	public void confirmarDatos() {
		
		controlador.introducirDatos();
		
	}
	
	
	}

