package glasgow.ac.uk.queue;

public class QueueMain {
	
	public static void main(String [] args) {
		Queue<String> queue = new Queue<String>();
		
		queue.enqueue("Frodo");
		queue.enqueue("Samwise");
		queue.enqueue("Gandalf");
		
		System.out.println(queue.dequeue()); // Frodo
		System.out.println(queue.dequeue()); // Samwise
		System.out.println(queue.dequeue()); // Gandalf
		queue.dequeue(); // No Such Element Exception
		
	}

}
