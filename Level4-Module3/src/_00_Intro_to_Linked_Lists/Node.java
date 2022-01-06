package _00_Intro_to_Linked_Lists;

public class Node<T> {
    
    private T value;
    private Node<T> prev;
    private Node<T> next;
   
    
    public Node(T value) {
        this.value = value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }   
    
    public T getValue() {
        return this.value;
    }
    
    public Node<T> getPrev() {
        return this.prev;
    }
    
    public Node<T> getNext() {
        return this.next;
    }
}
