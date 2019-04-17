public class Student {
  private String name;
  private String programme;
  private String matric;

  public Student(String name, String programme, String matric) {
  this.name = name;
  this.programme = programme;
  this.matric = matric;
  }

  public String getMatric() {
    return this.matric;
  }

  public String getName() {
    return this.name;
  }

  public String getProgramme() {
    return this.programme;
  }
  public String toString() {
  return this.name + ": " + this.programme;
  }
}
