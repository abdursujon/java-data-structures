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
public class Stacks {
    public static void stackInJava(){
        Stack<Character> st = new Stack<>();
        st.push('(');
        st.push(')');
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.isEmpty());
        st.pop();
        System.out.println(st.isEmpty());
        System.out.println(st.size());
        st.push('{');
        st.push('}');
        System.out.println(st.size());
        System.out.println(st.search('{'));
        System.out.println(st.search('['));
        System.out.println(st.contains('}'));
        System.out.println(st.contains(']'));
    }

    public static void main(String[] args){
        stackInJava();
    }
}
