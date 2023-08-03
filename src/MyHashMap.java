public class MyHashMap {
    private Node[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;


    private static class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(Object key, Object value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {

            newNode.next = table[index];
            table[index] = newNode;
        }
        size++;
    }

    public void remove(Object key) {
        int index = hash(key);
        Node prev = null;
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }
}