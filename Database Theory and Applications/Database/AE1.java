/*
 * Author @0808148w
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AE1 {
	public static void main( String args[]) {
		Connection connection = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver"); //loading the jdbc driver for postgresql
		}  catch (Exception e) {
			System.out.println("Could not load JDCB Driver");
			e.printStackTrace();
			return;
		}

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://yacata.dcs.gla.ac.uk:5432/","m_18_0808148w", "0808148w"); //initialising the connection string
			System.out.println("Opened database successfully");
			System.out.println();
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;
		} 
		
		//connection to the database is done

		if (connection != null) {
			try {
				stmt = connection.createStatement();
				/*
				 * Projecting total count of members as numberOfMembers and band name after selecting band members who have a null endyear value (i.e. current members) and grouping the table by bandname and ordering by numberOfMembers
				 */
				String sql = "Select count(m.membershipID) as NumberOfMembers, b.name as BandName from Membership as m, Band as b where b.bandwebpage = m.bandwebpage and m.endyear is null group by b.name order by NumberOfMembers desc, b.name asc"; 

				ResultSet rset  = stmt.executeQuery(sql); //using the ResultSet object to execute the sql command
				int i = 1;
				int  maxNumberOfMembers = 0;
				while (rset.next()) {
					String bandName = rset.getString("BandName"); //getting the bandname
					int numberOfMembers = rset.getInt("NumberOfMembers"); //getting the count per band
					
					if (i == 1) {
						maxNumberOfMembers = numberOfMembers; //set the initial max value to the first count which will be definition be the highest as the results were ordered previously
						i++; // increment i so that max can not be altered
					} 
					if (numberOfMembers < maxNumberOfMembers) {// if the next count (i.e. total number of members for the next band) is smaller than the max, we can break out the loop and print what's been collected so far
						break; // I assumed this is necessary in the event that there are two or more band with the same total number of active members in their band
					}	
					System.out.println("Band Name: " + bandName + ", Number of members: " + numberOfMembers); 
				}
				rset.close(); //close the resultset object
				stmt.close(); //close the statement object
				connection.close();	 //close the connection to the database
			} catch ( Exception e ) {
				System.exit(0);
			}
			System.out.println("Operation done successfully");
		} else {
			System.out.println("Failed to establish connection!");
		}
	}
}
