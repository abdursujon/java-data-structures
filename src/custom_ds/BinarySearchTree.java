public class BinarySearchTree<T extends Comparable<T>>{
    private  class Node {
        T val;
        Node left;
        Node right;

        Node(T val) {
            this.val = val;
        }
    }

    private Node root;

    public BinarySearchTree(T val) {
        this.root = new Node(val);
    }

    public void insert(T val) {
        insertHelper(root, val);
    }

    private void insertHelper(Node node, T val) {
        int compare = val.compareTo(node.val);

        if (compare > 0) {
            if (node.right != null) {
                insertHelper(node.right, val);
            } else {
                node.right = new Node(val);
            }
        } else if (compare < 0) {
            if (node.left != null) {
                insertHelper(node.left, val);
            } else{
                node.left = new Node(val);
            }
        }
    }

    public void search(T val){
        System.out.println(searchHelper(root, val));
    }

    private boolean searchHelper(Node node, T val){
        if(node == null) return false;
        int compare = val.compareTo(node.val);
        if(val.equals(node.val)){
            return true;
        } else if(compare > 0){
            return searchHelper(node.right, val);
        } else {
            return searchHelper(node.left, val);
        }
    }

    public void inOrderPrint(){
        inOrderHelper(root);
        System.out.println();
    }

    private void inOrderHelper(Node node){
        if(node == null) return;
        inOrderHelper(node.left);
        System.out.print(node.val + " ");
        inOrderHelper(node.right);
    }

    public void preOrderPrint(){
        preOrderHelper(root);
        System.out.println();
    }

    private void preOrderHelper(Node node){
        if(node == null) return;
        System.out.print(node.val + " ");
        preOrderHelper(node.left);
        preOrderHelper(node.right);
    }

    public void postOrderPrint(){
        postOrderHelper(root);
        System.out.println();
    }

    private void postOrderHelper(Node node){
        if(node == null) return;
        postOrderHelper(node.left);
        postOrderHelper(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(8);
        int[] values = {1, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 56, 2, 8};
        for(int v: values){
            tree.insert(v);
        }

        System.out.println("In-Order BinarySearchTree ");
        tree.inOrderPrint();

        System.out.println("Pre-Order BinarySearchTree ");
        tree.preOrderPrint();

        System.out.println("Post-Order BinarySearchTree ");
        tree.postOrderPrint();

        tree.search(900);
        tree.search(2);
    }
}
