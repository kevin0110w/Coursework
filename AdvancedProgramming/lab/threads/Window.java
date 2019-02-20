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


	public class CounterWorker extends SwingWorker<Void, Integer> {
		private int startNumber;
		private boolean stop = true;
		private JTextField field;

		public CounterWorker(int number, JTextField field) {
			this.startNumber= number;
			this.field = field;
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
