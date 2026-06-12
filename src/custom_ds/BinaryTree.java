import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T extends Comparable <T>> {
    private  class Node {
        T val;
        Node left;
        Node right;

        Node(T val) {
            this.val = val;
        }
    }

    private Node root;

    public BinaryTree(T val) {
        this.root = new Node(val);
    }

    /**
     * Trace inserting into:
     *       1
     *      / \
     *     2   3
     *   Insert 4:
     *   - poll 1. left (2) not null → offer(2). right (3) not null → offer(3). Queue: [2, 3]
     *   - poll 2. left null → attach 4 here, return.
     */
    public void insert(T val){
        Node newNode = new Node(val);
        if(root == null){
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.left == null){
                current.left = newNode;
                return;
            } else{
                queue.offer(current.left);
            }

            if(current.right == null){
                current.right = newNode;
                return;
            } else{
                queue.offer(current.right);
            }
        }
    }

    public List<T> inOrder(){
        List<T> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    private void inOrderHelper(Node node, List<T> result){
        if(node == null) return;
        inOrderHelper(node.left, result);  // 1. go all the way left first
        result.add(node.val);  // 2. then add this node
        inOrderHelper(node.right, result); // 3. then go right
    }

    public List<T> preOrder(){
        List<T> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }

    private void preOrderHelper(Node node, List<T> result){
        if(node == null) return;
        result.add(node.val);
        preOrderHelper(node.left, result);
        preOrderHelper(node.right, result);
    }

    public List<T> postOrder(){
        List<T> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }

    private void postOrderHelper(Node node, List<T> result){
        if(node == null) return;
        postOrderHelper(node.left, result);
        postOrderHelper(node.right, result);
        result.add(node.val);
    }

    public List<T> levelOrder(){
        List<T> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            result.add(current.val);
            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }
        return result;
    }

    public static void main(String[] args){
        BinaryTree<Integer> binaryTree = new BinaryTree<>(1);
        // left and right child of root 1
        binaryTree.insert(2);
        binaryTree.insert(3);

        // left and right child of 2
        binaryTree.insert(4);
        binaryTree.insert(5);

        // left and right child of 3
        binaryTree.insert(6);
        binaryTree.insert(7);

        System.out.println(binaryTree.inOrder());
        System.out.println(binaryTree.preOrder());
        System.out.println(binaryTree.postOrder());
        // go through each level of the tree from left to right
        System.out.println(binaryTree.levelOrder());
    }

}
