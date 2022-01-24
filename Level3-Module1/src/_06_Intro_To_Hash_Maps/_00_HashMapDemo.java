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
        System.out.print("The student at #35413 is: ");
        System.out.println(studentRoster.get(35413));

        /*
         * Getting the size (number of key-value pairs)
         */
        System.out.println("\nNumber of entries: " + studentRoster.size());
        
        /*
         * Iterating through all values with a for-each loop
         * NOTE: It's not possible to get the key from a value. This is
         * because different keys can be associated with the same value.
         */
        System.out.println("\nAll the values:");
        for(String s : studentRoster.values()){
            System.out.println(s);
        }
        
        /*
         * Updating the value of an existing key
         * NOTE: there are the same number of entries. This is because
         * duplicate keys in a hash map are NOT allowed.
         */
        System.out.println("\nChanging key 84565 to: Zany Zapper");
        studentRoster.put(84565, "Zany Zapper");
        
        /*
         * Iterating through all keys and values with a for-each loop
         */
        System.out.println("\nAll the key-value pairs:");
        for(Integer i : studentRoster.keySet()){
            System.out.println("key: " + i + ", value: " + studentRoster.get(i));
        }
    }
}
