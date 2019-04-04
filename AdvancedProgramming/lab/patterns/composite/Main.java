package lab.patterns.composite;

public class Main {

	public static void main(String[] args) {
		Folder root = new Folder("root");
		root.addItem(new Folder("Settings"));
		Folder pictures = new Folder("pictures");
		pictures.addItem(new File("portrait", 120));
		root.addItem(pictures);
		Folder music = new Folder("music");
		
		FileComponent blue = new File("Kind of Blue", 201);
		FileComponent steps = new File("Giant Steps", 134);
		root.addItem(music);
		music.addItem(blue);
		music.addItem(steps);
		System.out.println(root);
		root.display("");
	}

}
