import java.util.*;

public class Lecturer
{
    public String name;
    public String office;
    public LinkedList<Course> courses;
    public LinkedList<MastersCourse> mastersCourses;

    public Lecturer()
    {
    }

    public Lecturer(String n, String where, LinkedList<Course> c, LinkedList<MastersCourse> mc)
    {
        name = n;
        office = where;
        courses = c;
        mastersCourses = mc;
    }
}
