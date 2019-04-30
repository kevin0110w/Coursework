public class League {
  private final int MAXTEAMS = 5;
  private Team[] teams;

  public League() {
    this.teams = new Team[MAXTEAMS];
  }

  public void add(Team team) {
    for (int i = 0; i < teams.length; i++) {
      if (teams[i] == null) {
        teams[i] = team;
        break;
      }
    }
  }
  public Team[] getTeams() {
    return this.teams;
  }

  public Team find(String name) {
    Team a = null;
    for (int i = 0; i < teams.length; i++) {
      if (teams[i].getName().equals(name)) {
        a = teams[i];
        break;
      }
    }
    return a;
  }

  public void sort() {
    int temp = 0;
    int index = 0;
    int k = 0;
    while (k < teams.length) {
    for (int i = k; i < teams.length; i++) {
      if (teams[i].points() > temp) {
        temp = teams[i].points();
        index = i;
      }
    }
    Team a = teams[k];
    teams[k] = teams[index];
    teams[index] = a;
    k++;
    temp = 0;
    }
  }

  public static void main(String[] args) {
    League l = new League();
    l.add(new Team("Real Madrid", 30, 3, 0));
    l.add(new Team("Rangers", 0, 0, 33));
    l.add(new Team("Tottenham", 10, 10, 10));
    l.add(new Team("Barcelona", 20, 5, 5));
    l.add(new Team("Celtic", 0, 3, 27));
    for (Team x : l.getTeams()) {
      System.out.println(x.getName());
    }
    System.out.println();
    l.sort();
    for (Team x : l.getTeams()) {
        System.out.println(x.getName());
    }
  }
}
