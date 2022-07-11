package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {


	    Connection con;
	    String url= "jdbc:mysql://localhost:3306/sistemadeventas";
	    String user= "root";
	    String pass="";
	    
	    public Connection conectar () {
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con=DriverManager.getConnection (url,user,pass);
	            System.out.println("funciono");
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return con;
	    }
	    
	    public static void main(String[] args) {
			conexion c = new conexion();
			System.out.println(c.conectar());
			
		}
	}

