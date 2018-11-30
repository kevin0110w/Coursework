import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KennelWithMostDogs {
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
				stmt = c.createStatement();
				String sql = "Select count(*) as NumberOfDogsPerKennel, kennelname FROM dog group by kennelname Order by NumberOfDogsPerKennel Desc limit 1";
				System.out.println();

				ResultSet rset  = stmt.executeQuery(sql);
				while (rset.next()) {
					String kennelName = rset.getString("kennelname");
					int numberOfDogsPerKennel = rset.getInt("NumberOfDogsPerKennel");
					System.out.println(kennelName + ": "+ numberOfDogsPerKennel);
				}
				rset.close();
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
