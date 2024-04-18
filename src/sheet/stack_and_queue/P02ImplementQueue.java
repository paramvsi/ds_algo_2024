package sheet.stack_and_queue;

public class P02ImplementQueue {
    // Main class to test the queue implementation
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("The front element is " + queue.peek());
        queue.dequeue();
        System.out.println("The front element is " + queue.peek());

        queue.enqueue(4);
        queue.enqueue(5);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

    public static class Queue {
        private final int[] arr;
        private int front;
        private int rear;
        private final int capacity;
        private int count;

        // Constructor to initialize the queue
        public Queue(int size) {
            arr = new int[size];
            capacity = size;
            front = 0;
            rear = -1;
            count = 0;
        }

        // Add an element to the queue
        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Overflow\nProgram Terminated");
                System.exit(1);
            }
            System.out.println("Inserting " + item);
            rear = (rear + 1) % capacity;
            arr[rear] = item;
            count++;
        }

        // Remove the front element from the queue
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Underflow\nProgram Terminated");
                System.exit(1);
            }
            int item = arr[front];
            front = (front + 1) % capacity;
            count--;
            return item;
        }

        // Return the front element of the queue
        public int peek() {
            if (isEmpty()) {
                System.out.println("Underflow\nProgram Terminated");
                System.exit(1);
            }
            return arr[front];
        }

        // Return the size of the queue
        public int size() {
            return count;
        }

        // Check if the queue is empty
        public Boolean isEmpty() {
            return (size() == 0);
        }

        // Check if the queue is full
        public Boolean isFull() {
            return (size() == capacity);
        }
    }
}
