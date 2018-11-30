package src;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddPhilCollins {
	public static void main( String args[]) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
		}  catch (Exception e) {
			System.out.println("Could not load JDCB Driver");
			e.printStackTrace();
			return;
		}

		try {
			c = DriverManager.getConnection("jdbc:postgresql://yacata.dcs.gla.ac.uk:5432/","m_18_0808148w", "0808148w");
			System.out.println("Opened database successfully");
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;
		}

		if (c != null) {
			try {
				stmt = c.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet. CONCUR_UPDATABLE);
//				stmt = c.createStatement();
				String sql = "Select * FROM OWNER";
				
//				ResultSet results  = stmt.executeQuery(sql);
				
//				while (results.next()) {
//					String phone = results.getString("phone");
//					phone = "+44" + phone;
//					results.updateString("phone", phone);
//					results.updateRow();
//				}
				
//				results.beforeFirst();
//				
//				while (results.next()) {
//					int ownerid = results.getInt("ownerid");
//					String name = results.getString("name");
//					String phone = results.getString("phone");
//					System.out.println("Updated details: " + ownerid + "\t" + name + "\t" + phone);
//				}
				
				DatabaseMetaData metadata = c.getMetaData();
				
				ResultSet resultSet = metadata.getColumns(null, null, "owner", null);
				
				while (resultSet.next()) {
					String name = resultSet.getString("COLUMN_NAME");
					String type = resultSet.getString("TYPE_NAME");
					int size = resultSet.getInt("COLUMN_SIZE");
					
					System.out.println("Column name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
				}
				
				resultSet.close();
				stmt.close();
				c.close();	
			} catch ( Exception e ) {
				System.exit(0);
			}
			System.out.println("Operation done successfully");
		} else {
			System.out.println("Failed to establish connection!");
		}
	}
}