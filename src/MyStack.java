import java.util.EmptyStackException;

public class MyStack {
    private Node top;
    private int size;

    private class Node {
        Object data;
        Node next;

        Node(Object value) {
            data = value;
            next = null;
        }
    }

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            top = top.next;
        } else {
            Node current = top;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void clear() {
        while (top != null) {
            Node next = top.next;
            top.next = null;
            top = next;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public Object pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        Object value = top.data;
        top = top.next;
        size--;
        return value;
    }
}