package acts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Panel;

public class Vista extends JFrame {

	private JPanel QDAS;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtNacimiento;
	private JTextField txtPublicacion;
	private JTextField txtEditorial;
	private JTextField txtPaginas;
	private JButton btnAnyadir;
	private JTextField txtUsuario;
	private JTextField txtContrasenya;
	private JTextField txtNomColeccio;
	private JButton btnLogin;
	private JScrollPane scrollPane;
	private JLabel lblRandom1;
	private JLabel	lblTitulo;
	private JLabel lblAutor;
	private JLabel lblNacimiento;
	private JLabel lblPublicacion;
	private JLabel lblEditorial;
	private JLabel lblPaginas;
	private JLabel lblUsuario;
	private JLabel lblContrasenya;
	private JLabel lblConjuntoLogin;
	private JButton btnMostrarContingut;
	private JTextArea txtContenido;
	private JButton btnEsborrarConexio;
	
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

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 663);
		QDAS = new JPanel();
		QDAS.setBackground(new Color(0, 128, 192));
		QDAS.setForeground(new Color(0, 128, 192));
		QDAS.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(QDAS);
		QDAS.setLayout(null);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(96, 225, 86, 20);
		QDAS.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(96, 256, 86, 20);
		txtAutor.setColumns(10);
		QDAS.add(txtAutor);
		
		txtNacimiento = new JTextField();
		txtNacimiento.setBounds(96, 287, 86, 20);
		txtNacimiento.setColumns(10);
		QDAS.add(txtNacimiento);
		
		txtPublicacion = new JTextField();
		txtPublicacion.setBounds(96, 318, 86, 20);
		txtPublicacion.setColumns(10);
		QDAS.add(txtPublicacion);
		
		txtEditorial = new JTextField();
		txtEditorial.setBounds(96, 349, 86, 20);
		txtEditorial.setColumns(10);
		QDAS.add(txtEditorial);
		
		txtPaginas = new JTextField();
		txtPaginas.setBounds(96, 380, 86, 20);
		txtPaginas.setColumns(10);
		QDAS.add(txtPaginas);
		
		 btnAnyadir = new JButton("Anyadir");
		 btnAnyadir.setBounds(93, 411, 89, 23);
		QDAS.add(btnAnyadir);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(239, 184, 476, 282);
		QDAS.add(scrollPane);
		
		 lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(39, 228, 46, 14);
		QDAS.add(lblTitulo);
		
		 lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(39, 259, 46, 14);
		QDAS.add(lblAutor);
		
		 lblNacimiento = new JLabel("Fecha Nac:");
		lblNacimiento.setBounds(10, 290, 86, 14);
		QDAS.add(lblNacimiento);
		
		 lblPublicacion = new JLabel("Fecha Pub:");
		lblPublicacion.setBounds(10, 321, 86, 14);
		QDAS.add(lblPublicacion);
		
		 lblEditorial = new JLabel("Editorial:");
		lblEditorial.setBounds(29, 352, 57, 14);
		QDAS.add(lblEditorial);
		
		 lblPaginas = new JLabel("Paginas:");
		lblPaginas.setBounds(29, 383, 57, 14);
		QDAS.add(lblPaginas);
		
		 lblRandom1 = new JLabel("INSERCIO DE LLIBRE");
		lblRandom1.setBounds(10, 166, 182, 37);
		lblRandom1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRandom1.setBackground(new Color(128, 128, 192));
		QDAS.add(lblRandom1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(87, 66, 86, 20);
		txtUsuario.setColumns(10);
		QDAS.add(txtUsuario);
		
		txtContrasenya = new JTextField();
		txtContrasenya.setBounds(87, 109, 86, 20);
		txtContrasenya.setColumns(10);
		QDAS.add(txtContrasenya);
		
		 lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(31, 69, 46, 14);
		QDAS.add(lblUsuario);
		
		 lblContrasenya = new JLabel("Contrasenya:");
		lblContrasenya.setBounds(10, 112, 71, 14);
		QDAS.add(lblContrasenya);
		
		 lblConjuntoLogin = new JLabel("LOGIN");
		lblConjuntoLogin.setBounds(66, 18, 86, 37);
		lblConjuntoLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConjuntoLogin.setBackground(new Color(128, 128, 192));
		QDAS.add(lblConjuntoLogin);
		
		 btnMostrarContingut = new JButton("MOSTRAR");
		btnMostrarContingut.setBounds(239, 477, 103, 37);
		QDAS.add(btnMostrarContingut);
		
		 txtContenido = new JTextArea();
		txtContenido.setBounds(239, 186, 474, 280);
		QDAS.add(txtContenido);
		
		 btnEsborrarConexio = new JButton("BORRAR COLEXIO");
		btnEsborrarConexio.setForeground(new Color(255, 0, 0));
		btnEsborrarConexio.setBackground(new Color(255, 128, 128));
		btnEsborrarConexio.setBounds(112, 559, 140, 37);
		QDAS.add(btnEsborrarConexio);
		
		txtNomColeccio = new JTextField();
		txtNomColeccio.setColumns(10);
		txtNomColeccio.setBounds(10, 567, 86, 20);
		QDAS.add(txtNomColeccio);
		
		 btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(183, 79, 103, 37);
		QDAS.add(btnLogin);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(780, 184, 162, 282);
		QDAS.add(panel);
		setVisible(true);
	}

	public JPanel getQDAS() {
		return QDAS;
	}

	public void setQDAS(JPanel qDAS) {
		QDAS = qDAS;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	public JTextField getTxtNacimiento() {
		return txtNacimiento;
	}

	public void setTxtNacimiento(JTextField txtNacimiento) {
		this.txtNacimiento = txtNacimiento;
	}

	public JTextField getTxtPublicacion() {
		return txtPublicacion;
	}

	public void setTxtPublicacion(JTextField txtPublicacion) {
		this.txtPublicacion = txtPublicacion;
	}

	public JTextField getTxtEditorial() {
		return txtEditorial;
	}

	public void setTxtEditorial(JTextField txtEditorial) {
		this.txtEditorial = txtEditorial;
	}

	public JTextField getTxtPaginas() {
		return txtPaginas;
	}

	public void setTxtPaginas(JTextField txtPaginas) {
		this.txtPaginas = txtPaginas;
	}

	public JButton getBtnAnyadir() {
		return btnAnyadir;
	}

	public void setBtnAnyadir(JButton btnAnyadir) {
		this.btnAnyadir = btnAnyadir;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JTextField getTxtContrasenya() {
		return txtContrasenya;
	}

	public void setTxtContrasenya(JTextField txtContrasenya) {
		this.txtContrasenya = txtContrasenya;
	}

	public JTextField getTxtNomColeccio() {
		return txtNomColeccio;
	}

	public void setTxtNomColeccio(JTextField txtNomColeccio) {
		this.txtNomColeccio = txtNomColeccio;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JLabel getLblRandom1() {
		return lblRandom1;
	}

	public void setLblRandom1(JLabel lblRandom1) {
		this.lblRandom1 = lblRandom1;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblAutor() {
		return lblAutor;
	}

	public void setLblAutor(JLabel lblAutor) {
		this.lblAutor = lblAutor;
	}

	public JLabel getLblNacimiento() {
		return lblNacimiento;
	}

	public void setLblNacimiento(JLabel lblNacimiento) {
		this.lblNacimiento = lblNacimiento;
	}

	public JLabel getLblPublicacion() {
		return lblPublicacion;
	}

	public void setLblPublicacion(JLabel lblPublicacion) {
		this.lblPublicacion = lblPublicacion;
	}

	public JLabel getLblEditorial() {
		return lblEditorial;
	}

	public void setLblEditorial(JLabel lblEditorial) {
		this.lblEditorial = lblEditorial;
	}

	public JLabel getLblPaginas() {
		return lblPaginas;
	}

	public void setLblPaginas(JLabel lblPaginas) {
		this.lblPaginas = lblPaginas;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public JLabel getLblContrasenya() {
		return lblContrasenya;
	}

	public void setLblContrasenya(JLabel lblContrasenya) {
		this.lblContrasenya = lblContrasenya;
	}

	public JLabel getLblConjuntoLogin() {
		return lblConjuntoLogin;
	}

	public void setLblConjuntoLogin(JLabel lblConjuntoLogin) {
		this.lblConjuntoLogin = lblConjuntoLogin;
	}

	public JButton getBtnMostrarContingut() {
		return btnMostrarContingut;
	}

	public void setBtnMostrarContingut(JButton btnMostrarContingut) {
		this.btnMostrarContingut = btnMostrarContingut;
	}

	public JTextArea getTxtContenido() {
		return txtContenido;
	}

	public void setTxtContenido(JTextArea txtContenido) {
		this.txtContenido = txtContenido;
	}

	public JButton getBtnEsborrarConexio() {
		return btnEsborrarConexio;
	}

	public void setBtnEsborrarConexio(JButton btnEsborrarConexio) {
		this.btnEsborrarConexio = btnEsborrarConexio;
	}
}
