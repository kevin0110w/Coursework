import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Q5Component1 extends JFrame implements ActionListener, MouseListener {
  private JButton clear, quit;
  private JRadioButton black, red, green, blue;
  private Component component;
  private Color color;
  private int x1, x2, y1, y2;
  private ButtonGroup b;

  public Q5Component1() {
    this.setLayout(new GridLayout(1,2));
		this.setSize(500,300); //set default size of window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set to close if red cross button pressed
		setup();
		this.setVisible(true);
    this.setTitle("X5"); // set window title
  }

  public void setup() {
    JPanel rightPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    clear = new JButton("Clear");
    quit = new JButton("Quit");
    b = new ButtonGroup();
    black = new JRadioButton("Black");
    red = new JRadioButton("Red");
    green = new JRadioButton("Green");
    blue = new JRadioButton("Blue");
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
    this.add(leftPanel);
    this.add(rightPanel);
    clear.addActionListener(this);
    quit.addActionListener(this);
    black.addActionListener(this);
    red.addActionListener(this);
    green.addActionListener(this);
    blue.addActionListener(this);
  }

  public static void main(String[] args) {
    new Q5Component1();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.clear) {
      // public void clear();
    } else if (e.getSource() == this.quit) {
      System.exit(0);
    } else if (e.getSource() == this.black) {
      this.color = Color.BLACK;
      System.out.println(this.color);
    }
    else if (e.getSource() == this.red) {
      this.color = Color.RED;
      System.out.println(this.color);
    }
    else if (e.getSource() == this.green) {
      this.color = Color.GREEN;
      System.out.println(this.color);
    }
    else if (e.getSource() == this.blue) {
      this.color = Color.BLUE;
      System.out.println(this.color);
    }
  }
  @Override
  public void mousePressed(MouseEvent e) {
    this.x1 = e.getX();
    this.y1 = e.getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    this.x2 = e.getX();
    this.y2 = e.getY();
    // public void addLine(this.x1, this.y1, this.x2, this.y2; this.color);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    return;
  }
  @Override
  public void mouseEntered(MouseEvent e) {
    return;
  }
 @Override
 public void mouseExited(MouseEvent e) {
    return;
  }
}
