package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class productos_funciones {

	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	conexion acceso = new conexion();
	Producto pro = new Producto();

	Object[][] listar;

	public void crear(String nombre, String descripcion, int cantidad, double precio) {
		String sql = "insert into productos (nombre,descripcion,cantidad,precio)values(?,?,?,?)";

		try {
			con = acceso.conectar();
			ps = con.prepareStatement(sql);

			ps.setString(1, nombre);
			ps.setString(2, descripcion);
			ps.setInt(3, cantidad);
			ps.setDouble(4, precio);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void modificar(Producto pro) {
		String sql = "update productos set nombre=?, descripcion=?, cantidad=?, precio=? where codigo=?";

		try {
			con = acceso.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNombre());
			ps.setString(2, pro.getDescripcion());
			ps.setInt(3, pro.getCantidad());
			ps.setDouble(4, pro.getPrecio());
			ps.setInt(5, pro.getCodigo());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void eliminar(int codigo) {
		String sql = "delete from productos where codigo=?";
		try {
			con = acceso.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
	
	
	public Object[][] listar() {

		String sql = "select * from productos";
		int filas = 0;

		try {
			con = acceso.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				filas++;

			}

			listar = new Object[filas][5];
			int y = 0;
			con = acceso.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				listar[y][0] = rs.getInt(1);
				listar[y][1] = rs.getString(2);
				listar[y][2] = rs.getString(3);
				listar[y][3] = rs.getInt(4);
				listar[y][4] = rs.getDouble(5);
				y++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return listar;
	}

	
	
	public Producto buscar_producto (int codigo,int cantidad) {
		
		String sql = "select * from productos";
		

		try {
			con = acceso.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				if (codigo == rs.getInt(1)) {
					
					if ( cantidad <rs.getInt(4)) {
					pro.setCodigo(rs.getInt(1));
					pro.setNombre(rs.getNString(2));
					pro.setCantidad(rs.getInt(4));
					pro.setPrecio(rs.getDouble(5));
					
					return pro;
					}
					else {
						JOptionPane.showMessageDialog(null, "catidad solicitada mayor al inventario, se cuenta con: "+rs.getInt(4) );
					break;
					}
				
				}

			}
		}
			
		catch (Exception e) {
			System.out.println(e);
		}
return null;
		

	}
	
	
	
	
	
	
}
