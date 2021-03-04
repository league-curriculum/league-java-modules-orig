package _04_California_Weather;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * DO THIS STUFF
 */

public class CaliforniaWeatherSolution implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField field;
    JButton button;
    JTextArea area;
    HashMap<String,WeatherData> weatherData; 
    
    public static void main(String[] args) {
        new CaliforniaWeatherSolution().start();
    }
    
    public CaliforniaWeatherSolution() {
        area = new JTextArea(10,20);
        field = new JTextField(20);
        button = new JButton("Find");
        button.addActionListener(this);
        
        panel = new JPanel();
        panel.add(field);
        panel.add(button);
        panel.add(area);
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("California Weather Finder");
        frame.setPreferredSize(new Dimension(600, 200));
        frame.add(panel);
        frame.pack();
    }
    
    void start() {
        weatherData = Utilities.getWeatherData();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String cityName = field.getText();
        WeatherData datum = weatherData.get(cityName);
        
        if( datum == null ) {
            area.setText("Unable to find weather data for: " + cityName);
        } else {
            area.setText(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
        frame.pack();
    }
}
