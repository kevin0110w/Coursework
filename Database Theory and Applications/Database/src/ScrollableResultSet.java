package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSet {
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
				stmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
				ResultSet results  = stmt.executeQuery("SELECT * FROM DOG")	;
				
				/** 
				 * Get cursor position
				 */
//				System.out.println("Position " + results.getRow() + ", is before first? " + results.isBeforeFirst());
				
				/**
				 * next() moves cursor to the next row
				 */
//				results.next();
//				System.out.println("Position " + results.getRow() + ", is first? " + results.isFirst());
				
				/*
				 * last() moves cursor to the last row
				 */
//				results.last();
//				System.out.println("Position " + results.getRow() + ", is last ? " + results.isLast());
				
				/*
				 * moves the cursor to the 3rd row
				 */
//				results.absolute(3);
//				System.out.println("Position " + results.getRow());
				
				/*
				 * moves cursor to the last row
				 */
				results.absolute(-1);
				System.out.println("Position " + results.getRow() + ", is last ? " + results.isLast());
				
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