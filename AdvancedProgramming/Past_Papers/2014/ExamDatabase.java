import java.util.ArrayList;

public class ExamDatabase {
  private ArrayList<Exam> database;

  public ExamDatabase() {
    this.database = new ArrayList<Exam>();
    this.database.add(new Exam("AP(M)", true, false));
  }

  public ArrayList<Exam> getDB() {
    return this.database;
  }

  public void addExam(Exam e) {
    this.database.add(e);
  }

  public boolean paperSet(String course) {
    boolean set = false;
    for (Exam e : this.database) {
      if (e.getCourse().equals(course)) {
        set = e.getSet();
      }
    }
    return set;
  }

  public boolean paperChecked(String course) {
    boolean checked = false;
    for (Exam e : this.database) {
      if (e.getCourse().equals(course)) {
        checked = e.getChecked();
      }
    }
    return checked;
  }

  public class Exam {
    String course;
    boolean checked;
    boolean set;

    public Exam(String course, boolean checked, boolean set) {
      this.course = course;
      this.checked = checked;
      this.set = set;
    }
    public String getCourse() {
      return this.course;
    }
    public boolean getSet() {
      return this.set;
    }

    public boolean getChecked() {
      return this.checked;
    }

  }
  public static void main(String[] args) {
    ExamDatabase ed = new ExamDatabase();
    System.out.println(ed.getDB().get(0).getCourse());
    System.out.println(ed.getDB().get(0).getSet());
    System.out.println(ed.getDB().get(0).getChecked());
  }
}
