public class Team {
  private int won, drawn, lost;
  private String name;

  public Team(String name, int won, int drawn, int lost) {
    this.name = name;
    this.won = won;
    this.drawn = drawn;
    this.lost = lost;
  }
  public String getName() {
    return this.name;
  }

  public int points() {
    return ((this.won*3) + this.drawn);
  }

}
