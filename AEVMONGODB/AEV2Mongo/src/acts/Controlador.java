package acts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Controlador {
	private Vista vista;
	private Modelo model;
	private int contadorLibros = 15;

	public Controlador(Vista vista, Modelo mode) {
		this.vista = vista;
		this.model = mode;
		initEventHandler();
	}

	String rutaImagen = "";

	private void initEventHandler() {

		ActionListener anyadirLlibre = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser();
				j.showOpenDialog(j);

				String imagen = j.getSelectedFile().getPath();

				rutaImagen = imagen;

				try {
					model.iniciarConexion();

					String tituloString = vista.getTxtTitulo().getText();
					String autor = vista.getTxtAutor().getText();
					int nacimiento = Integer.parseInt(vista.getTxtNacimiento().getText());
					int publicacion = Integer.parseInt(vista.getTxtPublicacion().getText());
					String editorial = vista.getTxtEditorial().getText();
					int paginas = Integer.parseInt(vista.getTxtPaginas().getText());
					String imagenCodificada = Modelo.transformarImagen(rutaImagen);

					Modelo.anyadirLlibre(contadorLibros, tituloString, autor, nacimiento, publicacion, editorial,
							paginas, imagenCodificada);

					contadorLibros++;

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		};
		vista.getBtnAnyadir().addActionListener(anyadirLlibre);

		ActionListener iniciarSesion = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					model.iniciarConexion();

					String usuari = vista.getTxtUsuario().getText();

					String con1 = vista.getTxtContrasenya().getText();

					if (model.iniciarSesio(usuari, con1)) {

						JOptionPane.showMessageDialog(null, "SESIO CORRECTA");
					} else {
						JOptionPane.showMessageDialog(null, "CONEXIO ERRRONEA");
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		vista.getBtnLogin().addActionListener(iniciarSesion);

		ActionListener mostrarTodo = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					model.iniciarConexion();
					String contenido = model.mostrarCamposLlibres();
					vista.getTxtContenido().setText(contenido);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};

		vista.getBtnMostrarContingut().addActionListener(mostrarTodo);

		ActionListener eliminarColeccio = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String nombreColeccionString = vista.getTxtNomColeccio().getText();

				Modelo.borrarColeccio(nombreColeccionString);
			}
		};
		vista.getBtnEsborrarConexio().addActionListener(eliminarColeccio);

		ActionListener realitzarConsulta = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					model.iniciarConexion();

					String tipoFiltro = vista.getCbTipoFiltro().getSelectedItem().toString();
					System.out.println(tipoFiltro);

					String tipoCampo = vista.getCbTipoCampo().getSelectedItem().toString();
					System.out.println(tipoCampo);
					String valorAplicar = vista.getTxtValorAaplicar().getText();
					System.out.println(valorAplicar);

					
					if (tipoFiltro.equals("")) {
						String txt=model.mostrarAmbFiltres(tipoCampo, tipoFiltro, valorAplicar);
						vista.getTxtContenido().setText(txt);
						System.out.println("ye");
					} else if(tipoFiltro.equals("eq")) {
						String txt=model.mostrarAmbFiltres(tipoCampo, tipoFiltro, valorAplicar);
						vista.getTxtContenido().setText(txt);
						System.out.println("ye");
					}else if(tipoFiltro.equals("gte")) {
						String txt=model.mostrarAmbFiltres(tipoCampo, tipoFiltro, valorAplicar);
						vista.getTxtContenido().setText(txt);
						System.out.println("ye");
					}else {
						String txt=model.mostrarAmbFiltres(tipoCampo, tipoFiltro, valorAplicar);
						vista.getTxtContenido().setText(txt);
						System.out.println("ye");
					}
					

					

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};

		vista.getBtnHacerConsulta().addActionListener(realitzarConsulta);

	}

}
