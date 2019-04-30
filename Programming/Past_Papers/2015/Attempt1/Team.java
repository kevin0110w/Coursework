public class Team
{
   private String name;    // the team's name
   private int points;     // the team's points total

   public Team(String aName)
   {  name = aName;
      points = 0;
   }

   public String getName() // accessor method for name
   {  return name;
   }

   // accessor and mutator methods for points
   public int getPoints()
   {  return points;
   }

   public void setPoints(int numPoints)
   {  points = numPoints;
   }
} 
