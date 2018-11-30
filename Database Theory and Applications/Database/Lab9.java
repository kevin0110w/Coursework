import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab9 {
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
//		ResultSet rs = stmt.executeQuery("SELECT * FROM DOG WHERE breedname = 'Pug';" );
//		ResultSet rs = stmt.executeQuery("SELECT COUNT(Distinct breedname) AS COUNTER FROM dog ;") ;
//		ResultSet rs = stmt.executeQuery("SELECT D.DOGID, D.NAME, A.SHOWNAME, A.Place, A.PLACE * 100 AS Reward FROM DOG AS D, Attendance as A WHERE D.DOGID = A.DOGID AND D.dogid IN (SELECT DOGID FROM ATTENDANCE);" );
//		ResultSet sql = stmt.executeQuery("SELECT Dog.name as NAME, Attendance.place*100 AS REWARD FROM DOG, Attendance WHERE Attendance.place <= 3 AND DOG.dogid = Attendance.dogid");
//		int i = 1;
//		ResultSet sql = stmt.executeQuery("Select band.name , Count(MembershipID) FROM membership where endyear is null and membership.bandwebpage = band.bandwebpage group by membership.bandwebpage order by count desc");
		
//		String sql = "Select m.role as ROLE, n.name as MUSICIANNAME FROM Membership as m, Band as b, Musician as n where b.name = 'The Cure' and m.bandwebpage = b.bandwebpage and m.musicianwebpage = n.personalwebpage";
//		String sql = "Select count(m.membershipID) as NumberOfMembers, b.name as BandName from Membership as m, Band as b where b.bandwebpage = m.bandwebpage and m.endyear is null group by b.name order by NumberOfMembers desc limit 1";
//		System.out.println("The SQL query is: " + sql);
		String sql = "Select count(*) as NumberOfDogsPerKennel, kennelname FROM dog group by kennelname Order by NumberOfDogsPerKennel Desc limit 1";
		System.out.println();
		
		ResultSet rset  = stmt.executeQuery(sql);
//		System.out.println(rs.next());, membership.membershipID from membership, WHERE band.bandwebpage = membership.bandwebpage
//		while ( rs.next() ) {) 

//		for (int i = 0; i<= 1; i++) {
		while (rset.next()) {
//			System.out.println("["+i+"]: "+ sql.getString("NAME") +" , " + sql.getString("REWARD"));
//			i++;
//		}
//			String bandName = rset.getString("BandName");
			String kennelName = rset.getString("kennelname");
			int numberOfDogsPerKennel = rset.getInt("NumberOfDogsPerKennel");
		
			System.out.println(kennelName + ": "+ numberOfDogsPerKennel);
//			break;
//			bandWebpage = sql.getString("bandwebpage");
			
//			String bandname = sql.getString("name");
//			String role = rset.getString("ROLE");
//			String musicianName = rset.getString("MUSICIANNAME");
//			int membershipid = sql.getInt("membership.membershipid");		
			
//			int max = count;
//			if (max >= count) {
//				count = max;
//		}
		
			
//			int MembershipID = sql.getInt("membership.membershipid");
//			System.out.println("band =: " + BandName);
//			System.out.println("band =: " + bandName);
//			System.out.println("BandWebpage =: " + bandWebpage);
//			System.out.println("BandName: " + bandname);
//			System.out.println("MembershipID: " + membershipid);
//			System.out.println("Musician No ["+i+"] " + ": " + musicianName + ", " + role);
//			System.out.println("MusicianName: " + musicianName);
//			 i++;
			//			System.out.println("ID =: " + MembershipID);
//			int dogid = rs.getInt("dogid");
//			String NAME = rs.getString("name");
//			int ownerid = rs.getInt("ownerid");
//			String kennelName = rs.getString("kennelname");
//			String breedname = rs.getString("breedname");
//			int counter = rs.getInt("COUNTER");
//			int dogid = rs.getInt("dogid");
//			String name = rs.getString("name");
//			String showname = rs.getString("showname");
//			int place = rs.getInt("place");
//			double reward = rs.getDouble("Reward");
//			String mothername = rs.getString("mothername");
//			String fathername = rs.getString("fathername");
//			System.out.println( "dogid = " + dogid );
//			System.out.println( "Name = " + NAME );
//			System.out.println( "ownerid = " + ownerid );
//			System.out.println( "kennelname = " + kennelName );
//			System.out.println( "breedname = " + breedname );
//			System.out.println( "mothername = " + mothername );
//			System.out.println( "fathername = " + fathername );
//			System.out.println( "COUNTER = " + counter );
//			System.out.println( "DogID = " + dogid );
//			System.out.println( "Name = " + name );
//			System.out.println( "ShowName = " + showname );
//			System.out.println( "Place = " + place );
//			System.out.println( "Reward = £" + reward );	
//			System.out.println();
//			}]
		}
		rset.close();
//			rs.close();
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

