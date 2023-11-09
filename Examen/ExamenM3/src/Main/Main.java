package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import Comparador.ComparadorMissions;
import Observer.ClasseQueEscucha;
import Observer.GenericPropertyChanges;

public class Main {

	public static void main(String[] args) {
		/*
		 * GenericPropertyChanges pc = new GenericPropertyChanges(); //HAGO LA CLSE QUE
		 * ESCUCHA ClasseQueEscucha cqe = new ClasseQueEscucha();
		 * 
		 * pc.addPropertyChangeListener(cqe); //SUBSCRIBO AL EVENTO
		 * 
		 * pc.setTipusAigua("patata"); //HACE EL CAMBIO Y LO ENVIA A LOS DEMAS
		 */

		// EXAMEN\

		HashMap<String, String> Missio1 = new HashMap<String, String>();
		HashMap<String, String> Missio2 = new HashMap<String, String>();
		HashMap<String, String> Missio3 = new HashMap<String, String>();
		HashMap<String, String> Missio4 = new HashMap<String, String>();

		// MISIONS
		Missio1.put("NOM ENEMIC", "Renfe");
		Missio1.put("DESCRIPCIO", "Agafar la renfe a temps");
		Missio1.put("UREGENCIA", "2");

		Missio2.put("NOM ENEMIC", "Demoni del insomni");
		Missio2.put("DESCRIPCIO", "Intentar dormir");
		Missio2.put("UREGENCIA", "4");

		Missio3.put("NOM ENEMIC", "Examen");
		Missio3.put("DESCRIPCIO", "Aprobarlo");
		Missio3.put("UREGENCIA", "1");

		Queue<HashMap<String, String>> LMissions = new LinkedList<HashMap<String, String>>();

		LMissions.add(Missio1);
		LMissions.add(Missio2);
		LMissions.add(Missio3);

		/*
		 * PriorityQueue<HashMap<String, String>> LlistaMissions = new
		 * PriorityQueue<HashMap<String, String>>(); LlistaMissions.add(Missio1);
		 * LlistaMissions.add(Missio2); LlistaMissions.add(Missio3);
		 * System.out.println(LlistaMissions.toString());
		 */
		Comparator<HashMap<String, String>> c = new ComparadorMissions(); // HABIA HECHO EL COMPARATOR PERO NO SE
																			// ENVIARLO AL PRIORITY LO SIENTO

		System.out.println(LMissions.toString());

		Missio4.put("NOM ENEMIC", "Collections");
		Missio4.put("DESCRIPCIO", "Ordenar missions");
		Missio4.put("UREGENCIA", "3");

		LMissions.add(Missio4);

		System.out.println(LMissions.toString());

		// EJERICIO 2
		System.out.println("----------------------------------------------");
		Connection conn = null;
		Statement stmt = null;
		Statement stmt2 = null;
		Statement stmt3 = null;
		Statement stmt4 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/powerchamber?" + "user=root&password=super3"); // CONEXION
			stmt = conn.createStatement();
			while (!LMissions.isEmpty()) {
				stmt.execute("INSERT INTO missions (descripcio, nomEnemic, urgencia) VALUES ('"
						+ LMissions.peek().get("DESCRIPCIO") + "', '" + LMissions.peek().get("NOM ENEMIC") + "', '"
						+ Integer.valueOf(LMissions.poll().get("UREGENCIA")) + "')");
			}
			stmt2 = conn.createStatement();
			if (stmt2.execute("SELECT * FROM missions")) {
				rs2 = stmt2.getResultSet();
				System.out.println("LLISTA MISSIONS: ");
				while (rs2.next()) {
					System.out.println(rs2.getInt("idmissions") + " " + rs2.getString("descripcio") + " "
							+ rs2.getString("nomEnemic") + " " + rs2.getInt("urgencia"));
				}
			}
			stmt3 = conn.createStatement();
			stmt3.execute("DELETE FROM missions WHERE descripcio IS NULL");
			System.out.println(" ------------------------ HE BORRADO -----------------------");
			stmt4 = conn.createStatement();
			if (stmt4.execute("SELECT * FROM missions")) {
				rs2 = stmt4.getResultSet();
				System.out.println("LLISTA MISSIONS: ");
				while (rs2.next()) {
					System.out.println(rs2.getInt("idmissions") + " " + rs2.getString("descripcio") + " "
							+ rs2.getString("nomEnemic") + " " + rs2.getInt("urgencia"));
				}
			}
			stmt3 = conn.createStatement();
			stmt3.execute("UPDATE missions SET urgencia = 4 WHERE nomEnemic IS NULL");
			System.out.println(" ------------------------ MODIFICADA PRIORIDAD -----------------------");
			stmt4 = conn.createStatement();
			if (stmt4.execute("SELECT * FROM missions")) {
				rs2 = stmt4.getResultSet();
				System.out.println("LLISTA MISSIONS: ");
				while (rs2.next()) {
					System.out.println(rs2.getInt("idmissions") + " " + rs2.getString("descripcio") + " "
							+ rs2.getString("nomEnemic") + " " + rs2.getInt("urgencia"));
				}
			}
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		} finally {

			if (rs != null) {
				try {
					rs.close();

				} catch (SQLException sqlEx) {
				} // ignore
				rs = null;
			}
			if (stmt != null) {

				try {

					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore
				stmt = null;
			}
		}

		//// ENEMICS
		System.out.println("-------------------------- ENEMICS ex 3 + 4 -----------");
		EnemicsFactory ef = new EnemicsFactory();
		
		//PWR
		PowerRanger p1 = new PowerRanger("Pol", "Juan", Color.BLAU, 0.1);
		PowerRanger p2 = new PowerRanger("Joan", "Ratacaballo", Color.GROC, 2.1);
		
		ef.addPropertyChangeListener(p1);
		ef.addPropertyChangeListener(p2);
		
		Enemic e1 = ef.GenerarEnemic(TipusEnemic.LordZedd, "Miguel", p2);
		Enemic e2 = ef.GenerarEnemic(TipusEnemic.RitaRepulsa, "Maria la malvada", p1);
		
		System.out.println("ELS ENEMICS: " + e1.toString() + " " + e2.toString());
		e1.Atacar();
		e2.Atacar();
		
		
		System.out.println("==================== EX 5 ==================");
		
		
				
	}
}
