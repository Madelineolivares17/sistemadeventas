package proyecto;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Iterator;

import javax.swing.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class sucursalMenu implements Serializable {

	// botones
	JButton crear = new JButton();
	JButton carga = new JButton();
	JButton actualizar = new JButton();
	JButton eliminar = new JButton();
	JButton pdf = new JButton();
	int suma = 0;

	// Matriz
	// Object[][] sucursales = new Object[50][5];
	Object[][] sucursales;

	// tabla y complemento
	JTable tabla;
	JScrollPane spanel;

	private void botones() {
		crear.setText("Crear");
		crear.setBounds(520, 100, 130, 70);

		// Funcion crear
		ActionListener funcion_crear = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				crear();

			}
		};

		// Acci�n del evento
		crear.addActionListener(funcion_crear);

		carga.setText("carga masiva");
		carga.setBounds(700, 100, 130, 70);

		ActionListener funcion_carga = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					carga_masiva();
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};

		// Acci�n del evento
		carga.addActionListener(funcion_carga);

		actualizar.setText("actualizar");
		actualizar.setBounds(520, 260, 130, 70);

		ActionListener funcion_actualizar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		};

		// Acci�n del evento
		actualizar.addActionListener(funcion_actualizar);

		eliminar.setText(" eliminar");
		eliminar.setBounds(700, 260, 130, 70);

		ActionListener funcion_eliminar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					eliminar();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};

		// Acci�n del evento
		eliminar.addActionListener(funcion_eliminar);

		pdf.setText(" Exportar PDF");
		pdf.setBounds(520, 420, 310, 70);

		ActionListener funcion_pdf = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					generar_pdf();
				} catch (FileNotFoundException | DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};

		// Acci�n del evento
		pdf.addActionListener(funcion_pdf);

	}

	private void tabla() throws ClassNotFoundException {
		String[] datos = { "codigo", "Nombre", "Direccion", "Correo", "Telefono" };

		sucursales_funciones sf = new sucursales_funciones();
		sucursales = sf.listar();
		tabla = new JTable(sucursales, datos);

		spanel = new JScrollPane(tabla);
		spanel.setBounds(50, 50, 400, 500);

	}

	private void crear() {

		JFrame crear = new JFrame();
		JPanel p1 = new JPanel();
		p1.setLayout(null);

		// etiquetas
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		JLabel l3 = new JLabel();
		JLabel l4 = new JLabel();
		JLabel l5 = new JLabel();

		// cajas de texto
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();

		// boton
		JButton b1 = new JButton();

		l1.setText("Codigo:");
		l1.setFont(new Font("serig", Font.PLAIN, 20));
		l1.setBounds(50, 80, 100, 80);
		l1.setVisible(true);
		p1.add(l1);

		l2.setText("Nombre:");
		l2.setFont(new Font("serig", Font.PLAIN, 20));
		l2.setBounds(50, 180, 180, 80);
		l2.setVisible(true);
		p1.add(l2);

		l3.setText("Direccion:");
		l3.setFont(new Font("serig", Font.PLAIN, 20));
		l3.setBounds(50, 280, 100, 80);
		l3.setVisible(true);
		p1.add(l3);

		l4.setText("Correo");
		l4.setFont(new Font("serig", Font.PLAIN, 20));
		l4.setBounds(50, 380, 100, 80);
		l4.setVisible(true);
		p1.add(l4);

		l5.setText("Telefono");
		l5.setFont(new Font("serig", Font.PLAIN, 20));
		l5.setBounds(50, 480, 150, 80);
		l5.setVisible(true);
		p1.add(l5);

		crear.setTitle("Crear");
		crear.setLocationRelativeTo(null);
		crear.setBounds(500, 150, 600, 700);
		crear.setVisible(true);
		p1.setBackground(Color.white);
		crear.add(p1);

		// jtextfield
		t1.setBounds(250, 100, 200, 40);
		t2.setBounds(250, 200, 200, 40);
		t3.setBounds(250, 300, 200, 40);
		t4.setBounds(250, 400, 200, 40);
		t5.setBounds(250, 500, 200, 40);

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);

		// boton
		b1.setText("Guardar");
		b1.setBounds(200, 570, 150, 60);
		b1.setBackground(Color.getHSBColor(0.35f, 0.6f, 0.9f));
		p1.add(b1);

		// Funcionalidad
		ActionListener ingresar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				sucursales_funciones sf = new sucursales_funciones();
				sf.crear(t2.getText(), t3.getText(), t4.getText(), Integer.parseInt(t5.getText()));
				crear.setVisible(false);
			}
		};

		// Acci�n del evento
		b1.addActionListener(ingresar);

	}

	private String leerarchivo() {

		JPanel c1 = new JPanel();
		JFileChooser fc = new JFileChooser();
		int op = fc.showOpenDialog(c1);
		String content = "";
		if (op == JFileChooser.APPROVE_OPTION) {

			File pRuta = fc.getSelectedFile();
			String ruta = pRuta.getAbsolutePath();
			File archivo = null;
			FileReader fr = null;
			BufferedReader br = null;

			try {
				archivo = new File(ruta);
				fr = new FileReader(archivo);
				br = new BufferedReader(fr);
				String linea = "";

				while ((linea = br.readLine()) != null) {

					content += linea + "\n";
				}
				return content;

			} catch (FileNotFoundException ex) {
				String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
			} catch (IOException ex) {
				String resp = (String) JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
			} finally {
				try {
					if (null != fr) {
						fr.close();
					}
				} catch (Exception e2) {
					String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
					return "";
				}

			}
			return content;

		}
		return null;
	}

	/*
	 * [21:03] Javier Alexander Gir�n Donis
	 * s.setCodigo(objeto.get("codigo").getAsInt());
	 * s.setNombre(objeto.get("nombre").getAsString());
	 * s.setDireccion(objeto.get("direccion").getAsString());
	 * s.setCorreo(objeto.get("correo").getAsString());
	 * s.setTelefono(objeto.get("telefono").getAsInt());
	 * 
	 * [21:03] Javier Alexander Gir�n Donis filas[x][0] = s.getCodigo(); filas[x][1]
	 * = s.getNombre(); filas[x][2] = s.getDireccion(); filas[x][3] = s.getCorreo();
	 * filas[x][4] = s.getTelefono(); x = x + 1;
	 */

	private void carga_masiva() throws FileNotFoundException, IOException, ParseException {
		int x = 0;
		int y = 0;

		String archivo_retorno = leerarchivo();

		JsonParser parse = new JsonParser();
		JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

		for (int i = 0; i < matriz.size(); i++) {
			JsonObject objeto = matriz.get(i).getAsJsonObject();
			sucursales_funciones sf = new sucursales_funciones();
			sf.crear(objeto.get("nombre").getAsString(), objeto.get("direccion").getAsString(),
					objeto.get("correo").getAsString(), objeto.get("telefono").getAsInt());

		}

	}

	private void eliminar() throws ClassNotFoundException {
		int posicion = tabla.getSelectedRow();

		if (posicion != -1) {

			sucursales_funciones sf = new sucursales_funciones();
			sf.eliminar(Integer.parseInt(sucursales[posicion][0].toString()));

		} else {
			JOptionPane.showInternalMessageDialog(null, "debe seleccionar una fila");
		}
		MenuPrincipal mp = new MenuPrincipal ();
		mp.cerrar();
		mp.ejecutar();
		
	}

	private void modificar() {
		int seleccionar = tabla.getSelectedRow();
		if (seleccionar != -1) {

			JFrame crear = new JFrame();
			JPanel p1 = new JPanel();
			p1.setLayout(null);

			// etiquetas
			JLabel l1 = new JLabel();
			JLabel l2 = new JLabel();
			JLabel l3 = new JLabel();
			JLabel l4 = new JLabel();
			JLabel l5 = new JLabel();

			// cajas de texto
			JTextField t1 = new JTextField();
			JTextField t2 = new JTextField();
			JTextField t3 = new JTextField();
			JTextField t4 = new JTextField();
			JTextField t5 = new JTextField();

			// boton
			JButton b1 = new JButton();

			l1.setText("Codigo:");
			l1.setFont(new Font("serig", Font.PLAIN, 20));
			l1.setBounds(50, 80, 100, 80);
			l1.setVisible(true);
			p1.add(l1);

			l2.setText("Nombre:");
			l2.setFont(new Font("serig", Font.PLAIN, 20));
			l2.setBounds(50, 180, 180, 80);
			l2.setVisible(true);
			p1.add(l2);

			l3.setText("Direccion:");
			l3.setFont(new Font("serig", Font.PLAIN, 20));
			l3.setBounds(50, 280, 100, 80);
			l3.setVisible(true);
			p1.add(l3);

			l4.setText("Correo");
			l4.setFont(new Font("serig", Font.PLAIN, 25));
			l4.setBounds(50, 380, 100, 80);
			l4.setVisible(true);
			p1.add(l4);

			l5.setText("Telefono");
			l5.setFont(new Font("serig", Font.PLAIN, 20));
			l5.setBounds(50, 480, 150, 80);
			l5.setVisible(true);
			p1.add(l5);

			crear.setTitle("Crear");
			crear.setLocationRelativeTo(null);
			crear.setBounds(500, 150, 600, 700);
			crear.setVisible(true);
			p1.setBackground(Color.white);
			crear.add(p1);

			// jtextfield
			t1.setBounds(250, 100, 200, 40);
			t2.setBounds(250, 200, 200, 40);
			t3.setBounds(250, 300, 200, 40);
			t4.setBounds(250, 400, 200, 40);
			t5.setBounds(250, 500, 200, 40);

			t1.setText(sucursales[seleccionar][0] + "");
			t2.setText(sucursales[seleccionar][1].toString());
			t3.setText((String) sucursales[seleccionar][2]);
			t4.setText(sucursales[seleccionar][3].toString());
			t5.setText(sucursales[seleccionar][4].toString());

			p1.add(t1);
			p1.add(t2);
			p1.add(t3);
			p1.add(t4);
			p1.add(t5);

			// boton
			b1.setText("Guardar");
			b1.setBounds(200, 570, 150, 60);
			b1.setBackground(Color.getHSBColor(0.35f, 0.6f, 0.9f));
			p1.add(b1);

			// Funcionalidad
			ActionListener ingresar = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					sucursal objeto = new sucursal();
					objeto.setCodigo(Integer.parseInt(t1.getText()));
					objeto.setNombre(t2.getText());
					objeto.setDireccion(t3.getText());
					objeto.setTelefono(Integer.parseInt(t5.getText()));
					objeto.setCorreo(t4.getText());

					sucursales_funciones sf = new sucursales_funciones();
					sf.modificar(objeto);

				}
			};

			// Acci�n del evento
			b1.addActionListener(ingresar);
		} else {
			JOptionPane.showMessageDialog(null, "Debe selecionar una Fila");
		}

	}

	private void generar_pdf() throws FileNotFoundException, DocumentException {

		FileOutputStream gen = new FileOutputStream("Sucursales.pdf");
		Document documento = new Document();

		PdfWriter.getInstance(documento, gen);
		documento.open();

		Paragraph parrafo = new Paragraph("Sucursales");
		parrafo.setAlignment(1);
		documento.add(parrafo);
		documento.add(new Paragraph("\n"));

		for (int i = 0; i < sucursales.length; i++) {

			if (sucursales[i][0] == null) {
				break;
			} else {
				documento.add(new Paragraph("C�digo: " + sucursales[i][0] + " " + "Nombre: " + sucursales[i][1] + " "
						+ "Direcci�n: " + sucursales[i][2] + " " + "Correo: " + sucursales[i][3] + " " + "Tel�fono: "
						+ sucursales[i][4]));
				documento.add(new Paragraph("\n\n"));
			}

		}
		documento.close();
		JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
		try {
			File sucursales_doc = new File("Sucursales.pdf");
			Desktop.getDesktop().open(sucursales_doc);
		} catch (Exception e) {
		}
	}

	public void ejecutar() throws ClassNotFoundException {
		botones();
		tabla();
	}
}
