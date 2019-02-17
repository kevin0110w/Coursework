package controller;

import java.util.List;

import service.NameService;

public class NameControllerImpl implements NameController{
	
	private service.NameService nameService;
	
	public NameControllerImpl(NameService nameService){
		this.nameService = nameService;
	}

	@Override
	public boolean save(String name) {
		return nameService.save(name);
	}

	@Override
	public List<String> findAllNames() {
		return nameService.findAllNames();
	}

}
