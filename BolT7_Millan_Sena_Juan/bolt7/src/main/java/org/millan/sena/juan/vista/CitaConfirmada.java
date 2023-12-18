package org.millan.sena.juan.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.millan.sena.juan.controlador.ControladorCitaConfirmada;

import utiles.Utiles;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class CitaConfirmada extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JLabel lblInformacionUsuario;
	public JLabel lblFecha;
	private JButton btnCancelar;
	private JButton btnAudio;
	public PrimeraVentana primeraVentana;
	private ControladorCitaConfirmada controlador= new ControladorCitaConfirmada(this);

	
	/**
	 * Create the dialog.
	 */
	public CitaConfirmada() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CitaConfirmada.class.getResource("/org/millan/sena/juan/imagenes/iconoAplicacion.png")));
		setBounds(100, 100, 458, 300);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
		contentPanel.setBounds(0, 0, 442, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
	
		//jlabel lblInformacionUsuario que muestra la informacion del paciente
		lblInformacionUsuario = new JLabel("");
		lblInformacionUsuario.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		lblInformacionUsuario.setBounds(20, 64, 414, 42);
		contentPanel.add(lblInformacionUsuario);
		{
			//jlabel lblFecha que muestra la fecha de la cita
			//tanto la informacion del usuario como la fecha de la cita nos la pasa la ventana anterior, por eso estas etiquetas estan publicas
			lblFecha = new JLabel("");
			lblFecha.setBackground(new Color(222, 239, 232));
			lblFecha.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
			lblFecha.setBounds(10, 11, 326, 42);
			contentPanel.add(lblFecha);
		}
		{
			//jlabel lblConfirmacion que nos muestra un texto indicando si queremos confirmar o cancelar la cita
			JLabel lblConfirmacion = new JLabel("¿Desea confirmar la cita o cancelarla? (Si la cancelas desharas los cambios)");
			lblConfirmacion.setForeground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
			lblConfirmacion.setBounds(0, 132, 442, 23);
			contentPanel.add(lblConfirmacion);
		}
		//jbutton btnConfirmar, este boton confirmara la cita y cerrara el programa
		JButton btnConfirmar = new JButton("");
		btnConfirmar.setBackground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
		btnConfirmar.setForeground(new Color(0, 0, 0));
		btnConfirmar.setBounds(10, 179, 93, 71);
		contentPanel.add(btnConfirmar);
		btnConfirmar.setIcon(new ImageIcon(CitaConfirmada.class.getResource("/org/millan/sena/juan/imagenes/botonOk.png")));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				confirmarCita();
				
			}
		});
		getRootPane().setDefaultButton(btnConfirmar);
		{
			//jbutton btnCancelar, este boton lo que hace es cancelar la cita y volver a la ventana anterior
			btnCancelar = new JButton("");
			btnCancelar.setBackground(Utiles.convertirColorJava(Utiles.COLOR_CLARO));
			btnCancelar.setBounds(331, 179, 101, 71);
			btnCancelar.setIcon(new ImageIcon(CitaConfirmada.class.getResource("/org/millan/sena/juan/imagenes/botonCancelar.png")));
			contentPanel.add(btnCancelar);
			{
				btnAudio = new JButton("");
				btnAudio.setBackground(Utiles.convertirColorJava(Utiles.COLOR_AZUL));
				btnAudio.setIcon(new ImageIcon(CitaConfirmada.class.getResource("/org/millan/sena/juan/imagenes/imagenAudio.png")));
				btnAudio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//Almacenamos el archivo de audio en una variable File
						File archivoAudio = new File("src/main/java/org/millan/sena/juan/audio/audioVentanaConfirmarCita.wav");
						
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
				btnAudio.setBounds(359, 11, 61, 42);
				contentPanel.add(btnAudio);
			}
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

					cancelarCita();
					
				}
			});
		}
		
		
		//Aniado ToolTips mediante el metodo de la clase Utiles
		Utiles.toolTip(btnConfirmar, "Confirmar cita");
		Utiles.toolTip(btnCancelar, "Cancelar cita (se desharán los cambios)");
		Utiles.toolTip(btnAudio, "Reproducir audio que explica el funcionamiento de esta ventana");
		
		
	}
	
	public void confirmarCita() {
		

		controlador.confirmarCita();
		
	}
	
	public void cancelarCita() {
		
		controlador.cancelarCita();
		
		
	}
	
}
