import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
class SmileyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.YELLOW);
        g.fillOval(100, 50, 200, 200);
        g.setColor(Color.BLACK);
        g.drawOval(100, 50, 200, 200);
        g.fillOval(155, 110, 25, 25);
        g.fillOval(220, 110, 25, 25);
        g.drawOval(195, 145, 10, 20);
        g.drawArc(150, 160, 100, 50, 180, 180);
    }
}
public class SmileyFace {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Suvam: Smiley Face");
        SmileyPanel panel = new SmileyPanel();       
        frame.add(panel);
        frame.setSize(420, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
