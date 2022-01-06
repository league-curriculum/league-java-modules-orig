package _06_How_Many_Are_Smaller_Than_Me;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

    /*
     * Given an AVLTree filled with the random numbers from 1 to 20, and a
     * single number within the AVL Tree, figure out how many numbers in the
     * AVLTree are bigger than the provided number and return the result.
     * 
     * You may want to create a helper method to search through the AVLTree and
     * count iteratively or recursively.
     */

    public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {

        return findTotal(avlTree.getRoot(),me);

    }
    
    public int findTotal(AVLNode<Integer> current, int me) {

        if (current == null) {
            return 0;
        } else if (current.getValue() >= me) {
            return findTotal(current.getLeft(), me);
        } else {

            return 1 + findTotal(current.getLeft(), me)
                    + findTotal(current.getRight(), me);
        }
    }

    /*
     * Longer iterative solution using depth first search
     */
//    public int findTotal(AVLNode<Integer> root, int me) {
//
//        Stack<AVLNode<Integer>> nodes = new Stack<>();
//        int total = 0;
//
//        nodes.add(root);
//
//        if (root.getValue() < me) {
//            total++;
//        }
//
//        while (!nodes.isEmpty()) {
//
//            AVLNode<Integer> current = nodes.pop();
//
//            if (current.getRight() != null) {
//                AVLNode<Integer> right = current.getRight();
//                nodes.add(right);
//                if (right.getValue() < me) {
//                    total++;
//                }
//            }
//
//            if (current.getLeft() != null) {
//                AVLNode<Integer> left = current.getLeft();
//                nodes.add(left);
//                if (left.getValue() < me) {
//                    total++;
//                }
//            }
//
//        }
//
//        return total;
//
//    }
    

}
