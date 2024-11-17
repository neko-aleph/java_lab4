import javax.swing.*;
import java.awt.*;

public final class Main implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main());
    }

    public void run() {
        JFrame frame = new JFrame("Simple Canvas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        DrawingPanel drawingPanel = new DrawingPanel();
        frame.add(drawingPanel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        // Панель "Цвет"
        JMenu colorMenu = new JMenu("Цвет");
        JPanel colorPanel = new JPanel(new GridLayout(3, 2));
        JSlider hueSlider = new JSlider(JSlider.HORIZONTAL, 0, 360, 0);
        JSlider saturationSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        JSlider brightnessSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);

        colorPanel.add(new JLabel("H"));
        colorPanel.add(hueSlider);
        colorPanel.add(new JLabel("S"));
        colorPanel.add(saturationSlider);
        colorPanel.add(new JLabel("B"));
        colorPanel.add(brightnessSlider);

        hueSlider.addChangeListener(e -> drawingPanel.setColor(hueSlider.getValue() / 360f, saturationSlider.getValue() / 100f, brightnessSlider.getValue() / 100f));
        saturationSlider.addChangeListener(e -> drawingPanel.setColor(hueSlider.getValue() / 360f, saturationSlider.getValue() / 100f, brightnessSlider.getValue() / 100f));
        brightnessSlider.addChangeListener(e -> drawingPanel.setColor(hueSlider.getValue() / 360f, saturationSlider.getValue() / 100f, brightnessSlider.getValue() / 100f));

        colorMenu.add(colorPanel);
        menuBar.add(colorMenu);

        // Панель "Толщина"
        JMenu thicknessMenu = new JMenu("Толщина");
        JSlider thicknessSlider = new JSlider(JSlider.HORIZONTAL, 1, 20, 1);
        thicknessSlider.addChangeListener(e -> drawingPanel.setThickness(thicknessSlider.getValue()));
        thicknessMenu.add(thicknessSlider);
        menuBar.add(thicknessMenu);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}
