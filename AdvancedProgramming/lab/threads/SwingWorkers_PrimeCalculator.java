package lab.threads;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import lab.threads.SwingWorkers_CountDown.CounterWorker;

public class SwingWorkers_PrimeCalculator extends JFrame implements ActionListener {
	private JTextArea field;
	private JButton start, stop;
	private CounterWorker c;
	public SwingWorkers_PrimeCalculator()  {
		this.setLayout(new GridLayout(2,0));
		this.setSize(800, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setup();
	}

	private void setup() {
		JPanel topPanel = new JPanel();
		field = new JTextArea();
		field.setVisible(true);
		field.setSize(this.getWidth(), this.getHeight());
		field.setBackground(Color.WHITE);
		field.setLineWrap(true);
		field.setWrapStyleWord(true);
		JScrollPane jScrollPanel = new JScrollPane(field);
		topPanel.add(field);
		topPanel.add(jScrollPanel);
		JPanel bottomPanel = new JPanel(new FlowLayout());
		start = new JButton("Start");
		start.addActionListener(this);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		bottomPanel.add(start);
		bottomPanel.add(stop);
		this.add(topPanel);
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
				c = new CounterWorker(field);
				c.execute();
				start.setEnabled(false);
				stop.setEnabled(true);
			}
			else if (e.getSource() == stop) {
				c.setStop();
				stop.setEnabled(false);
				start.setEnabled(true);
			}
		}catch (NumberFormatException exception) {
		}
	}

	/**
	 * Swing worker nested class
	 *
	 */
	public class CounterWorker extends SwingWorker<Void, PrimeNumberObject> {
		private boolean stop;
		private JTextArea field;
		private IsPrime primeCalculator;
		private PrimeNumberObject primeNumber;
		
		public CounterWorker(JTextArea field2) {
			this.field = field2;
			this.stop = true;
			this.primeCalculator = new IsPrime();
			this.primeNumber = null;
		}			
		
		public void setStop() {
			this.stop = false;
		}
		
		protected void process(List<PrimeNumberObject> s) { 
			this.field.append(primeNumber.toString() + ", ");
		}

		@Override
		protected Void doInBackground() throws Exception {
			int counter = 0;
			for (int i = 0; i < 1000; i++) {
				try {
					if (this.primeCalculator.isPrime(i)) {
						counter++;
						primeNumber = new PrimeNumberObject(i, counter);
					}
					if (!this.stop) {
						break;
					}else {
					Thread.sleep(1000);
					} 
				} catch (InterruptedException e) {
				} 
				publish(primeNumber);
			}
			return null;
		}
	}

	public static void main(String[] args) {
		new SwingWorkers_PrimeCalculator();
	}
}