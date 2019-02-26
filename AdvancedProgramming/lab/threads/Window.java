package lab.threads;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
/**
 * This class is responsible for building an interface with a textfield and 2 buttons, start and stop.
 * If a user enters a number in the textfield, followed by clicking the start button,
 * the number will start counting down to 0 per second, unless the user clicks stop in which case, 
 * the program will stop counting.
 * It does this by using a swingworker object
 */
public class Window extends JFrame implements ActionListener {
	private JTextField field;
	private JButton start, stop;
	private CounterWorker c;
	public Window()  {
		this.setSize(800, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setup();
	}
	
	/**
	 * Setting up the general layout of the gui
	 */
	public void setup() {
		JPanel bottomPanel = new JPanel(new FlowLayout());
		field = new JTextField(20);
		bottomPanel.add(field);
		start = new JButton("Start");
		start.addActionListener(this);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		bottomPanel.add(start);
		bottomPanel.add(stop);
		this.add(bottomPanel);
	}
	
	/**
	 * Listeners for the buttons
	 * If start button is pressed, the string in the textfield is converted to a number which is passed to a swingworker 
	 * object that is then executed
	 * If stop button is pressed, a method in the swingworker class is called, flipping a boolean field in the object and causing
	 * it to stop during it's run method
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == start) {	
				int startNumber = Integer.parseInt(field.getText());
				c = new CounterWorker(startNumber, field);
				c.execute(); }
			else if (e.getSource() == stop) {
				c.setStop();
			}
		}catch (NumberFormatException exception) {
		}
	}

	/**
	 * Swing worker nested class
	 *
	 */
	public class CounterWorker extends SwingWorker<Void, Integer> {
		private int startNumber;
		private boolean stop;
		private JTextField field;

		public CounterWorker(int number, JTextField field) {
			this.startNumber= number;
			this.field = field;
			this.stop = true;
		}			
		
		public void setStop() {
			this.stop = false;
		}

		protected void process(List<Integer> values) { 
			int length = values.size();
			this.field.setText("" + values.get(length-1));
		}

		@Override
		protected Void doInBackground() throws Exception {
			for (int i = this.startNumber; i >= 0; i--) {
				try {
					if (!this.stop) {
						break;
					}else {
					Thread.sleep(1000);
					} 
				} catch (InterruptedException e) {
				} 
				publish(i);
			}
			return null;
		}
	}

	public static void main(String[] args) {
		new Window();
	}
}
