public class Team {
  private int won, drawn, lost;
  private String name;

  public Team(String name, int w, int d, int l) {
    this.name = name;
    this.won = w;
    this.drawn = d;
    this.lost = l;
  }

  public int points() {
    int points = (this.won * 3) + this.drawn;
    return points;
  }

  public String getName() {
    return this.name;
  }

  public String toString() {
    return this.name + ": " + this.won + " wins " + this.drawn + " drawn " + this.lost + " losses " + this.points() + " points";
  }
}
