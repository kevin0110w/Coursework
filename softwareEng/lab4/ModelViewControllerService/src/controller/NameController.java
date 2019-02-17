package controller;

import java.util.List;

public interface NameController {
	boolean save(String name);
	List<String> findAllNames();
}
