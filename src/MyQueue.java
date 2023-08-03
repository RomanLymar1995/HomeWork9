import java.util.NoSuchElementException;

public class MyQueue {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        Object data;
        Node next;

        Node(Object value) {
            data = value;
            next = null;
        }
    }

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void clear() {
        while (front != null) {
            Node next = front.next;
            front.next = null;
            front = next;
        }
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    public Object poll() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        Object value = front.data;
        front = front.next;
        size--;
        return value;
    }
}