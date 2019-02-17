package model;

import java.util.ArrayList;
import java.util.List;

import service.NameServiceImpl.NamePersistence;

public class DataAccessLayer implements NamePersistence {

	private List<String> storedNames = new ArrayList<>();
	
	@Override
	public boolean save(String name) {
		int countBeforeInsertion = storedNames.size();
		storedNames.add(name);
		int countAfterInsertion = storedNames.size();
		if(countAfterInsertion > countBeforeInsertion){
			return true;
		}
		return false;
	}


	@Override
	public List<String> findAllNames() {
		return storedNames;
	}
	
}