package glasgow.ac.uk.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import glasgow.ac.uk.queue.Queue.Node;

public class QueueTest<Item> {
	private Queue queue;
	
	@Before
	public void setUp() {
		queue = new Queue();
	}

	@Test
	public void testIsEmpty() {
		assertTrue("Check is empty queue", queue.isEmpty());
	}

	@Test
	public void testSize() {
		queue.enqueue("Frodo");
		assertTrue("Queue size = 1", queue.size() == 1);
	}

	@Test
	public void testPeek() {
		queue.enqueue("Frodo");
		queue.enqueue("Samwise");
		assertEquals("Show oldest item is Frodo", "Frodo", queue.peek());
	}

	@Test
	public void testEnqueue() {
		queue.enqueue("Frodo");
		assertEquals("Show queue includes Frodo", "Frodo", queue.iterator().next());
	}

	@Test
	public void testDequeue() {
		queue.enqueue("Frodo");
		queue.enqueue("Samwise");
		assertEquals("Show oldest item, Frodo, is removed", "Frodo", queue.dequeue());
	}
}
