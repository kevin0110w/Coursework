package Stacks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Stack;
import java.util.Stack;

public class FileReversal {

	/**
	 * @param args
	 */
	public static void reverse (
			BufferedReader input,
			BufferedWriter output)
					throws IOException {
		// Make output contain the lines of input in reverse 
		// order.


		// to instantiate a Stack, 
		//either do this, using Java's own Stack class:

		//Stack<String> lineStack = new Stack<String>()


		// or use one of our own implementations, below. Need to comment out the import java.util.Stack
		// line above, or Java thinks you mean that one, rather than the version 
		// in this directory



		//Stack<String> lineStack = 
		//    new ArrayStack<String>(20);

		//or the linked version:
		Stack<String> lineStack =
				new Stack<String>();

		for (;;) {
			String line = input.readLine();
			if (line == null)  break;  // end of input
			lineStack.push(line);
		}
		input.close();
		while (! lineStack.empty()) {
			String line = lineStack.pop();
			output.write(line + "\n");
		}
		output.close();
	}




	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader("lyrics.txt"));
		BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
		reverse(input,output);
		input.close();
		output.close();



	}

}