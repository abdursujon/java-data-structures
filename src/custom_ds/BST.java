public class BST{
    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public BST(int val) {
        this.root = new Node(val);
    }

    public void insert(int val) {
        insertHelper(root, val);
    }

    private void insertHelper(Node node, int val) {
        if (val > node.val) {
            if (node.right != null) {
                insertHelper(node.right, val);
            } else {
                node.right = new Node(val);
            }
        } else if (val < node.val) {
            if (node.left != null) {
                insertHelper(node.left, val);
            } else{
                node.left = new Node(val);
            }
        }
    }

    public void search(int val){
        System.out.println(searchHelper(root, val));
    }

    private boolean searchHelper(Node node, int val){
        if(node == null){
            return false;
        } else if(val == node.val){
            return true;
        } else if(val > node.val){
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
        if (node.left != null) inOrderHelper(node.left);
        System.out.print(node.val + " ");
        if (node.right != null) inOrderHelper(node.right);
    }

    public void preOrderPrint(){
        preOrderHelper(root);
        System.out.println();
    }

    private void preOrderHelper(Node node){
        System.out.print(node.val + " ");
        if(node.left != null) preOrderHelper(node.left);
        if(node.right != null) preOrderHelper(node.right);
    }

    public void postOrderPrint(){
        postOrderHelper(root);
        System.out.println();
    }

    private void postOrderHelper(Node node){
        if(node.left != null) postOrderHelper(node.left);
        if(node.right != null) postOrderHelper(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args){
        BST tree = new BST(8);
        int[] values = {1, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 56, 2, 8};
        for(int v: values){
            tree.insert(v);
        }

        System.out.println("In-Order BST ");
        tree.inOrderPrint();

        System.out.println("Pre-Order BST ");
        tree.preOrderPrint();

        System.out.println("Post-Order BST ");
        tree.postOrderPrint();

        tree.search(900);
        tree.search(2);
    }
}
