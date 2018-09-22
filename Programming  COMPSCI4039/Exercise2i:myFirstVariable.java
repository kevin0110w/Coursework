/*
Copy the following code into the Lab2Ex1.java file:
public class Lab2Ex1 {
    public static void main(String[] args) {
        String message = "Hello World!";
        System.out.println(message);
    }
}

Before you run the program, try and predict what will happen. Run it. Was your prediction correct?
Now modify it to do the following and run it:
public class Lab2Ex1 {
    public static void main(String[] args) {
        String message = "Hello World!";
        System.out.println(message);
        
        message = "Goodbye!";
        System.out.println(message);
    }
}
Can you explain what is happening?
Try changing the line message = "Goodbye!"; into String message = "Goodbye!"; What happens? Why? */
public class Lab2Ex1 {
	public static void main(String[] args) {
		String message = "Hello World!";
		System.out.println(message);
		
// 		Cannot declare message again as String message. Can only re-assign another value to it.
		message = "Goodbye!";
		System.out.println(message);
	}
}
