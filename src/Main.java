import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        demonstrateLinkedList();
        demonstrateQueue();
        demonstrateStack();
        demonstrateHashMap();
    }

    public static void demonstrateLinkedList() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Кот");
        myLinkedList.add("Собака");
        myLinkedList.add("Слон");

        System.out.println("Размер: " + myLinkedList.size());
        System.out.println("Элемент по индексу 1: " + myLinkedList.get(1));

        myLinkedList.remove(0);

        System.out.println("Размер после удаления: " + myLinkedList.size());
        System.out.println("Элемент по индексу 0 после удаления: " + myLinkedList.get(0));

        myLinkedList.clear();
        System.out.println("Размер после очистки: " + myLinkedList.size());
    }

    public static void demonstrateQueue() {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("Красный");
        myQueue.add("Зеленый");
        myQueue.add("Синий");

        System.out.println("Размер: " + myQueue.size());
        System.out.println("Элемент в начале: " + myQueue.peek());

        myQueue.poll();

        System.out.println("Размер после извлечения: " + myQueue.size());
        System.out.println("Элемент в начале после извлечения: " + myQueue.peek());

        myQueue.clear();
        System.out.println("Размер после очистки: " + myQueue.size());
    }

    public static void demonstrateStack() {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println("Размер: " + myStack.size());
        System.out.println("Элемент на вершине: " + myStack.peek());

        myStack.pop();

        System.out.println("Размер после извлечения: " + myStack.size());
        System.out.println("Элемент на вершине после извлечения: " + myStack.peek());

        myStack.clear();
        System.out.println("Размер после очистки: " + myStack.size());
    }

    public static void demonstrateHashMap() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("яблоко", 50);
        myHashMap.put("банан", 30);
        myHashMap.put("апельсин", 40);

        System.out.println("Размер: " + myHashMap.size());
        System.out.println("Значение для ключа 'банан': " + myHashMap.get("банан"));

        myHashMap.remove("яблоко");

        System.out.println("Размер после удаления: " + myHashMap.size());
        System.out.println("Значение для ключа 'яблоко' после удаления: " + myHashMap.get("яблоко"));

        myHashMap.clear();
        System.out.println("Размер после очистки: " + myHashMap.size());
    }
}