package _01_The_Wave;

import java.util.ArrayList;

public class _01_TheWave {
    /*
     * Background:
     * "The wave (known as the Mexican wave in the English-speaking world
     * outside North America) is an example of metachronal rhythm achieved in a
     * packed stadium when successive groups of spectators briefly stand, yell,
     * and raise their arms. Immediately upon stretching to full height, the
     * spectator returns to the usual seated position. The result is a wave of
     * standing spectators that travels through the crowd, even though
     * individual spectators never move away from their seats. In many large
     * arenas the crowd is seated in a contiguous circuit all the way around
     * the sport field, and so the wave is able to travel continuously around
     * the arena; in discontiguous seating arrangements, the wave can instead
     * reflect back and forth through the crowd. When the gap in seating is
     * narrow, the wave can sometimes pass through it. Usually only one wave
     * crest will be present at any given time in an arena, although
     * simultaneous, counter-rotating waves have been produced."
     * (Source Wikipedia https://en.wikipedia.org/wiki/Wave_%28audience%29) 
     */
    
    /*
     * Task:
     * Your task is to create a function that turns a string into a Wave.
     * You will be passed a string and you must return that string in an
     * ArrayList where an uppercase letter is a person standing up.
     * Example:
     * wave("hello") => "Hello", "hEllo", "heLlo", "helLo", "hellO"
     * 
     * 1. The input string will always be lower case but maybe empty.
     * 2. If the character in the string is whitespace then pass over it as
     *    if it was an empty seat.
     */
    
    public static ArrayList<String> wave(String str) {
        ArrayList<String> waves = new ArrayList<>();
        
        for( int i = 0; i < str.length(); i++ ){
          char currLetter = str.charAt(i);
          
          if( Character.isAlphabetic( currLetter ) ){
            waves.add( str.substring(0,i) + Character.toUpperCase(currLetter) + str.substring(i+1) );
          }
        }
        
        return waves;
    }
}
