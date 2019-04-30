public class LeagueTest {
  public static void main(String[] args) {
    League league = new League();
    Team rangers = new Team("Rangers", 0, 0, 10);
    Team real_madrid = new Team("Real Madrid", 10, 0, 0);
    Team tottenham = new Team("Tottenham", 5, 2, 3);
    league.add(rangers);
    league.add(real_madrid);
    league.add(tottenham);
    for (int i = 0; i < league.getLeague().length; i++) {
      System.out.println(league.getLeague()[i]);
    }
    league.sort();
    for (int i = 0; i < league.getLeague().length; i++) {
      System.out.println(league.getLeague()[i]);
    }
  }
}
