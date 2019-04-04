package lab.patterns.composite;

public class File implements FileComponent {
	private String name;
	private int size;
	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public int getNumberOfFiles() {
		return 1;
	}

	@Override
	public int getSize() {
		return this.size;
	}
	
	public String toString() {
		return String.format("%s %6s",name," (" + this.size + ")");
	}
	
	@Override
	public void display(String prefix) {
		System.out.println(prefix + this.toString());
	}
}
