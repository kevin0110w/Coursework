import java.util.ArrayList;

public class Programme implements Component {
    private String name;
    private ArrayList<Component> courses = new ArrayList<Component>();
    public Programme(String n) {
        name = n;
    }
    public void addComponent(Component c) {
        courses.add(c);
    }
    public Integer getCredits() {
        Integer total = 0;
        for(Component c: courses) {
            total += c.getCredits();
        }
        return total;
    }
    public String description() {
        String des = "Programme contents: ";
        for(Component c: courses) {
            des += c.description() + ", ";
        }
        return des;
    }
}
