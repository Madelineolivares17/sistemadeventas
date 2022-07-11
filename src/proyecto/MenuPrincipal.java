package proyecto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MenuPrincipal {

	JFrame principal = new JFrame();
	JTabbedPane pestañas= new JTabbedPane ();
	
	
	
	
	
	//paneles para las pestañas
	JPanel sucursales = new JPanel ();
	JPanel clientes = new JPanel ();
	JPanel vendedores = new JPanel ();
	JPanel productos = new JPanel ();
	
	
	
	
	sucursalMenu sucurmenu =new sucursalMenu ();
	ProductosMenu producmenu =new ProductosMenu ();
	ClienteMenu climenu =new ClienteMenu ();
	VendedorMenu venmenu=new VendedorMenu();
	
	public void valores_iniciales() throws ClassNotFoundException {
		//frame datos
		principal.setTitle("Modulo administrador");
		principal.setLocationRelativeTo(null);
		//x y amcho alto
		principal.setBounds(500, 150, 900, 700);
		principal.setVisible(true);
		JButton cerrar = new JButton("Cerrar Sesion");
		cerrar.setBackground(Color.red);
		cerrar.setForeground(Color.white);
		cerrar.setBounds(700, 630, 150, 20);	
		
		// Funcion cerrar
		ActionListener funcion_cerrar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				login log = new login ();
				
				log.ejecutar();
				principal.setVisible(false);
				
				

			}
		};
		
		
		/*JButton ModuloVendedor = new JButton("Modulo Vendedores");
		ModuloVendedor.setBackground(Color.green);
		ModuloVendedor.setForeground(Color.white);
		ModuloVendedor.setBounds(700, 30, 150, 30);
		
		ActionListener funcion_llamar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Menuvendedores ventana=new Menuvendedores();
				
				try {
					ventana.ejecutar();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				

			}
		};*/
		

		// Acción del evento
		cerrar.addActionListener(funcion_cerrar);
	
		principal.add(cerrar);
		//ModuloVendedor.addActionListener(funcion_llamar);
		//principal.add(ModuloVendedor);
		principal.add(pestañas);
	  
		
		
		
			
		
		//colores de los paneles
		sucursales.setBackground(Color.getHSBColor(0.6f, 0.5f, 1.0f));
		clientes.setBackground(Color.getHSBColor(0.6f, 0.5f, 1.0f));
		vendedores.setBackground(Color.getHSBColor(0.6f, 0.5f, 1.0f));
		productos.setBackground(Color.getHSBColor(0.6f, 0.5f, 1.0f));
		
		
		
		
		sucursales.setLayout(null);
		clientes.setLayout(null);
		vendedores.setLayout(null);
		productos.setLayout(null);
		
		
		
		//se agregan los paneles
		pestañas.addTab("Sucursales",sucursales);
		pestañas.addTab("clientes",clientes);
		pestañas.addTab("vendedores",vendedores);
		pestañas.addTab("productos",productos);
	
		
	
		
		
		sucurmenu.ejecutar();  // llamo el metodo de ejecutar de sucursales
		sucursales.add(sucurmenu.crear); // se lo agrego al panel de sucursales el boton de crear 
		sucursales.add(sucurmenu.carga);
		sucursales.add(sucurmenu.actualizar);
		sucursales.add(sucurmenu.eliminar);
		sucursales.add(sucurmenu.pdf);
		
		sucursales.add(sucurmenu.spanel);
		
		
		producmenu.ejecutar(); 
		productos.add(producmenu.crear); 
		productos.add(producmenu.carga);
		productos.add(producmenu.actualizar);
		productos.add(producmenu.eliminar);
		productos.add(producmenu.pdf);
		
		productos.add(producmenu.ppanel);
		
		
		climenu.ejecutar(); 
		clientes.add(climenu.crear); 
		clientes.add(climenu.carga);
		clientes.add(climenu.actualizar);
		clientes.add(climenu.eliminar);
		clientes.add(climenu.pdf);
		
		clientes.add(climenu.cpanel);
		
		venmenu.ejecutar(); 
		vendedores.add(venmenu.crear); 
		vendedores.add(venmenu.carga);
		vendedores.add(venmenu.actualizar);
		vendedores.add(venmenu.eliminar);
		vendedores.add(venmenu.pdf);
		
		vendedores.add(venmenu.vpanel);
		
	}
	
	public void cerrar () {
		principal.setVisible(false);
		
	}
		
	
		
	
	
	public void ejecutar () throws ClassNotFoundException {
		valores_iniciales ();
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		MenuPrincipal menup =new MenuPrincipal ();
		menup.valores_iniciales();
		
	}
	
	
}
