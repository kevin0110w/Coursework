package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OwnerPhoneNumbers {
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
				String sql = "Select phone FROM OWNER";
				
				ResultSet results  = stmt.executeQuery(sql);
				while (results.next()) {
					String phone = results.getString("phone");
					phone = "+44" + phone;
					results.updateString("phone", phone);
					results.updateRow();
				}
					results.beforeFirst();
					while(results.next()) {
						String phone = results.getString("phone");
						System.out.println("Updated phone: " + phone);
					}
				results.close();
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