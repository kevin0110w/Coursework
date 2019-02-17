import controller.NameController;
import controller.NameControllerImpl;
import model.DataAccessLayer;
import service.NameService;
import service.NameServiceImpl;
import service.NameServiceImpl.NamePersistence;
import view.NameView;

/*
 * This is a lab demonstrating some architecture
 * 
 */

public class Application {
	
	
	public static void main(String[] args){
		initApp();
	}
	
	
	private static void initApp(){
		NamePersistence namePersistence = new DataAccessLayer();
		NameService nameService = new NameServiceImpl(namePersistence);
		NameController nameController = new NameControllerImpl(nameService);
		NameView view = new NameView(nameController);
		view.prompt();
	}

}

