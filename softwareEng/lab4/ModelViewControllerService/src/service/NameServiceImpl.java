package service;

import java.util.List;

public class NameServiceImpl implements NameService{

	
	private NamePersistence namePersistence;
	
	public NameServiceImpl(NamePersistence namePersistence){
		this.namePersistence = namePersistence;
	}
	
	@Override
	public boolean save(String name) {
		return namePersistence.save(name);
	}

	@Override
	public List<String> findAllNames() {
		return namePersistence.findAllNames();
	}
	
	
	/*
	 * This interface will served as data access layer for this service
	 * In this way we can make sure our service doesn't depend upon under laying
	 * model since any under laying model implementing this interface can be used 
	 * as data access layer 
	 */
	public interface NamePersistence{
		boolean save(String name);
		List<String> findAllNames();
	}

}
