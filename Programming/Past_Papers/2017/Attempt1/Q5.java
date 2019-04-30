import java.awt.*;
import javax.swing.*;

public class Q5 implements Runnable {
  private JFrame frame;

  @Override
  public void run() {
    frame = new JFrame("x5");
    frame.setPreferredSize(new Dimension(600, 300));
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    createComponents(frame.getContentPane());
    frame.pack();
    frame.setVisible(true);
  }

  public JFrame getFrame() {
    return frame;
  }

  public void createComponents(Container box) {
    box.setLayout(new GridLayout(1,2));
    JPanel panel = new JPanel();
    JPanel container = new JPanel();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
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
    container.add(clear);
    container.add(quit);
    container.add(black);
    container.add(red);
    container.add(green);
    container.add(blue);
    Listener listen = new Listener(clear, quit, black, red, green, blue);
    clear.addActionListener(listen);
    quit.addActionListener(listen);
    black.addActionListener(listen);
    red.addActionListener(listen);
    blue.addActionListener(listen);
    box.add(panel);
    box.add(container);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Q5());
  }

}
