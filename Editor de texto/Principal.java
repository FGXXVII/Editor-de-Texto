import java.awt.event.*;
import java.rmi.MarshalException;

import javax.swing.*;

public class Principal {
	public static void main(String[] args) {

		Marco marco = new Marco();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

// Marco de la app
class Marco extends JFrame {
	public Marco() {
		// donde va a estar la ventana
		setBounds(300, 300, 300, 300);
		setTitle("Texto rapido");

		// Panel

		// Panel p = new Panel();
		// add(p);

		add(new Panel());
	}

}

// Panel
class Panel extends JPanel {
	public Panel() {

		// JLabel etiqueta = new JLabel("");
		// add(etiqueta);

		// menu//

		JPanel panelMenu = new JPanel();
		menu = new JMenuBar();

		archivo = new JMenu("Archivo");
		editar = new JMenu("Editar");
		seleccion = new JMenu("Seleccion");
		ver = new JMenu("Ver");
		apariencia = new JMenu("Apariencia");

		menu.add(archivo);
		menu.add(editar);
		menu.add(seleccion);
		menu.add(ver);

		// --------------Elemento del menu archivo --

		creaItem("Nuevo Archivo", "archivo", "nuevo");
		creaItem("Abrir Archivo", "archivo", "abrir");
		creaItem("Guardar", "archivo", "guardar");
		creaItem("Guardar Como", "archivo", "guardarComo");

		// -----------Elementos del menu Editar---------

		creaItem("Deshacer", "editar", "");
		creaItem("Rehacer", "editar", "");
		editar.addSeparator();
		creaItem("Cortar", "editar", "");
		creaItem("Copiar", "editar", "");
		creaItem("Pegar", "editar", "");

		// ------------ Elementos del menu Seleccion----

		creaItem("Seleccionar Todo", "seleccion", "");

		// --------------Elementos del menu ver ------

		creaItem("Numeracion", "Ver", "");
		ver.add(apariencia);
		creaItem("Normal", "apariencia", "");
		creaItem("Oscuro", "apariencia", "");

		/*
		 * formas de agregar items al menu
		 * JMenuItem nuevo = new JMenuItem("Nuevo Archivo");
		 * JMenuItem abrir = new JMenuItem("Abrir");
		 * JMenuItem guardar = new JMenuItem("Guardar");
		 * JMenuItem guardarC = new JMenuItem("Guardar Como");
		 * 
		 * archivo.add(nuevo);
		 * archivo.add(abrir);
		 * archivo.add(guardar);
		 * archivo.add(guardarC);
		 * 
		 */

		panelMenu.add(menu);

		// area de texto//
		tPane = new JTabbedPane();

		// creaPanel();//llamando al metodo

		add(panelMenu);

		add(tPane);

	}

	public void creaItem(String rotulo, String menu, String accion) {
		elementoItem = new JMenuItem(rotulo);

		if (menu.equals("archivo")) {
			archivo.add(elementoItem);
			if (accion.equals("nuevo")) {
				elementoItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						creaPanel();
					}
				});
			}
		} else if (menu.equals("editar")) {
			editar.add(elementoItem);
		} else if (menu.equals("seleccion")) {
			ver.add(elementoItem);
		} else if (menu.equals("ver")) {
			ver.add(elementoItem);
		} else if (menu.equals("apariencia")) {
			apariencia.add(elementoItem);

		}
	}

	// ----------- Funcion crear panel ----------

	public void creaPanel() {
		ventana = new JPanel();

		areaTexto = new JTextPane();

		ventana.add(areaTexto);

		tPane.addTab("New File ", ventana);
	}

	// panel de escritura
	private JTabbedPane tPane;// Panel principal
	private JPanel ventana;// Pestañas
	private JTextPane areaTexto; // area de texto
	private JMenuBar menu;
	private JMenu archivo, editar, seleccion, ver, apariencia;
	private JMenuItem elementoItem;

}
