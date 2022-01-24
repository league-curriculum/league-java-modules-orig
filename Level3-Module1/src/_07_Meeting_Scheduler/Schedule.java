package _07_Meeting_Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Schedule {
    private HashMap<String, ArrayList<Integer>> weeklyAvailability;
    
    public Schedule() {
        weeklyAvailability = new HashMap<>();
        weeklyAvailability.put("Monday", new ArrayList<Integer>());
        weeklyAvailability.put("Tuesday", new ArrayList<Integer>());
        weeklyAvailability.put("Wednesday", new ArrayList<Integer>());
        weeklyAvailability.put("Thursday", new ArrayList<Integer>());
        weeklyAvailability.put("Friday", new ArrayList<Integer>());
        weeklyAvailability.put("Saturday", new ArrayList<Integer>());
        weeklyAvailability.put("Sunday", new ArrayList<Integer>());
    }
    
    /*
     * Use this method in your solution
     */
    public HashMap<String, ArrayList<Integer>> getSchedule(){
        return weeklyAvailability;
    }
    
    public void printSchedule() {
        System.out.println("+---------+----------");
        for( String dayOfWeek : weeklyAvailability.keySet() ) {
            System.out.println("|" + String.format("%-9s", dayOfWeek) + "| " + weeklyAvailability.get(dayOfWeek));
        }
        System.out.println("+---------+----------");
    }
    
    public void addAvailability( String day, Integer startTime ){
        String dayOfTheWeek = day;
        
        // Capitalize first letter to match HashMap key entries
        if(dayOfTheWeek.length() > 1) {
            String firstLetter = dayOfTheWeek.substring(0, 1);
            String remainingLetters = dayOfTheWeek.substring(1, dayOfTheWeek.length());

            dayOfTheWeek = firstLetter.toUpperCase() + remainingLetters.toLowerCase();
        }
        
        if( weeklyAvailability.containsKey(dayOfTheWeek) ) {
            // Valid day of the week
            
            if( startTime >= 0 && startTime<= 23 ) {
                // Start time is between 0 and 23
                
                ArrayList<Integer> startTimes = weeklyAvailability.get(dayOfTheWeek);
                startTimes.add(startTime);
            } else {
                JOptionPane.showMessageDialog(null, "Start time should be an integer >= 0 and <= 23");
            }
        } else {
            JOptionPane.showMessageDialog(null, dayOfTheWeek + " is not a day of the week!");
        }
    }
}
