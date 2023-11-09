package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/TABLAEXAMEN" + "user=root&password=super3"); //CONEXION
			
			stmt = conn.createStatement(); //CON LO QUE ESCUPIREMOS LA QUERY A LA BASE DE DATOS
			rs = stmt.executeQuery("SELECT * FROM herois"); //EXECUTE QUERY ES SOLO PARA SELECTS
			
			Statement stmt2 = conn.createStatement();
			
			if(stmt2.execute("SELECT * FROM herois WHERE nom = 'Morcilla'")); //SI RETORNA TRUE ENTONCES SE PUEDE ITERAR
			{
				rs2 = stmt2.getResultSet();
				while(rs2.next()) // PARA ITERAR LOS RESULTADOS
				{
					System.out.println(rs2.getString("nom")); // EL NOMBRE DEL ATRIBUTO A MOSTRAR
				}

			}
			
		}catch(SQLException exp) {
			
		}
	}

}
