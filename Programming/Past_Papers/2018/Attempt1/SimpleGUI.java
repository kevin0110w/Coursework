import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUI extends JFrame implements ActionListener {
  private JTextField inputField, outputField;
  private JButton copyButton;

  public SimpleGUI() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300, 300);
    JPanel contentPanel = new JPanel();
    this.add(contentPanel);

    inputField = new JTextField("some text");
    contentPanel.add(inputField);
    outputField = new JTextField(10);
    contentPanel.add(outputField);
    copyButton = new JButton("copy");
    copyButton.addActionListener(this);

    contentPanel.add(copyButton);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == copyButton) {
      String text = inputField.getText();
      outputField.setText(text);
      inputField.setText("");
    }
  }

    public static void main(String[] args) {
      new SimpleGUI();
    }
}
