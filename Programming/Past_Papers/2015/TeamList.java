public class TeamList
{
   // maximum possible number of teams
   private final int MAX_TEAMS = 5;

   // the list of teams in the tournament
   private Team [] teams;

   // actual number of teams in the tournament

   private int numTeams;

   public TeamList()
   {  teams = new Team[MAX_TEAMS];
      numTeams = 0;
   }

   // return a Team object with a given name
   public Team findTeam(String name) {
   // (A)
   Team a = null;
    for (int i = 0; i < this.teams.length; i++) {
      if (this.teams[i].getName().equals(name)) {
        a = this.teams[i];
      }
    }

    return a;
   }

   // add a Team object with given name if not added already
   public void addTeam(String name)
   {  if (numTeams>=MAX_TEAMS)
         System.err.println("Too many teams");
      else
      {  Team team = findTeam(name);
         if (team==null)
         {  team = new Team(name);
            teams[numTeams] = team;
            numTeams++;
         }
      }
   }

   public int getNumTeams()  // accessor method for numTeams
   {  return numTeams;
   }

   public void printTeams()  // print out team information
    {  // (C)
      for (int i = 0; i < this.teams.length; i++) {
        String line = String.format("12%s, %2d", this.teams[i].getName(), this.teams[i].getPoints());
        System.out.println(line);
      }
   }

   public double getAverage() {
     int totalpoints = 0;
     for (int i = 0; i<teams.length; i++) {
       totalpoints += teams[i].getPoints();
     }

     double average = totalpoints / this.numTeams;
     if (this.numTeams == 0) {
       average = 0;
     }
     return average;
   }

   public static void main(String[] args) {
     TeamList a = new TeamList();
     a.addTeam("Abbey");
     a.addTeam("Ford");
     a.addTeam("Bournevale");
     a.addTeam("Park");
     a.addTeam("Bracklinn");
     a.findTeam("Abbey").setPoints(4);
     a.findTeam("Bournevale").setPoints(1);
     a.findTeam("Park").setPoints(3);
     a.printTeams();
   }
}
