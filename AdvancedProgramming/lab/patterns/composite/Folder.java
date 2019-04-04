package lab.patterns.composite;

import java.util.ArrayList;

public class Folder implements FileComponent {
	private ArrayList<FileComponent> children;
	private String name;
	
	public Folder(String name) {
		this.name = name;
		this.children = new ArrayList<FileComponent>();
	}

	@Override
	public int getNumberOfFiles() {
		int number = 1;
		for (FileComponent child : this.children) {
			number+= child.getNumberOfFiles();
		}
		return number;
	}

	@Override
	public int getSize() {
		int size = 0;
		for (FileComponent child : this.children) {
			size+= child.getSize();
		}
		return size;
	}
	
	public void addItem(FileComponent f) {
		this.children.add(f);
	}
	
	public String toString() {
		return this.name + " (" + this.getSize() + ")";
	}

	@Override
	public void display(String prefix) {
		System.out.println(prefix + this.toString());
		prefix += "\t";
		for(FileComponent child:this.children) {
			child.display(prefix);
		}
	}
}
