package adt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GirlNames {

	public static void main(String[] args) {

		List<String> girlNames = new ArrayList<>();
		girlNames.add("Mireilla");
		girlNames.add("Linda");
		girlNames.add("Rita");
		girlNames.add("Amanda");
		girlNames.add("Mireilla");
		girlNames.add("Cristina");
		girlNames.remove("Mireilla");

//		Iterator<String> iterator = girlNames.iterator();
//
//		while(iterator.hasNext()) {
//			String allname = iterator.next();
//			System.out.println(allname);
//		}
		for (int i = 0; i < girlNames.size(); i++) {
			System.out.println(girlNames.get(i));
		}
	}

}
