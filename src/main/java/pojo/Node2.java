package pojo;

/**
 * Created by bkc on 25/04/2017.
 */
public class Node2 {
    private int data;

    /**
     * 下一个节点
     */
    private Node2 next;

    public Node2(int data) {
        super();
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }
}
