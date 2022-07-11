package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;


/*import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;*/

import javax.swing.*;  // en lugar de agregar todos los de arriba se puede importar toda la libreria

public class login {
//atributos
	JFrame login = new JFrame();
	JPanel panel1 = new JPanel();
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	JLabel l4 = new JLabel();
	JLabel l5 = new JLabel();
	
	JTextField t1 = new JTextField();
	JPasswordField t2 = new JPasswordField(); // no es un JTextField porque es de una contraseña
    JButton b1=new JButton ();
    
    
    Object [][]vendedores = new Object [400][6];
    
     
	// metodo
	public void frame() {
		login.setTitle("Login");
		login.setLocationRelativeTo(null);

		// x y ancho alto
		login.setBounds(500, 300, 500, 500);
		login.setVisible(true);

		panel1.setBackground(Color.WHITE);
		panel1.setOpaque(true);
		
		panel1.setBounds(500, 300, 500, 300);
		panel1.setBackground(Color.getHSBColor(0.7f, 0.5f, 0.9f));
		panel1.setLayout(null);
		
		
		
		
		
		login.add(panel1);
		etiquetas();

	}

	// etiquetas y Jtexfield´s
	public void etiquetas() {
		//etiquetas
		
		
		
		
		
		l1.setText("Usuario");
		l1.setForeground(Color.white);l2.setForeground(Color.white);
		l1.setFont(new Font("Britannic Bold", Font.PLAIN,25));
		l1.setBounds(50, 155, 100, 80);
		panel1.add(l1);
		
		l2.setText("Contraseña");
		l2.setForeground(Color.white);
		l2.setFont(new Font("Britannic Bold", Font.PLAIN,25));
		l2.setBounds(50, 240, 180, 80);
		l2.setVisible(true); //set visible no es necesario si el panel ya es visible
		panel1.add(l2);
		
		l3.setText("                     Iniciar sesion");
		
	    l3.setOpaque(true);
		l3.setBackground(Color.white);
		l3.setFont(new Font("Britannic Bold", Font.PLAIN,25));
		l3.setBounds(0, 10, 500, 40);
		l3.setVisible(true); //set visible no es necesario si el panel ya es visible
		panel1.add(l3);
		
		
	l4.setBounds(200, 60, 80, 80);;
	ImageIcon imagen= new ImageIcon ("imagenes/perfil1.png");
	Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(l4.getWidth(), l4.getHeight(), Image.SCALE_DEFAULT));
	l4.setIcon (icono);
	panel1.add(l4);
		
		
		//JTextField
		t1.setBounds(250, 165, 200, 40); 
		panel1.add(t1);
		t2.setBounds(250, 250, 200, 40);
		panel1.add(t2);
		
	}
	
	
	public void botones()  {
		b1.setText("Acceder");
		b1.setFont(new Font("Arial", Font.PLAIN,18));
		b1.setForeground(Color.white);
		b1.setBackground(Color.getHSBColor(0.6f, 0.7f, 0.5f));
		//b1.setBackground(Color.cyan);
		b1.setBounds(150, 380, 200, 40);
		panel1.add(b1);
		
		//funcionalidad
		
		ActionListener ingresar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {

					ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_vendedores.dat"));

					vendedores = (Object[][]) recuperar.readObject();
					recuperar.close();

				} catch (IOException m) {
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (t1.getText().equals("Admin") && t2.getText().equals("Admin")) {
					JOptionPane.showMessageDialog(null, "Bienvenido");
					login.setVisible(false);
					MenuPrincipal menu=new MenuPrincipal ();
					try {
						menu.ejecutar();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
				else {
					Boolean acceso = false;
					for (int i = 0; i < vendedores.length; i++) {
						if(t1.getText().equals(vendedores [i][1]) && t2.getText().equals(vendedores [i][5] )){
							acceso=true;
							break;
						}
					}
					if (acceso ==true) {
						JOptionPane.showMessageDialog(null, "Bienvenido");
						login.setVisible(false);
						Menuvendedores men= new Menuvendedores ();
						try {
							men.ejecutar();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
					
					
					JOptionPane.showMessageDialog(null, "Usuario Equivocado o no Existente");
					}
				}

			}
		};

		// Acción del evento
		b1.addActionListener(ingresar);

			
		
	}
	

	

	public void ejecutar() {
		frame();
		etiquetas();
		botones ();
	}

	public static void main(String[] args) {
		login panel1 = new login();
		panel1.ejecutar();
	}
}
