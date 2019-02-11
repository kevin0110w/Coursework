package lecture_material.threading;

/**
 * This class demonstrates that main's own thread will complete way before
 * the other ones which are sleeping as soon as they are created.
 * Therefore the print statement in main is completed first before the other threads
 * awaken to do theirs
 * @author Freckles
 *
 */
public class MainThread extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
		}
		System.out.println("Thread finished");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new MainThread().start();
		}
		System.out.println("The End");
	}
}
