import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
    private final ArrayList<Point> points = new ArrayList<>();
    private Color currentColor = Color.BLACK;
    private int currentThickness = 1;

    public DrawingPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                addPoint(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                addPoint(e.getX(), e.getY());
            }
        });
    }

    private void addPoint(int x, int y) {
        points.add(new Point(x, y, currentColor, currentThickness));
        repaint();
    }

    public void setColor(float h, float s, float b) {
        currentColor = Color.getHSBColor(h, s, b);
    }

    public void setThickness(int thickness) {
        currentThickness = thickness;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Point point : points) {
            g2d.setColor(point.color);
            g2d.setStroke(new BasicStroke(point.thickness));
            g2d.fillRoundRect(point.x, point.y, point.thickness, point.thickness, point.thickness / 2, point.thickness / 2);
        }
    }
}
