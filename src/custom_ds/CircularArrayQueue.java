public class CircularArrayQueue<E>  {
    Object[] queue;
    int front, rear;

    public CircularArrayQueue(int initialLength) {
        if (initialLength < 1) {
            throw new IllegalArgumentException();
        }
        queue = new Object[initialLength];
        front = rear = 0;
    }

    public void put(Object theObject) {
    }


    public E peek() {
        return null;
    }

}
