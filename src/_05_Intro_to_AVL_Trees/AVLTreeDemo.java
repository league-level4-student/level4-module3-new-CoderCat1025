package _05_Intro_to_AVL_Trees;

import _03_Intro_to_Binary_Trees.BinaryTree;

public class AVLTreeDemo {

    /*
     * An AVLTree is a special BinaryTree that is capable of balancing itself.
     * With a regular binary tree, depending on the elements inserted, you might
     * have a root with one very long right branch and one very long left branch
     * with nothing else in between.
     * 
     * 1.) Read through the AVLNode and AVLTree. Notice that the methods are
     * similar to those in BinaryTree with two important distinctions:
     * 
     * a) Each Node has a balance factor that keeps track of how many levels
     * "down" it is relative to the rest of the tree.
     * 
     * b) There are "rotate" helper methods used when a given node gets too
     * unbalanced(> 1 level out of sync with the rest of the tree) to rotate
     * branches back into place.
     * 
     * 2.) Create a BinaryTree and an AVLTree.
     * 
     * 3.) Insert the same values into both trees and observe how they differ
     * using the print method. Make sure the values you pick unbalance the
     * binary tree.
     * 
     * 4.) Try removing elements from both and see how they change using one of
     * the print methods.
     */

    public static void main(String[] args) {
    	BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(3);
		tree.insert(69420);
		tree.insert(42069);
		tree.insert(420);
		tree.insert(69);
		tree.insert(1);
		tree.insert(2);
		tree.insert(10);
		
		AVLTree<Integer> otherTree = new AVLTree<Integer>();
		otherTree.insert(3);
		otherTree.insert(69420);
		otherTree.insert(42069);
		otherTree.insert(420);
		otherTree.insert(69);
		otherTree.insert(1);
		otherTree.insert(2);
		otherTree.insert(10);
		
		tree.printVertical();
		otherTree.printVertical();
    }

}
