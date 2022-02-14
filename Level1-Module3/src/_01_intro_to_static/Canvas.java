package _01_intro_to_static;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class Canvas {
    static int WIDTH = 1200;
    static int HEIGHT = 800;

    JFrame frame;
    JPanel mainPanel, gamePanel, sliderPanel;

    ArrayList<Circle> circles;

    public Canvas() {
        circles = new ArrayList<>();

        frame = new JFrame();
        frame.setTitle("Static Keyword Demo");
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        gamePanel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                for (Circle circle : circles) {
                    circle.draw(g);
                }
            }
        };

        gamePanel.setPreferredSize(new Dimension(WIDTH, (9 * HEIGHT) / 10));
        sliderPanel = new JPanel();
        sliderPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 10));

        mainPanel.add(sliderPanel);
        mainPanel.add(gamePanel);
        frame.add(mainPanel);

        gamePanel.repaint();
        frame.pack();
    }

    public void addCircle(Circle circle) {
        circles.add(circle);

        // Must place after adding new circle
        // no size - 1 to number starting from 1
        final int num = circles.size();
        
        JSlider colorSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 100);
        colorSlider.setPreferredSize(new Dimension(75, 50));

        JSlider radiusSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 100);
        radiusSlider.setPreferredSize(new Dimension(75, 50));

        JLabel colorSliderLabel = new JLabel("#" + num + " Color " + String.format("%3s", colorSlider.getValue()));
        JLabel radiusSliderLabel = new JLabel("#" + num + " Radius " + String.format("%3s", radiusSlider.getValue()));

        colorSlider.addChangeListener((e) -> {
            int value = colorSlider.getValue();
            colorSliderLabel.setText("#" + num + " Color" + String.format("%3s", value));

            circles.get(num-1).color = new Color(value, value, value);
            frame.repaint();
        });

        radiusSlider.addChangeListener((e) -> {
            int value = radiusSlider.getValue();
            radiusSliderLabel.setText("#" + num + " Size " + String.format("%3s", value));

            circles.get(num-1).radius = value;
            frame.repaint();
        });

        sliderPanel.add(radiusSliderLabel);
        sliderPanel.add(radiusSlider);
        sliderPanel.add(colorSliderLabel);
        sliderPanel.add(colorSlider);
        frame.pack();
    }
}
