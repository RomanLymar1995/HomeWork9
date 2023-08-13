import java.util.NoSuchElementException;

class MyQueue<T> {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        T data;
        Node next;

        Node(T value) {
            data = value;
            next = null;
        }
    }

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void add(T value) {
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

    public T peek() {
        if (front == null) {
            throw new NoSuchElementException("Очередь пуста");
        }
        return front.data;
    }

    public T poll() {
        if (front == null) {
            throw new NoSuchElementException("Очередь пуста");
        }
        T value = front.data;
        front = front.next;
        size--;
        return value;
    }
}
