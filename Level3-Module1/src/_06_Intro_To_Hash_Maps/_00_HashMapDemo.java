package _06_Intro_To_Hash_Maps;

import java.util.HashMap;

public class _00_HashMapDemo {
    public static void main(String[] args) {
        
        /*
         * Declare and Initializing a HashMap of id's and students
         */
        HashMap<Integer, String> studentRoster = new HashMap<Integer, String>();

        studentRoster.put(75869, "Danny Ditko");
        studentRoster.put(15684, "Tiana Tickles");
        studentRoster.put(87561, "Freddy Farewell");
        studentRoster.put(96546, "Willy Wham");
        studentRoster.put(35413, "Janet Jam");
        studentRoster.put(84565, "Ziggy Zam");

        /*
         * Getting a value from a key
         */
        System.out.println("The student at #35413 is: ");
        System.out.println(studentRoster.get(35413));

        /*
         * Iterating through all values with a for-each loop
         */
        System.out.println("\nAll the vales:");
        for(String s : studentRoster.values()){
            System.out.println(s);
        }

        /*
         * Iterating through all keys with a for-each loop
         */
        System.out.println("\nAll the keys:");
        for(Integer i : studentRoster.keySet()){
            System.out.println(i);
        }

        System.out.println(Math.sqrt(3));
    }
}
