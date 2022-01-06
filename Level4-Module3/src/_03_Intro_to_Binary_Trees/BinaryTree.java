package _03_Intro_to_Binary_Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    static final int SPACING = 5;

    public void insert(T value) {
        root = recursiveInsert(root, value);
    }

    public Node<T> search(T value) {

        Node<T> nodeQuery = recursiveSearch(root, value);

        if (nodeQuery == null) {

            System.out.println("NOT FOUND. RETURN VALUE IS NULL");
            return null;

        } else {
            System.out.println("FOUND VALUE: " + nodeQuery.getValue());
        }
        return nodeQuery;
    }

    public void delete(T value) {
        root = recursiveDelete(root, value);
    }

    public void printHorizontal() {
        recursivePrintHorizontal(root, 0);
    }

    public void printVertical() {

        int maxLevel = maxLevel(root);

        recursivePrintVertical(Collections.singletonList(root), 1, maxLevel);
    }

    public Node<T> getRoot() {
        return this.root;
    }

    /*
     * This method searches the references until it finds a null node at the
     * right spot to place the new value.
     * 
     * As described in the demo it will go down the left branch if the value
     * being inserted is smaller or down a right branch if the value being
     * inserted is larger.
     * 
     * No duplicate values are allowed.
     */
    private Node<T> recursiveInsert(Node<T> current, T value) {

        if (current == null) {
            return new Node<T>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {

            current.setLeft(recursiveInsert(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {

            current.setRight(recursiveInsert(current.getRight(), value));
        } else {
            return current;
        }

        return current;
    }

    /*
     * This method progresses through the tree in a similar manner to insert,
     * but stops whenever it finds a null meaning the data does not exist, or
     * finds the data it is looking for. The data it returns take the form of a
     * Node.
     */
    protected Node<T> recursiveSearch(Node<T> current, T value) {

        if (current == null) {
            return null;
        } else if (value.compareTo(current.getValue()) == 0) {
            return current;
        } else if (value.compareTo(current.getValue()) < 0) {

            return recursiveSearch(current.getLeft(), value);
        } else {

            return recursiveSearch(current.getRight(), value);
        }

    }

    /*
     * Deletion is a little bit more complicated.
     * 
     * The data is still searched through in the usual manner, but if a parent
     * node(a node that contains references to other nodes) is deleted then the
     * references must be updated and the best candidate from the child nodes is
     * selected to be the new parent.
     */

    protected Node<T> recursiveDelete(Node<T> current, T value) {
        if (current == null)
            return current;

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(recursiveDelete(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {

            current.setRight(recursiveDelete(current.getRight(), value));
        } else {

            if ((current.getLeft() == null) || (current.getRight() == null)) {
                Node<T> temp = null;
                if (temp == current.getLeft())
                    temp = current.getRight();
                else
                    temp = current.getLeft();

                if (temp == null) {
                    temp = current;
                    current = null;
                } else
                    current = temp;
            } else {

                Node<T> temp = findSmallestNode(current.getRight());

                current.setValue(temp.getValue());

                current.setRight(
                        recursiveDelete(current.getRight(), temp.getValue()));
            }
        }

        return current;

    }

    /*
     * This method prints out the BinaryTree starting with the root at the far
     * left on the console and the bottom leaves at the far right of the
     * console.
     * 
     * Each Node at the same level should be even with each other.
     * 
     * This method doesn't look as nice as vertical, but may be easier to read
     * on very large trees.
     */

    protected void recursivePrintHorizontal(Node<T> current, int space) {
        if (current == null)
            return;

        space += SPACING;

        recursivePrintHorizontal(current.getRight(), space);

        System.out.print("\n");
        for (int i = SPACING; i < space; i++)
            System.out.print(" ");

        System.out.print(current.getValue() + "\n");

        recursivePrintHorizontal(current.getLeft(), space);
    }

    /*
     * This method prints out the BinaryTree starting with the root at the very
     * top of the console and the bottom leaves at the bottom of the console.
     * 
     * Each Node at the same level should be even with each other.
     * 
     * This method looks nicer than horizontal, but may be harder to read on
     * very large trees.
     */

    protected void recursivePrintVertical(List<Node<T>> nodes, int level,
            int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {

                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        recursivePrintVertical(newNodes, level + 1, maxLevel);
    }
    
    //Helper methods
    
    protected int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight()))
                + 1;
    }

    protected Node<T> findSmallestNode(Node<T> current) {

        if (current.getLeft() == null) {
            return current;
        } else {
            return findSmallestNode(current.getLeft());
        }

    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}