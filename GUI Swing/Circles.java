import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
class ConcentricCirclesPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        Random rand = new Random();
        int centerX = 250; 
        int centerY = 250;
        int maxRadius = 200;
        int step = 10;
        for (int r = maxRadius; r > 0; r -= step) {
            int red = rand.nextInt(256);
            int green = rand.nextInt(256);
            int blue = rand.nextInt(256);
            g.setColor(new Color(red, green, blue));
            int x = centerX - r;
            int y = centerY - r;
            int diameter = r * 2;
            g.drawOval(x, y, diameter, diameter);
        }
    }
}
public class Circles {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Suvam: Concentric Circles");
        ConcentricCirclesPanel panel = new ConcentricCirclesPanel();       
        frame.add(panel);
        frame.setSize(520, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
