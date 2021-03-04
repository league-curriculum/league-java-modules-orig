package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
        return new StringBuilder(str).append(characters).toString();
    }
    
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public static String insert(String str, int index, char newChar) {
        return new StringBuilder(str).insert(index, newChar).toString();
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
        return new StringBuilder(str).delete(startIndex, endIndex).toString();
    }
}