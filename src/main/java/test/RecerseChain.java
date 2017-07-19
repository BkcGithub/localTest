package test;

import pojo.Node2;

/**
 * Created by bkc on 25/04/2017.
 */
public class RecerseChain {
    /**
     * 单链表反转
     *
     * @param head
     * @return
     */
    private static Node2 reverse(Node2 head) {

        if (head == null || head.getNext() == null) {
            return head;
        }

        Node2 currentNode = head;
        Node2 preNode = null;
        Node2 nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(preNode);
            preNode = currentNode;
            currentNode = nextNode;
        }

        return preNode;
    }

    public static void main(String[] args) {

        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        Node2 node4 = new Node2(4);
        Node2 node5 = new Node2(5);
        Node2 node6 = new Node2(6);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(null);

        Node2 reverseNode = reverse(node1);
        while (reverseNode != null) {
            System.out.println(reverseNode.getData());
            reverseNode = reverseNode.getNext();
        }
    }

    private static Node2 reverses(Node2 head) {

        if (head == null || head.getNext() == null) {
            return head;
        }

        Node2 currentNode = head;
        Node2 preNode = null;
        Node2 nextNode = null;
        while (null != currentNode) {

            nextNode = currentNode.getNext();
            currentNode.setNext(preNode);
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }
}
