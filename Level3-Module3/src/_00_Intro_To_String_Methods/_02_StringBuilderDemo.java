package _00_Intro_To_String_Methods;

public class _02_StringBuilderDemo {
public static void main(String[] args) {
    /*
     * StringBuilder is a class that lets you build a String from an list.
     * Why is the StringBuilder class even needed if we can make a String by
     * just doing: String str = "Why do we need StringBuilder?"
     * 
     * Since Strings are immutable (unchangeable), making modifications to a
     * String can mean creating another entirely new String and copying over
     * any characters from the original String in order to make he new one.
     * For example the code:
     *   String newStr = oldStr + "s";
     *
     * Here there are potentially 2 new Strings that are created just to add
     * a "s" at the end of oldStr. This is very inefficient. A more efficient
     * way to do this would be to add space for 1 more character at the end of
     * oldStr and insert the "s". This can't be done because in Java Strings
     * are immutable.
     * 
     * This is where StringBuilder comes in. StringBuilder is mutable
     * (changeable) and only finalizes the characters into a String when the
     * toString() method is called. This means our code can be much more
     * efficient than Strings, especially when adding or removing characters
     * many times.
     * 
     * Below is a demo on how to use StringBuilder.
     */
    
    // Declaring and initializing a StringBilder object
    StringBuilder builder = new StringBuilder("This is a StringBuilder");
    
    // Converting the StringBuilder object into a String
    System.out.println("toString ....: " + builder.toString());
    
    // Appending characters to the end of a String
    System.out.println("append ......: " + builder.append(" append").toString());
    
    // Reversing a StringBuilder object
    System.out.println("reverse .....: " + builder.reverse().toString());
    builder.reverse();
    
    // Deleting a single character
    System.out.println("delete 0 ....: " + builder.deleteCharAt(0).toString());
    
    // Inserting a single character
    System.out.println("insert 0 ....: " + builder.insert(0, 'T'));
    
    // Deleting a range of characters
    System.out.println("delete 5 to 7: " + builder.delete(5, 7).toString());
    
    // Inserting multiple characters (you can also do "is" instead of char[])
    System.out.println("insert 5 to 7: " + builder.insert(5, new char[] {'i', 's'}));
    
    // Replacing a range of characters
    System.out.println("replace .....: " + builder.replace(0, 4, "Replaced").toString());
    
    // Using String methods in conjunction with StringBuilder
    System.out.println("SB & String .: " + builder.toString().replace(' ', '_').trim());
    
    char[] chars = { 'a', 'b', 'c' };
    System.out.println(new String(chars));
}
}
