import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class DrawingCanvas extends JPanel {
    private String shapeType = "Line";
    private Color shapeColor = Color.BLACK;
    public DrawingCanvas() {
        setPreferredSize(new Dimension(500, 350));
        setBackground(Color.WHITE);
    }
    public void updateShape(String shapeType, Color shapeColor) {
        this.shapeType = shapeType;
        this.shapeColor = shapeColor;
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(shapeColor);
        if (shapeType.equals("Line")) {
            g.drawLine(150, 75, 350, 275);
        } else if (shapeType.equals("Rectangle")) {
            g.fillRect(150, 75, 200, 200);
        } else if (shapeType.equals("Oval")) {
            g.fillOval(150, 75, 200, 200);
        }
    }
}
class ShapeDrawerFrame extends JFrame {
    private JTextField rField, gField, bField;
    private JComboBox<String> shapeMenu;
    private DrawingCanvas canvas;
    public ShapeDrawerFrame() {
        setTitle("Shape & Color Form");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 10));
        formPanel.add(new JLabel("R:")); formPanel.add(rField = new JTextField("0", 3));
        formPanel.add(new JLabel("G:")); formPanel.add(gField = new JTextField("0", 3));
        formPanel.add(new JLabel("B:")); formPanel.add(bField = new JTextField("0", 3));
        formPanel.add(new JLabel("Shape:"));
        formPanel.add(shapeMenu = new JComboBox<>(new String[]{"Line", "Rectangle", "Oval"}));
        JButton drawButton = new JButton("Draw");
        formPanel.add(drawButton);
        canvas = new DrawingCanvas();
        add(formPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int r = Integer.parseInt(rField.getText().trim());
                    int g = Integer.parseInt(gField.getText().trim());
                    int b = Integer.parseInt(bField.getText().trim());
                    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
                        JOptionPane.showMessageDialog(null, "RGB values must be 0-255.");
                        return;
                    }
                    canvas.updateShape((String) shapeMenu.getSelectedItem(), new Color(r, g, b));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter valid integers.");
                }
            }
        });
    }
}
public class ShapeDrawer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShapeDrawerFrame().setVisible(true);
            }
        });
    }
}
