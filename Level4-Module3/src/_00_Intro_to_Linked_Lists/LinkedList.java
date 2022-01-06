package _00_Intro_to_Linked_Lists;

public class LinkedList<T> {

    /*
     * The head and tail contain references that point to the first and last
     * elements of the LinkedList respectively.
     * 
     * These must be updated if elements are headed to the front or back, but
     * allow for easy entry points into the LinkedList.
     */
    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {

        if (head == null) {
            head = new Node<T>(value);
        } else {

            Node<T> prev = head;
            Node<T> next = head.getNext();

            while (next != null) {
                prev = prev.getNext();
                next = next.getNext();
            }

            next = new Node<T>(value);
            prev.setNext(next);
            next.setPrev(prev);
            tail = next;
        }
    }

    public void remove(int position) {

        if (head == null) {
            System.out.println("No items to remove!");
        } else if (position == 0) {

            head = head.getNext();

            if (head != null) {
                head.setPrev(null);
            }

        } else {

            int positionCounter = 1;
            Node<T> prev = head;
            Node<T> next = head.getNext();

            while (positionCounter < position) {

                prev = prev.getNext();
                next = next.getNext();
                positionCounter++;

            }

            if (positionCounter == position && next != null) {

                next = next.getNext();
                prev.setNext(next);

                if (next != null) {
                    next.setPrev(prev);
                }
            } else {
                System.out.println("Position not found!");
            }
        }

    }

    public void print() {
        if (head == null) {
            System.out.println("No items in list!");
        } else {

            Node<T> next = head;

            while (next != null) {

                System.out.print(next.getValue().toString() + " <-> ");
                next = next.getNext();

            }

            System.out.println();

        }

    }

    public int size() {
        int size = 0;
        if (head != null) {

            Node<T> next = head;

            while (next != null) {

                next = next.getNext();
                size++;

            }

        }
        return size;

    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

}
