package lists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextEditor {
	private List<String>text;
	private int sel;
	private String search;
	
	public TextEditor() {
		text = new ArrayList<String>();
		sel = -1;
		search = "";
	}

	public void select(int p) {
		try {	
			if (p < 0 || p > this.text.size()) {
				throw new anException();
			} 
			} catch (anException e) {
			}
			sel = p;	
		}
	
	public void delete() {
		try {
			if (sel < 0) {
				throw new anException();
			}
		} catch (anException e) {
		} finally {
			text.remove(sel);
			if (sel == text.size()) {
				sel --;
			}
		}
	}
	
	public void setString(String string) {
		this.search = string;
	}
	
	public void find(String string) {
		setString(string);
		try {
			if (sel < 0) {
				throw new anException();
			}
		}catch (anException e) {
			}
			int p = sel;
			int n = text.size();
			do {
				String line = text.get(p);
				if (line.indexOf(string) >= 0) {
					sel = p;
					return;
				}
				if (++p == n) {
					p = 0;
				}
			}while (p!=sel);
			}
	
	public void insertAbove(String line) {
		try {
			if (sel < 0) {
				throw new anException();
			} text.add(sel, line);
			sel++;
		} catch (anException e) {
		}
	}
	
	public void insertBelow(String line) {
		sel++;
		text.add(sel, line);
	}
	
	public void load(BufferedReader input) {
		for (;;) {
			String line = "";
			try {
				line = input.readLine();
			} catch (IOException e) {
			}
			if (line == null) {
				break;
			} 
			text.add(line);
		} 
		sel = text.size() -1;
	}
	
	public void save(BufferedWriter output) {
		for (String line : text) {
			try {
				output.write(line + "\n");
			} catch (IOException e) {
			}
		}
	}
	
	public void findFirst(String word) {
		try {
			if (sel < 0) {
				throw new anException();
			}
			int p = 0;
			int n = text.size();
			do {
				String line = text.get(p);
				if (line.indexOf(word) >= 0) {
					sel = p;
					return ;
				} if (++p == n) {
					p = 0;
				}
			} while (p != sel);
		} catch (anException e) {
		}
	}
	
	public void findNext() {
		try {
			if (sel < 0) {
				throw new anException();
			}
			int p = sel+1;
			int n = text.size();
			do {
				String line = text.get(p);
				if (line.indexOf(search) >= 0) {
					sel = p;
					return ;
				} if (++p == n) {
					p = 0;
				}
			} while (p != sel);
		} catch (anException e) {
		}
	}
	
	
	
	public static void main(String[] args) {
		TextEditor a = new TextEditor();
		a.insertBelow("Below is a brow");
		a.insertBelow("Below is a toad");
		a.insertBelow("Below is a poo");
		a.insertAbove("Below is a toad");
		a.insertBelow("Below is a crow");
		a.insertAbove("Below is a toad");
		a.insertAbove("Below is a toad");
		System.out.println(a.sel);
		a.findFirst("toad");
		System.out.println(a.sel);
		a.setString("toad");
		a.findNext();
		System.out.println(a.sel);
		a.findNext();
		System.out.println(a.sel);
	}

}

