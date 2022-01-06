package _05_Intro_to_AVL_Trees;

import java.util.Collections;

import _03_Intro_to_Binary_Trees.BinaryTree;
import _03_Intro_to_Binary_Trees.Node;
import _04_Morse_Code.MorseCode;

public class AVLTree<T extends Comparable<T>> extends BinaryTree<T> {

    private AVLNode<T> root;

    public void insert(T value) {
        root = avlRecursiveInsert(root, value);
    }

    @Override
    public AVLNode<T> search(T value) {

        AVLNode<T> nodeQuery = (AVLNode<T>) recursiveSearch(root, value);

        if (nodeQuery == null) {
            System.out.println("NOT FOUND. RETURN VALUE IS NULL");
            return null;

        } else {
            System.out.println("FOUND VALUE: " + nodeQuery.getValue());
            return nodeQuery;
        }

    }

    @Override
    public void printHorizontal() {
        recursivePrintHorizontal(root, 0);
    }
    
    @Override
    public void printVertical() {
        int maxLevel = maxLevel(root);

        recursivePrintVertical(Collections.singletonList(root), 1, maxLevel);
    }

    public void delete(T value) {
        root = avlRecursiveDelete(root, value);
    }
    
    public AVLNode<T> getRoot() {
        return this.root;
    }

    private AVLNode<T> avlRecursiveInsert(AVLNode<T> current, T value) {

        if (current == null) {
            return new AVLNode<T>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {

            current.setLeft(avlRecursiveInsert(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {

            current.setRight(avlRecursiveInsert(current.getRight(), value));
        } else {
            return current;
        }

        current.setHeight(
                Math.max(height(current.getLeft()), height(current.getRight()))
                        + 1);

        int balanceFactor = getBalanceFactor(current);

        if (balanceFactor > 1
                && value.compareTo(current.getLeft().getValue()) < 0)
            return rightRotate(current);

        if (balanceFactor < -1
                && value.compareTo(current.getRight().getValue()) > 0)
            return leftRotate(current);

        if (balanceFactor > 1
                && value.compareTo(current.getLeft().getValue()) > 0) {
            current.setLeft(leftRotate(current.getLeft()));
            return rightRotate(current);
        }

        if (balanceFactor < -1
                && value.compareTo(current.getRight().getValue()) < 0) {
            current.setRight(rightRotate(current.getRight()));
            return leftRotate(current);
        }

        return current;
    }

    private AVLNode<T> avlRecursiveDelete(AVLNode<T> current, T value) {
        if (current == null)
            return current;

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(avlRecursiveDelete(current.getLeft(), value));
        }
        else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(avlRecursiveDelete(current.getRight(), value));
        }
        else {

            if ((current.getLeft() == null) || (current.getRight() == null)) {
                AVLNode<T> temp = null;
                if (temp == current.getLeft())
                    temp = current.getRight();
                else
                    temp = current.getLeft();

                if (temp == null) {
                    temp = current;
                    current = null;
                } else {
                    current = temp;
                }
            } else {

                AVLNode<T> temp = (AVLNode<T>) findSmallestNode(
                        current.getRight());

                current.setValue(temp.getValue());

                current.setRight(avlRecursiveDelete(current.getRight(),
                        temp.getValue()));
            }
        }

        if (current == null) {
            return current;
        }

        current.setHeight(
                Math.max(height(current.getLeft()), height(current.getRight()))
                        + 1);

        int balanceFactor = getBalanceFactor(current);

        if (balanceFactor > 1 && getBalanceFactor(current.getLeft()) >= 0) {
            return rightRotate(current);
        }

        if (balanceFactor > 1 && getBalanceFactor(current.getLeft()) < 0) {
            current.setLeft(leftRotate(current.getLeft()));
            return rightRotate(current);
        }

        if (balanceFactor < -1 && getBalanceFactor(current.getRight()) <= 0)
            return leftRotate(current);

        if (balanceFactor < -1 && getBalanceFactor(current.getRight()) > 0) {
            current.setRight(rightRotate(current.getRight()));
            return leftRotate(current);
        }

        return current;
    }

    private AVLNode<T> rightRotate(AVLNode<T> current) {
        AVLNode<T> currentLeft = current.getLeft();
        AVLNode<T> currentLeftRight = currentLeft.getRight();

        currentLeft.setRight(current);
        current.setLeft(currentLeftRight);

        current.setHeight(
                Math.max(height(current.getLeft()), height(current.getRight()))
                        + 1);
        currentLeft.setHeight(Math.max(height(currentLeft.getLeft()),
                height(currentLeft.getRight())) + 1);

        return currentLeft;
    }

    private AVLNode<T> leftRotate(AVLNode<T> current) {
        AVLNode<T> currentRight = current.getRight();
        AVLNode<T> currentRightLeft = currentRight.getLeft();

        currentRight.setLeft(current);
        current.setRight(currentRightLeft);

        current.setHeight(
                Math.max(height(current.getLeft()), height(current.getRight()))
                        + 1);
        currentRight.setHeight(Math.max(height(currentRight.getLeft()),
                height(currentRight.getRight())) + 1);

        return currentRight;
    }

    private int height(AVLNode<T> current) {
        if (current == null)
            return 0;
        return current.getHeight();
    }

    private int getBalanceFactor(AVLNode<T> current) {
        if (current == null)
            return 0;
        return height(current.getLeft()) - height(current.getRight());
    }

}
