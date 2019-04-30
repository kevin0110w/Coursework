import java.awt.*;
import javax.swing.*;

public class Q5Component implements Runnable {
  private JFrame frame;

  @Override
  public void run() {
    frame = new JFrame();
    frame.setTitle("X5");
    frame.setPreferredSize(new Dimension(500, 300));
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    createComponents(frame.getContentPane());
    frame.pack();
    frame.setVisible(true);
  }

  public void createComponents(Container container) {
    GridLayout layout = new GridLayout(1,2);
    container.setLayout(layout);
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    JButton clear = new JButton("Clear");
    JButton quit = new JButton("Quit");
    ButtonGroup b = new ButtonGroup();
    JRadioButton black = new JRadioButton("Black");
    JRadioButton red = new JRadioButton("Red");
    JRadioButton green = new JRadioButton("Green");
    JRadioButton blue = new JRadioButton("Blue");
    b.add(black);
    b.add(red);
    b.add(green);
    b.add(blue);
    rightPanel.add(clear);
    rightPanel.add(quit);
    rightPanel.add(black);
    rightPanel.add(red);
    rightPanel.add(green);
    rightPanel.add(blue);
    container.add(leftPanel);
    container.add(rightPanel);
    clear.addActionListener(new Listener(leftPanel, clear, quit, black, red, green, blue));
    quit.addActionListener(new Listener(leftPanel, clear, quit, black, red, green, blue));
    black.addActionListener(new Listener(leftPanel, clear, quit, black, red, green, blue));
    red.addActionListener(new Listener(leftPanel, clear, quit, black, red, green, blue));
    green.addActionListener(new Listener(leftPanel, clear, quit, black, red, green, blue));
    blue.addActionListener(new Listener(leftPanel, clear, quit, black, red, green, blue));
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Q5Component());
  }
}
