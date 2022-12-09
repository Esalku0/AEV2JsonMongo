package acts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtContrasenya;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	

	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPedirUsuario = new JLabel("USUARIO:");
		lblPedirUsuario.setBounds(21, 11, 75, 14);
		contentPane.add(lblPedirUsuario);
		
		JLabel lblPedirContrasenya = new JLabel("CONTRASENYA:");
		lblPedirContrasenya.setBounds(21, 52, 86, 14);
		contentPane.add(lblPedirContrasenya);
		
		txtContrasenya = new JTextField();
		txtContrasenya.setBounds(21, 67, 86, 20);
		contentPane.add(txtContrasenya);
		txtContrasenya.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(21, 25, 86, 20);
		contentPane.add(txtUsuario);
		
		JButton btnIniciarSesion = new JButton("Login");
		btnIniciarSesion.setBounds(122, 48, 99, 23);
		contentPane.add(btnIniciarSesion);
	}
}
