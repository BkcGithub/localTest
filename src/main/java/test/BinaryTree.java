package test;

/**
 * Created by bkc on 04/05/2017.
 */
public class BinaryTree {

    private Node root;


    private class Node {
        private Node left;
        private Node right;
        private int data;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree() {
        root = null;
    }

    /**
     * 递归创建二叉树
     *
     * @param node
     * @param data
     */
    public void buildTree(Node root, int data) {

        if (null == root) {
            root = new Node(data);
        } else {
            if (data < root.data) {
                if (root.left == null) {
                    root.left = new Node(data);
                } else {
                    buildTree(root.left, data);
                }
            } else {
                if (root.right == null) {
                    root.right = new Node(data);
                } else {
                    buildTree(root.right, data);
                }
            }
        }
    }

    /**
     * 先序遍历
     *
     * @param node
     */
    public void preOrder(Node node) {

        if (null != node) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrder(Node node) {
        if (null != node) {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
    }

    /**
     * 后续遍历
     *
     * @param node
     */
    public void postOrder(Node node) {
        if (null != node) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9};
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < data.length; i++) {
            binaryTree.buildTree(binaryTree.root, data[i]);
        }

        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrder(binaryTree.root);
    }
}
