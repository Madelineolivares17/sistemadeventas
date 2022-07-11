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

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class VendedorMenu {

	// botones
	JButton crear = new JButton();
	JButton carga = new JButton();
	JButton actualizar = new JButton();
	JButton eliminar = new JButton();
	JButton pdf = new JButton();
	int suma = 0;
	// Matriz
	
	Object[][] vendedores;

	// tabla y complemento
	JTable tabla;
	JScrollPane vpanel;

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
		String[] datos = { "codigo", "Nombre", "Caja", "Ventas", "Genero" };

		vendedores_funciones vf = new vendedores_funciones ();
		vendedores= vf.listar();
		tabla = new JTable(vendedores, datos);
		vpanel = new JScrollPane(tabla);
		vpanel.setBounds(50, 50, 400, 500);

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

		l3.setText("Caja:");
		l3.setFont(new Font("serig", Font.PLAIN, 20));
		l3.setBounds(50, 210, 100, 80);
		l3.setVisible(true);
		p1.add(l3);

		l4.setText("Ventas");
		l4.setFont(new Font("serig", Font.PLAIN, 20));
		l4.setBounds(50, 300, 100, 80);
		l4.setVisible(true);
		p1.add(l4);

		l5.setText("Genero");
		l5.setFont(new Font("serig", Font.PLAIN, 20));
		l5.setBounds(50, 390, 150, 80);
		l5.setVisible(true);
		p1.add(l5);

		l6.setText("Contraseña");
		l6.setFont(new Font("serig", Font.PLAIN, 20));
		l6.setBounds(50, 480, 150, 80);
		l6.setVisible(true);
		p1.add(l6);

		crear.setTitle("Crear");
		crear.setLocationRelativeTo(null);
		crear.setBounds(500, 150, 500, 700);
		crear.setVisible(true);
		p1.setBackground(Color.white);
		crear.add(p1);

		// jtextfield
		t1.setBounds(200, 50, 200, 40);
		t2.setBounds(200, 140, 200, 40);
		t3.setBounds(200, 230, 200, 40);
		t4.setBounds(200, 320, 200, 40);
		t5.setBounds(200, 410, 200, 40);
		t6.setBounds(200, 500, 200, 40);

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);

		// boton
		b1.setText("Guardar");
		b1.setBounds(200, 570, 150, 60);
		b1.setBackground(Color.getHSBColor(0.35f, 0.6f, 0.9f));
		p1.add(b1);

		// Funcionalidad
		ActionListener ingresar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				vendedores_funciones vf = new vendedores_funciones();
				vf.crear(t2.getText(), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), t5.getText(),
						t6.getText());

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

		for (int i = 0; i<= 49; i++) {
		
				JsonObject objeto = matriz.get(i).getAsJsonObject();
				vendedores_funciones vf = new vendedores_funciones();

				vf.crear(objeto.get("nombre").getAsString(), objeto.get("caja").getAsInt(),
						objeto.get("ventas").getAsInt(), objeto.get("genero").getAsString(),
						objeto.get("password").getAsString());
			
			
		

		}
	}

	private void eliminar() throws ClassNotFoundException {
		int posicion = tabla.getSelectedRow();

		if (posicion != -1) {

			vendedores_funciones vf = new vendedores_funciones ();
			vf.eliminar(Integer.parseInt(vendedores [posicion][0].toString()));

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

			l3.setText("Caja:");
			l3.setFont(new Font("serig", Font.PLAIN, 20));
			l3.setBounds(50, 210, 100, 80);
			l3.setVisible(true);
			p1.add(l3);

			l4.setText("Ventas");
			l4.setFont(new Font("serig", Font.PLAIN, 20));
			l4.setBounds(50, 300, 100, 80);
			l4.setVisible(true);
			p1.add(l4);

			l5.setText("Genero");
			l5.setFont(new Font("serig", Font.PLAIN, 20));
			l5.setBounds(50, 390, 150, 80);
			l5.setVisible(true);
			p1.add(l5);

			l6.setText("Contraseña");
			l6.setFont(new Font("serig", Font.PLAIN, 20));
			l6.setBounds(50, 480, 150, 80);
			l6.setVisible(true);
			p1.add(l6);

			crear.setTitle("Crear");
			crear.setLocationRelativeTo(null);
			crear.setBounds(500, 150, 500, 700);
			crear.setVisible(true);
			p1.setBackground(Color.white);
			crear.add(p1);

			// jtextfield
			t1.setBounds(200, 50, 200, 40);
			t2.setBounds(200, 140, 200, 40);
			t3.setBounds(200, 230, 200, 40);
			t4.setBounds(200, 320, 200, 40);
			t5.setBounds(200, 410, 200, 40);
			t6.setBounds(200, 500, 200, 40);

			t1.setText(vendedores[seleccionar][0].toString());
			t2.setText(vendedores[seleccionar][1].toString());
			t3.setText(vendedores[seleccionar][2].toString());
			t4.setText(vendedores[seleccionar][3].toString());
			t5.setText(vendedores[seleccionar][4].toString());
			t6.setText(vendedores[seleccionar][5].toString());

			p1.add(t1);
			p1.add(t2);
			p1.add(t3);
			p1.add(t4);
			p1.add(t5);
			p1.add(t6);

			// boton
			b1.setText("Guardar");
			b1.setBounds(200, 570, 150, 60);
			b1.setBackground(Color.getHSBColor(0.35f, 0.6f, 0.9f));
			p1.add(b1);

			// Funcionalidad
			ActionListener ingresar = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					Vendedor objeto = new Vendedor();
					objeto.setCodigo(Integer.parseInt(t1.getText()));
					objeto.setNombre(t2.getText());
					objeto.setCaja(Integer.parseInt(t3.getText()));
					objeto.setVentas(Integer.parseInt(t4.getText()));
					objeto.setGenero(t5.getText());
					objeto.setPassword(t6.getText());

					vendedores_funciones vf = new vendedores_funciones();
					vf.modificar(objeto);

				}
			};

			// Acción del evento
			b1.addActionListener(ingresar);

		} else {
			JOptionPane.showMessageDialog(null, "Debe selecionar una Fila");
		}
	}

	private void generar_pdf() throws FileNotFoundException, DocumentException {

		FileOutputStream gen = new FileOutputStream("vendedores.pdf");
		Document documento = new Document();

		PdfWriter.getInstance(documento, gen);
		documento.open();

		Paragraph parrafo = new Paragraph("vendedores");
		parrafo.setAlignment(1);
		documento.add(parrafo);
		documento.add(new Paragraph("\n"));

		for (int i = 0; i < vendedores.length; i++) {

			if (vendedores[i][0] == null) {
				break;
			} else {
				documento.add(new Paragraph("Código: " + vendedores[i][0] + " " + "Nombre: " + vendedores[i][1] + " "
						+ "Caja: " + vendedores[i][2] + " " + "Ventas: " + vendedores[i][3] + " " + "Genero: "
						+ vendedores[i][4] + "Contraseña " + "password: " + vendedores[i][5]));
				documento.add(new Paragraph("\n\n"));
			}

		}
		documento.close();
		JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
		try {
			File vendedores_doc = new File("vendedores.pdf");
			Desktop.getDesktop().open(vendedores_doc);
		} catch (Exception e) {
		}
	}

	public void ejecutar() throws ClassNotFoundException {
		botones();
		tabla();
	}

}
