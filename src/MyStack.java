import java.util.EmptyStackException;

class MyStack<T> {
    private Node top;
    private int size;

    private class Node {
        T data;
        Node next;

        Node(T value) {
            data = value;
            next = null;
        }
    }

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(T value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
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

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }
}