package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class vendedores_funciones {
	PreparedStatement ps;
    ResultSet rs;
    Connection con;    
    conexion acceso = new conexion();
	Vendedor v = new Vendedor();

	
	Object[][] listar;

	public void crear(String nombre, int caja, int ventas, String genero, String password) {
		String sql = "insert into vendedores (nombre,caja,ventas,genero, password)values(?,?,?,?,?)";

		try {
			
			con = acceso.conectar();
			ps = con.prepareStatement(sql);

			ps.setString(1, nombre);
			ps.setInt(2, caja);
			ps.setInt(3, ventas);
			ps.setString(4, genero);
			ps.setString(5, password);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void modificar(Vendedor v) {
		String sql = "update vendedores set nombre=?, caja=?, ventas=?, genero=?, password=? where codigo=?";

		try {
			con = acceso.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, v.getNombre());
			ps.setInt(2, v.getCaja());
			ps.setInt(3, v.getVentas());
			ps.setString(4, v.getGenero());
			ps.setString(5, v.getPassword());
			ps.setInt(6, v.getCodigo());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void eliminar(int codigo) {
		String sql = "delete from vendedores where codigo=?";
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

		String sql = "select * from vendedores";
		int filas = 0;

		try {
			con = acceso.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				filas++;

			}

			listar = new Object[filas][6];
			int y = 0;
			con = acceso.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				listar[y][0] = rs.getInt(1);
				listar[y][1] = rs.getString(2);
				listar[y][2] = rs.getInt(3);
				listar[y][3] = rs.getInt(4);
				listar[y][4] = rs.getString(5);
				listar[y][5] = rs.getString(6);

				y++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return listar;
	}

}
