package view;

import java.util.Scanner;

import controller.NameController;

public class NameView {

	NameController nameController;

	public NameView(NameController nameController) {
		this.nameController = nameController;
	}

	public void prompt() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter name (quit for quit): ");
			String name = scanner.nextLine();
			if(!Validator.isValid(name)){
				System.out.println("That name isn't quite right! \n\n\n\n\n");
				continue;
			}

			if (name.equalsIgnoreCase("quit")) {
				System.out.println("*********-:End:-**********");
				break;
			}
			
			nameController.save(name);
			
			
			System.out.println("********** -:Names:- **********");
			for (String nameInList : nameController.findAllNames()) {
				System.out.println(nameInList);
			}
			
			System.out.print("\n\n\n\n\n");
		}
		scanner.close();
	}
	
	
	
}
