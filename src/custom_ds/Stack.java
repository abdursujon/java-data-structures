import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E>{
    int top = -1;
    E[] stack;
    int size = 0;

    @SuppressWarnings("Unchecked")
    public Stack(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("Capacity must be >= 1");
        }
        stack = (E[]) new Object[initialCapacity];
    }

    public Stack(){
        this(10);
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top];
    }

    @SuppressWarnings("Unchecked")
    public void push(E element){
        if(top == stack.length - 1){
            E[] newArray = (E[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        // Put the new element on top of the stack
        stack[++top] = element;
        size++;
    }

    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E topObject = stack[top];
        size--;
        stack[top--] = null; // allow garbage collection
        return topObject;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(stack, size));
    }

    public static void main(String[] args){
        Stack<Integer> pageNumbers = new Stack();
        int[] pages = {0, 1, 2, 3, 4, 5};
        for(int p : pages){
            pageNumbers.push(p);
        }
        System.out.println(pageNumbers);

        // peek the top of the stack which is page 5
        System.out.println(pageNumbers.peek());

        while (!pageNumbers.isEmpty()) {
            pageNumbers.pop();
        }

        System.out.println(pageNumbers); // empty
    }
}
