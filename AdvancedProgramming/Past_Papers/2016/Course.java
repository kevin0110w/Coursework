public class Course implements Component {
    private String name;
    private Integer credits;
    public Course(String n,Integer c) {
        name = n; credits = c;
    }
    public Integer getCredits() {
        return credits;
    }
    public String description() {
        return name + "(" + credits + ")";
    }
}
