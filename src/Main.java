public class Main {
    public static void main(String[] args) {

        MyArrayList myArrayList = new MyArrayList();


        myArrayList.add("Apple");
        myArrayList.add("Banana");
        myArrayList.add("Orange");
        myArrayList.add("Mango");


        System.out.println("Size: " + myArrayList.size());
        System.out.println("Element at index 2: " + myArrayList.get(2));


        myArrayList.remove(1);


        System.out.println("Size after removal: " + myArrayList.size());
        System.out.println("Element at index 1 after removal: " + myArrayList.get(1));


        myArrayList.clear();


        System.out.println("Size after clearing: " + myArrayList.size());


        MyLinkedList myLinkedList = new MyLinkedList();


        myLinkedList.add("Cat");
        myLinkedList.add("Dog");
        myLinkedList.add("Elephant");


        System.out.println("Size: " + myLinkedList.size());
        System.out.println("Element at index 1: " + myLinkedList.get(1));


        myLinkedList.remove(0);


        System.out.println("Size after removal: " + myLinkedList.size());
        System.out.println("Element at index 0 after removal: " + myLinkedList.get(0));


        myLinkedList.clear();


        System.out.println("Size after clearing: " + myLinkedList.size());


        MyQueue myQueue = new MyQueue();


        myQueue.add("Red");
        myQueue.add("Green");
        myQueue.add("Blue");


        System.out.println("Size: " + myQueue.size());
        System.out.println("Element at front: " + myQueue.peek());


        myQueue.poll();


        System.out.println("Size after polling: " + myQueue.size());
        System.out.println("Element at front after polling: " + myQueue.peek());


        myQueue.clear();


        System.out.println("Size after clearing: " + myQueue.size());


        MyStack myStack = new MyStack();


        myStack.push(1);
        myStack.push(2);
        myStack.push(3);


        System.out.println("Size: " + myStack.size());
        System.out.println("Element at top: " + myStack.peek());


        myStack.pop();


        System.out.println("Size after popping: " + myStack.size());
        System.out.println("Element at top after popping: " + myStack.peek());


        myStack.clear();


        System.out.println("Size after clearing: " + myStack.size());


        MyHashMap myHashMap = new MyHashMap();


        myHashMap.put("apple", 50);
        myHashMap.put("banana", 30);
        myHashMap.put("orange", 40);


        System.out.println("Size: " + myHashMap.size());
        System.out.println("Value for key 'banana': " + myHashMap.get("banana"));


        myHashMap.remove("apple");


        System.out.println("Size after removal: " + myHashMap.size());
        System.out.println("Value for key 'apple' after removal: " + myHashMap.get("apple"));


        myHashMap.clear();


        System.out.println("Size after clearing: " + myHashMap.size());
    }
}