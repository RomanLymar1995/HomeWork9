public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Object data;
        Node prev;
        Node next;

        Node(Object value) {
            data = value;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        current.prev = null;
        current.next = null;
        size--;
    }

    public void clear() {
        while (head != null) {
            Node next = head.next;
            head.prev = null;
            head.next = null;
            head = next;
        }
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }
}