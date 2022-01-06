package _01_Spies_On_A_Train;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	
    	HashMap<String,Integer> suspects = new HashMap<String,Integer>();

    	System.out.println(Arrays.toString(clues));
    	
    	Node<TrainCar> passenger = train.getHead();
    	
    	while(passenger != null) {
    		
    		String questioning = passenger.getValue().questionPassenger();
    		int clueIndex = questioning.indexOf("?");
    		String testimony = questioning.substring(clueIndex);
    		String suspect = testimony.trim().split(" ")[3];
    		
    		for (int i = 0; i < clues.length; i++) {
    			
    			String clue = clues[i];
    			
    			if(testimony.contains(clue)) {
    				
    				if(suspects.containsKey(suspect)) {
    					suspects.put(suspect, suspects.get(suspect) + 1);
    				}
    				else {
    					suspects.put(suspect, 1);
    				}
    			}
				
			}
    		
    		passenger = passenger.getNext();
    	}
    	
    	for(String suspect : suspects.keySet()) {
    		
    		if(suspects.get(suspect) == 3) {
    			return suspect;
    		}
    		
		}
		
		return null;
    }
}