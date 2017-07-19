package LinkedListReversalOutput;

import pojo.Node;

import java.util.Stack;

/**
 * Created by bkc on 19/04/2017.
 */
public class ReversalOutput {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.nextNode = node2;
        node2.nextNode = node3;

        printTailToStartRec(node1);
        printTailToStartStack(node1);
    }

    private static void printTailToStartRec(Node start) {
        if (null != start) {
            if (null != start.nextNode) {
                printTailToStartRec(start.nextNode);
            }
            System.out.println(start.data);
        } else {
            System.out.println("error !");
        }
    }

    private static void printTailToStartStack(Node start) {

        if (null != start) {

            Stack<Node> stack = new Stack<Node>();
            while (start != null) {
                stack.push(start);
                start = start.nextNode;
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop().data);
            }

        } else {
            System.out.println("error !");
        }
    }

}
