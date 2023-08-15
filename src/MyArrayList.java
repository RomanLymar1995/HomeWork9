import java.util.Arrays;

class MyArrayList<T> {
    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        if (size == data.length) {
            ensureCapacity();
        }
        data[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    public void clear() {
        Arrays.fill(data, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
        }
        return (T) data[index];
    }

    private void ensureCapacity() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }
}
