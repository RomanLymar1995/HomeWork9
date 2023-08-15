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
        Node current = getNodeByIndex(index);

        if (index == 0) {
            top = top.next;
        } else {
            Node prev = getNodeByIndex(index - 1);
            prev.next = current.next;
        }
        size--;
    }

    private Node getNodeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
        }

        Node current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public void clear() {
        top = null;
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

