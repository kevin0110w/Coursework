package Immutable;

public class StringExample {
	public static class StringWrapper {
		private String s;
		public StringWrapper(String s) {
			this.s = s;
		}
		public String getString() {
			return s;
		}
		//append parameter s to this.s
		public void ModifyString(String s) {
			this.s += s;
		}

	}

	public static void main(String[] args) {
		StringWrapper sw = new StringWrapper("hello");
		String s = sw.getString();
		System.out.println(s);
		s+=" simon";
		System.out.println(s);
		System.out.println(sw.getString());
		sw.ModifyString(" simon");
		System.out.println(sw.getString());
	}
}