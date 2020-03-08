package Lesson_6;

import java.util.NoSuchElementException;

public class Tree<Key extends Comparable<Key>, Value> {

     private class Node {
        Key key;        //ключ
        Value value;    //данные
        Node left;      //левый потомок
        Node right;     //правый потомок
        int size;       //кол-во узлов в поддереве, где данный узел выступает корнем
        int height;         //высота узла

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    private Node root = null;    //корень дерева

    public boolean isBalance() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if (root == null) {
            return true;  //потомка не существует
        } else {
            int lh = heightOfBinaryTree(root.left);
            int rh = heightOfBinaryTree(root.right);
            System.out.println("  ROOT  ");
            System.out.println(" /    \\ ");
            System.out.println(lh + "      " + rh);
            if (Math.abs(lh - rh) > 1) {
                return false; //не сбалансированы
            }
        }
        return true;           //сбалансированы
    }

    public int heightOfBinaryTree() {
        return heightOfBinaryTree(root);
    }

    private int heightOfBinaryTree(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 +
                    Math.max(heightOfBinaryTree(node.left),
                            heightOfBinaryTree(node.right));
        }
    }


    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return this.size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("The key can not be  Null");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("The key can not be Null");
        }
        root = put(root, key, value);
    }
}
