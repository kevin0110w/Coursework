import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener  {
  JButton clear, quit;
  JRadioButton black, red, green, blue;
  Color color;
  int x1, x2, y1, y2;

  public Listener(JButton clear, JButton quit, JRadioButton black, JRadioButton red,JRadioButton green,JRadioButton blue) {
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
      // clear();
      // repaint();
    } else if (e.getSource() == this.quit) {
      System.exit(0);
    } else if (e.getSource() == this.black) {
      this.color = Color.BLACK;
    }else if (e.getSource() == this.red) {
      this.color = Color.RED;
    }else if (e.getSource() == this.green) {
      this.color = Color.GREEN;
    }else if (e.getSource() == this.blue) {
      this.color = Color.BLUE;
    }
  }

  //
  // public void mousePressed(MouseEvent e) {
  //     e.getX() = this.x1;
  //     e.getY() = this.y2;
  // }
  //
  //
  // public void mouseReleased(MouseEvent e) {
  //     e.getX() = this.x2;
  //     e.getY() = this.y2;
  //     // addLine(this.x1, this.y1, this.x2, this.y2, this.color);
  //     // repaint();
  // }
  //
  // public void mouseEntered(MouseEvent e) {
  //
  // }
  //
  // public void mouseExited(MouseEvent e) {
  //
  //   }
  //
  // public void mouseClicked(MouseEvent e) {
  //
  //   }
}
