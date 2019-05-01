import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class GUI extends JFrame implements ActionListener {
  private JButton copy, clear;
  private JTextField input, output;
  public GUI() {
    this.setSize(500, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setup();
    this.setVisible(true);
    this.setTitle("Copier");
  }

  public void setup() {
    JPanel mainPanel = new JPanel(new GridLayout(2,1));
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
     copy = new JButton("Copy");
     clear = new JButton("Clear");
     input = new JTextField("Input Text");
     output = new JTextField(10);
    output.setEditable(false);
    copy.addActionListener(this);
    input.addActionListener(this);
    clear.addActionListener(this);
    JPanel secondaryPanel = new JPanel();
    panel.add(input);
    panel.add(output);
    secondaryPanel.add(copy);
    secondaryPanel.add(clear);
    mainPanel.add(panel);
    mainPanel.add(secondaryPanel);
    this.add(mainPanel);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == copy) {
      String line = input.getText();
      output.setText(line);
    } else if (e.getSource() == clear) {
      input.setText("");
      output.setText("");
    }
  }

  public static void main(String[] args) {
    new GUI();
  }
}
