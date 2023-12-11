package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class CitaConfirmada extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JLabel lblInformacionUsuario;
	public JLabel lblFecha;
	
	

	
	/**
	 * Create the dialog.
	 */
	public CitaConfirmada() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CitaConfirmada.class.getResource("/imagenes/iconoAplicacion.png")));
		setBounds(100, 100, 458, 300);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBounds(0, 0, 442, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
	
		//jlabel lblInformacionUsuario que muestra la informacion del paciente
		lblInformacionUsuario = new JLabel("");
		lblInformacionUsuario.setForeground(new Color(0, 0, 0));
		lblInformacionUsuario.setBounds(10, 79, 414, 42);
		contentPanel.add(lblInformacionUsuario);
		{
			//jlabel lblFecha que muestra la fecha de la cita
			//tanto la informacion del usuario como la fecha de la cita nos la pasa la ventana anterior, por eso estas etiquetas estan publicas
			lblFecha = new JLabel("");
			lblFecha.setForeground(new Color(0, 0, 0));
			lblFecha.setBounds(10, 11, 414, 42);
			contentPanel.add(lblFecha);
		}
		{
			//jlabel lblConfirmacion que nos muestra un texto indicando si queremos confirmar o cancelar la cita
			JLabel lblConfirmacion = new JLabel("¿Desea confirmar la cita o cancelarla? (Si la cancelas desharas los cambios)");
			lblConfirmacion.setForeground(new Color(0, 0, 0));
			lblConfirmacion.setBounds(0, 132, 442, 23);
			contentPanel.add(lblConfirmacion);
		}
		//jbutton btnConfirmar, este boton confirmara la cita y cerrara el programa
		JButton btnConfirmar = new JButton("");
		btnConfirmar.setToolTipText("Confirmar cita");
		btnConfirmar.setBackground(new Color(51, 153, 153));
		btnConfirmar.setForeground(new Color(0, 0, 0));
		btnConfirmar.setBounds(10, 179, 93, 71);
		contentPanel.add(btnConfirmar);
		btnConfirmar.setIcon(new ImageIcon(CitaConfirmada.class.getResource("/imagenes/botonOk.png")));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		getRootPane().setDefaultButton(btnConfirmar);
		{
			//jbutton btnCancelar, este boton lo que hace es cancelar la cita y volver a la ventana anterior
			JButton btnCancelar = new JButton("");
			btnCancelar.setToolTipText("Cancelar cita (se desharán los cambios)");
			btnCancelar.setBackground(new Color(51, 153, 153));
			btnCancelar.setBounds(331, 179, 101, 71);
			btnCancelar.setIcon(new ImageIcon(CitaConfirmada.class.getResource("/imagenes/botonCancelar.png")));
			contentPanel.add(btnCancelar);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					PrimeraVentana pm = new PrimeraVentana();
					pm.setLocationRelativeTo(null);
					pm.setVisible(true);
					dispose();
					
					
				}
			});
		}
	}
}