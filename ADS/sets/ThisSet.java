package sets;
import java.util.HashSet;

public class ThisSet {

	public ThisSet() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		HashSet<Object> thisSet = new HashSet<Object>();
		thisSet.add(200);
		thisSet.add(400);
		thisSet.add(200);
		thisSet.add(150);
		thisSet.add(250);
		thisSet.add(500);
		thisSet.add(200);
		thisSet.add(150);
		System.out.println(thisSet);

	}

}
