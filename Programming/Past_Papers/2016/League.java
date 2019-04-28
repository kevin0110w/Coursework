public class League {
  private Team[] league;

  public League() {
    this.league = new Team[3];
  }

  public Team[] getLeague() {
    return this.league;
  }

  public void add(Team t) {
    for (int i = 0; i<this.league.length;i++) {
      if (this.league[i] == null) {
        this.league[i] = t;
        return;
      }
    }
  }


  public Team find(String teamName) {
    Team a_team = null;
    for (int i = 0 ; i < this.league.length; i++) {
      if (this.league[i].getName().equals(teamName)) {
        a_team = this.league[i];
      }
    }
    return a_team;
  }

  public void sort() {
    int min = this.league[0].points();
    int min_position = 0;
    int max = 0;
    int index = 3;
    boolean sorted = false;
    while (!sorted) {
      if (index == 0 && min_position == this.league.length-1) {
        sorted = true;
        break;
      }
    // go through the league and find the index of
    // the element with the most points
    for (int i = 0; i < this.league.length; i++) {
      if (this.league[i].points() >= max) {
        max = this.league[i].points();
        index = i;
      }
      if (this.league[i].points() <= min) {
        min_position = i;
      }
    }

    Team a = this.league[0];
    this.league[0] = this.league[index];
    this.league[index] = a;
    }
  }
}
