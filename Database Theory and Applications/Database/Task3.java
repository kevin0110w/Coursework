import java.sql.*;

public class Task3 {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		}  catch (Exception e) {
			System.out.println("Could not load JDCB Driver");
			e.printStackTrace();
			return;
		}
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://yacata.dcs.gla.ac.uk:5432/", "m_18_0808148w", "0808148w");
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;
		}
		
		if (connection != null) {
			try {
			Statement statement = connection.createStatement();
			System.out.println("Controlling your database... ");
			String sqlString = "DROP TABLE IF EXISTS song";
			statement.executeQuery(sqlString);
//			String sqlString = "CREATE TABLE Owner2(ownerid integer, name varchar(32), phone varchar(32))";
//			statement.executeUpdate(sqlString);
//			String sql = "ALTER TABLE Owner2 ADD CONSTRAINT rk PRIMARY KEY (ownerid)";
//			statement.executeUpdate(sql);
//			String SQLInsert = "INSERT INTO OWNER2(ownerid, name, phone) VALUES(1, 'John', '0131223454')";
//			int status = statement.executeUpdate(SQLInsert);
//			String SQLInsert = "INSERT INTO OWNER2(ownerid, name, phone) VALUES(2, 'Tony', '0442877454')";
//			int status = statement.executeUpdate(SQLInsert);
//			SQLInsert = "INSERT INTO OWNER2(ownerid, name, phone) VALUES (3, 'Tom', '01413452005')";
//			status = statement.executeUpdate(SQLInsert);
//			String SQLUpdate = "UPDATE OWNER2 SET phone = '01413307252' WHERE ownerid = 1";
//			int status = statement.executeUpdate(SQLUpdate);
//			String SQLUpdate = "UPDATE OWNER2 SET phone = '01413307252' WHERE ownerid = 3";
//			int status = statement.executeUpdate(SQLUpdate);
//			String SQLUpdate = "DELETE FROM OWNER2 WHERE ownerid = 1";
//			String SQLUpdate = "DELETE FROM OWNER2 WHERE ownerid = 3";
//			SQLUpdate = "DELETE FROM OWNER2 WHERE ownerid = 2";
//			int status = statement.executeUpdate(SQLUpdate);
//			for (int i = 1; i<10; i++) {
//				String insertion =  "INSERT INTO OWNER2(ownerid, name, phone) VALUES("+i+", 'N', '0141');";
//				statement.addBatch(insertion);
			
//			}
//			for (int i = 1; i<10; i++) {
//				String deletion = "DELETE FROM OWNER2 WHERE ownerid = " +i;
//				statement.addBatch(deletion);
//			}
//			int[] success = statement.executeBatch();
//			for (int i = 0; i<success.length; i++) {
//				System.out.println("Statement: "+ success[i]);
//			}
			statement.close();
//			if (status == 1) {
//				System.out.println("Owner is registered");
//			} else {
//				System.out.println("No insertion completed");
//			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
			}
		} else {
			System.out.println("Failed to establish connection!");
		}
	}

}
