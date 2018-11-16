import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main (String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not find JDBC Driver");
			e.printStackTrace();
			return;
		}
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://yacata.dcs.gla.ac.uk:5432/", "m_18_0808148w", "0808148w")
		;
			} catch (SQLException e) {
				System.out.println("Connection Failed!");
				e.printStackTrace();
				return;
			}
		
		if (connection != null) {
			try {
			System.out.println("Controlling your database... ");
			Statement statement = connection.createStatement();
//			String sqlString = "CREATE TABLE Tobedeleted(name integer)";
//			String sqlString = "ALTER TABLE Tobedeleted ADD COLUMN surname varchar(50)";
//			String sqlString = "ALTER TABLE Tobedeleted DROP COLUMN surname";
//			String sqlString = "ALTER TABLE Tobedeleted RENAME name to nameid";
//			String sqlString = "ALTER TABLE Tobedeleted RENAME nameid to name";
//			String sqlString = "CREATE TABLE Tobedeteted(name varchar(32), id integer )";
//			String sqlString = "ALTER TABLE Tobedeleted ADD CONSTRAINT pk PRIMARY KEY (name)";
//			String sqlString = "DROP TABLE IF EXISTS Tobedeteted";
			statement.executeUpdate(sqlString);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		}
			else {
			System.out.println("Failed to establish connection!");
		}
			
	}	
} 



