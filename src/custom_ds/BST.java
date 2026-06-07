/**
 * left < parent < right
 * The template is by:
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class BST <Key extends Comparable<Key>, Value> {
    private Node root; // root of BST

    private class Node{

        private Key key; // sorted by key
        private Value val; // associated data
        private Node left, right;
        private int size; // number of nodes in subtree

        public Node(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }


    public BST(){}


    /**
     * @return the number of key-value pairs in this symbol table
     */
    public int size(){
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node node){
        if(node == null) return 0;
        else return node.size;
    }


    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty(){
        return size() == 0;
    }
}
