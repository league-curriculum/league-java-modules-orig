package _05_Intro_to_AVL_Trees;

import _03_Intro_to_Binary_Trees.Node;

public class AVLNode<T extends Comparable<T>> extends Node<T> {

    private AVLNode<T> left;
    private AVLNode<T> right;
    private int height;

    public AVLNode(T value) {
        super(value);
        this.height = 1;
    }
    
    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }
    
    public void setRight(AVLNode<T> right) {
        this.right = right;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public AVLNode<T> getLeft() {
        return this.left;
    }
    
    public AVLNode<T> getRight() {
        return this.right;
    }
    
    public int getHeight() {
        return this.height;
    }

}
