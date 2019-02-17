package service;

import java.util.List;

public interface NameService {
	public boolean save(String name);
	public List<String> findAllNames();
}
