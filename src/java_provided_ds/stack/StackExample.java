package stack;

import java.util.Stack;

/**
 * 1. push(element)
 * 2. pop()
 * 3. peek()
 * 4. isEmpty()
 * 5. size()
 * 6. search(element)
 * 7. contains(element)
 */
public class StackExample {
    public static void main(String[] args){
        Stack<Character> st = new Stack<>();

        // 1. push(element)
        st.push('(');
        st.push(')');

        // 2. pop()
        System.out.println(st.pop());

        // 3. peek()
        System.out.println(st.peek());

        // 4. isEmpty()
        System.out.println(st.isEmpty());
        st.pop();
        System.out.println(st.isEmpty());

        // 5. size()
        System.out.println(st.size());
        st.push('{');
        st.push('}');
        System.out.println(st.size());

        // 6. search(element)
        System.out.println(st.search('{'));
        System.out.println(st.search('['));

        // 7. contains(element)
        System.out.println(st.contains('}'));
        System.out.println(st.contains(']'));

        // 3. peek()
        System.out.println(st.peek());

        // 4. isEmpty()
        System.out.println(st.isEmpty());
        st.pop();
        System.out.println(st.isEmpty());

        // 5. size()
        System.out.println(st.size());
        st.push('{');
        st.push('}');
        System.out.println(st.size());

        // 6. search(element)
        System.out.println(st.search('{'));
        System.out.println(st.search('['));

        // 7. contains(element)
        System.out.println(st.contains('}'));
        System.out.println(st.contains(']'));
    }
}