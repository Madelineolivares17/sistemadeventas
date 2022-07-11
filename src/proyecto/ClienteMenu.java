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
import java.text.ParseException;

import javax.swing.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ClienteMenu {

	// botones
	JButton crear = new JButton();
	JButton carga = new JButton();
	JButton actualizar = new JButton();
	JButton eliminar = new JButton();
	JButton pdf = new JButton();

	// Matriz
	Object[][] clientes;

	// tabla y complemento
	JTable tabla;
	JScrollPane cpanel;

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

		// Acción del evento
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

		// Acción del evento
		carga.addActionListener(funcion_carga);

		actualizar.setText("actualizar");
		actualizar.setBounds(520, 260, 130, 70);
		ActionListener funcion_actualizar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		};

		// Acción del evento
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

		// Acción del evento
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

		// Acción del evento
		pdf.addActionListener(funcion_pdf);

	}

	private void tabla() throws ClassNotFoundException {
		String[] datos = { "codigo", "Nombre", "NIT", "Correo", "Genero" };

		clientes_funciones cf = new clientes_funciones();
		clientes = cf.listar();
		tabla = new JTable(clientes, datos);
		cpanel = new JScrollPane(tabla);
		cpanel.setBounds(50, 50, 400, 500);

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
		l1.setFont(new Font("Arial", Font.PLAIN, 20));
		l1.setBounds(50, 30, 100, 80);
		l1.setVisible(true);
		p1.add(l1);

		l2.setText("Nombre:");
		l2.setFont(new Font("serig", Font.PLAIN, 20));
		l2.setBounds(50, 120, 180, 80);
		l2.setVisible(true);
		p1.add(l2);

		l3.setText("NIT:");
		l3.setFont(new Font("serig", Font.PLAIN, 20));
		l3.setBounds(50, 210, 100, 80);
		l3.setVisible(true);
		p1.add(l3);

		l4.setText("Correo:");
		l4.setFont(new Font("serig", Font.PLAIN, 20));
		l4.setBounds(50, 300, 100, 80);
		l4.setVisible(true);
		p1.add(l4);

		l5.setText("Genero:");
		l5.setFont(new Font("serig", Font.PLAIN, 20));
		l5.setBounds(50, 390, 150, 80);
		l5.setVisible(true);
		p1.add(l5);

		crear.setTitle("Crear");
		crear.setLocationRelativeTo(null);
		crear.setBounds(500, 150, 500, 650);
		crear.setVisible(true);
		// p1.setBackground(Color.getHSBColor(0.55f, 0.5f, 1.0f));
		p1.setBackground(Color.white);
		crear.add(p1);

		// jtextfield
		t1.setBounds(200, 50, 200, 40);
		t2.setBounds(200, 140, 200, 40);
		t3.setBounds(200, 230, 200, 40);
		t4.setBounds(200, 320, 200, 40);
		t5.setBounds(200, 410, 200, 40);

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);

		// boton
		b1.setText("Guardar");
		b1.setBounds(200, 500, 150, 60);
		b1.setBackground(Color.getHSBColor(0.35f, 0.6f, 0.9f));
		p1.add(b1);

		// Funcionalidad
		ActionListener ingresar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientes_funciones cf = new clientes_funciones();

				cf.crear(t2.getText(), Integer.parseInt(t3.getText()), t4.getText(), t5.getText());

			}
		};

		// Acción del evento
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

	private void carga_masiva() throws FileNotFoundException, IOException, ParseException {
		int x = 0;
		int y = 0;

		String archivo_retorno = leerarchivo();

		JsonParser parse = new JsonParser();
		JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

		for (int i = 0; i <matriz.size(); i++) {

			JsonObject objeto = matriz.get(i).getAsJsonObject();

			clientes_funciones cf = new clientes_funciones();
			cf.crear(objeto.get("nombre").getAsString(), objeto.get("nit").getAsInt(),
					objeto.get("correo").getAsString(), objeto.get("genero").getAsString());
		}
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
			JLabel l6 = new JLabel();

			// cajas de texto
			JTextField t1 = new JTextField();
			JTextField t2 = new JTextField();
			JTextField t3 = new JTextField();
			JTextField t4 = new JTextField();
			JTextField t5 = new JTextField();
			JTextField t6 = new JTextField();

			// boton
			JButton b1 = new JButton();

			l1.setText("Codigo:");
			l1.setFont(new Font("Arial", Font.PLAIN, 20));
			l1.setBounds(50, 30, 100, 80);
			l1.setVisible(true);
			p1.add(l1);

			l2.setText("Nombre:");
			l2.setFont(new Font("serig", Font.PLAIN, 20));
			l2.setBounds(50, 120, 180, 80);
			l2.setVisible(true);
			p1.add(l2);

			l3.setText("NIT:");
			l3.setFont(new Font("serig", Font.PLAIN, 20));
			l3.setBounds(50, 210, 100, 80);
			l3.setVisible(true);
			p1.add(l3);

			l4.setText("Correo:");
			l4.setFont(new Font("serig", Font.PLAIN, 20));
			l4.setBounds(50, 300, 100, 80);
			l4.setVisible(true);
			p1.add(l4);

			l5.setText("Genero:");
			l5.setFont(new Font("serig", Font.PLAIN, 20));
			l5.setBounds(50, 390, 150, 80);
			l5.setVisible(true);
			p1.add(l5);

			crear.setTitle("Crear");
			crear.setLocationRelativeTo(null);
			crear.setBounds(500, 150, 500, 650);
			crear.setVisible(true);
			p1.setBackground(Color.white);
			crear.add(p1);

			// jtextfield
			t1.setBounds(200, 50, 200, 40);
			t2.setBounds(200, 140, 200, 40);
			t3.setBounds(200, 230, 200, 40);
			t4.setBounds(200, 320, 200, 40);
			t5.setBounds(200, 410, 200, 40);

			t1.setText(clientes[seleccionar][0]+"");
			t2.setText(clientes[seleccionar][1].toString());
			t3.setText(clientes[seleccionar][2].toString());
			t4.setText(clientes[seleccionar][3].toString());
			t5.setText(clientes[seleccionar][4].toString());

			p1.add(t1);
			p1.add(t2);
			p1.add(t3);
			p1.add(t4);
			p1.add(t5);

			// boton
			b1.setText("Guardar");
			b1.setBounds(200, 500, 150, 60);
			b1.setBackground(Color.getHSBColor(0.35f, 0.6f, 0.9f));
			p1.add(b1);

			// Funcionalidad
			ActionListener ingresar = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					Cliente objeto = new Cliente();
					objeto.setCodigo(Integer.parseInt(t1.getText()));
					objeto.setNombre(t2.getText());
					objeto.setNit(Integer.parseInt(t3.getText()));
					objeto.setCorreo(t4.getText());
					objeto.setGenero(t5.getText());

					clientes_funciones cf = new clientes_funciones();
					cf.modificar(objeto);

				}
			};

			// Acción del evento
			b1.addActionListener(ingresar);

		} else {
			JOptionPane.showMessageDialog(null, "Debe selecionar una Fila");
		}
	}

	
	
	
	private void eliminar() throws ClassNotFoundException {
		int posicion = tabla.getSelectedRow();

		if (posicion != -1) {

			clientes_funciones cf = new clientes_funciones();
			cf.eliminar(Integer.parseInt(clientes [posicion][0].toString()));

		} else {
			JOptionPane.showInternalMessageDialog(null, "debe seleccionar una fila");
		}
		
		MenuPrincipal mp = new MenuPrincipal ();
		mp.cerrar();
		mp.ejecutar();

	}
	

	private void generar_pdf() throws FileNotFoundException, DocumentException {

		FileOutputStream gen = new FileOutputStream("clientes.pdf");
		Document documento = new Document();

		PdfWriter.getInstance(documento, gen);
		documento.open();

		Paragraph parrafo = new Paragraph("clientes");
		parrafo.setAlignment(1);
		documento.add(parrafo);
		documento.add(new Paragraph("\n"));

		for (int i = 0; i < clientes.length; i++) {

			if (clientes[i][0] == null) {
				break;
			} else {
				documento.add(new Paragraph(
						"Código: " + clientes[i][0] + " " + "Nombre: " + clientes[i][1] + " " + "NIT: " + clientes[i][2]
								+ " " + "Correo: " + clientes[i][3] + " " + "Genero: " + clientes[i][4]));
				documento.add(new Paragraph("\n\n"));
			}

		}
		documento.close();
		JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
		try {
			File clientes_doc = new File("clientes.pdf");
			Desktop.getDesktop().open(clientes_doc);
		} catch (Exception e) {
		}
	}

	public void ejecutar() throws ClassNotFoundException {
		botones();
		tabla();
	}
}
