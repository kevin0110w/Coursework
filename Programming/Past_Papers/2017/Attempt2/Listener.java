import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener, MouseListener {
  private JButton clear, quit;
  private JRadioButton black, red, green, blue;
  private Component component;
  private Color color;
  private int x1, x2, y1, y2;

  public Listener(Component component, JButton clear, JButton quit, JRadioButton black, JRadioButton red, JRadioButton green, JRadioButton blue) {
    this.component = component;
    this.clear = clear;
    this.quit = quit;
    this.black = black;
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.clear) {
      public void clear();
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
    public void addLine(this.x1, this.y1, this.x2, this.y2; this.color);
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }
  @Override
  public void mouseEntered(MouseEvent e) {

     }
     @Override
     public void mouseExited(MouseEvent e) {

     }

}
