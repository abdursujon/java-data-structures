import java.util.Arrays;

public class CircularQueue<E> {
    int front, rear;
    E[] queue;
    int size;

    public CircularQueue(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException();
        }
        front = rear = 0;
        queue = (E[]) new Object[initialSize + 1];
    }

    public CircularQueue() {
        this(10);
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[(front + 1) % queue.length];
    }

    public void put(E theElement) {
        // queue is full when next position after rear hits front
        if (front == (rear + 1) % queue.length) {
            E[] newQueue = (E[]) new Object[queue.length * 2];

            // calculate how many elements are from front+1 to end of array
            int secondSegmentLength = queue.length - front - 1;

            // copy elements from front+1 to end into new array starting at 0
            System.arraycopy(queue, front + 1, newQueue, 0, secondSegmentLength);

            // copy elements from 0 to rear right after the second segment
            System.arraycopy(queue, 0, newQueue, secondSegmentLength, rear + 1);

            // Front should simply be newQueue.length - 1 = 11 so it sits at the end, one anti-clockwise from index 0.
            front = newQueue.length - 1;

            // rear is now at end of all copied elements
            rear = secondSegmentLength + rear;

            // replace old array with new bigger array
            queue = newQueue;
        }

        // move rear one step clockwise, wrap around using modulo
        rear = (rear + 1) % queue.length;

        // insert new element at rear
        queue[rear] = theElement;
        size++;
    }

    public E remove() {
        if (isEmpty()) {
            return null;
        }
        front = (front + 1) % queue.length;
        E frontObject = queue[front];
        queue[front] = null;
        size--;
        return frontObject;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size; i++){
            int index = (front + 1 + i) % queue.length;
            sb.append(queue[index]);
            if(i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args){
        CircularQueue<Integer> queue = new CircularQueue<>();
        int[] nums = {1, 2, 3, 4, 3, 2, 1};
        for(int n: nums){
            queue.put(n);
        }
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
    }
}

