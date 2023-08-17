import java.util.Arrays;

class MyHashMap<K, V> {
    private Node<K, V>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int getIndex(K key) {
        if (key == null) {
            return 0; // Special handling for null key
        }
        return hash(key, table.length);
    }

    private int hash(K key, int capacity) {
        if (key == null) {
            return 0; // Special handling for null key
        }
        return Math.abs(key.hashCode()) % capacity;
    }

    @SuppressWarnings("unchecked")
    private void resizeTable() {
        int newCapacity = table.length * 2;
        Node<K, V>[] newTable = new Node[newCapacity];

        for (Node<K, V> node : table) {
            while (node != null) {
                Node<K, V> next = node.next;
                int newIndex = hash(node.key, newCapacity);
                node.next = newTable[newIndex];
                newTable[newIndex] = node;
                node = next;
            }
        }

        table = newTable;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            newNode.next = table[index];
            table[index] = newNode;
        }
        size++;

        if ((double) size / table.length > LOAD_FACTOR) {
            resizeTable();
        }
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> prev = null;
        Node<K, V> current = table[index];

        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
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
        Arrays.fill(table, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> current = table[index];

        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }
}