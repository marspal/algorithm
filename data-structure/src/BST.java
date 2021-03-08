import java.util.*;

/**
 * 二分搜索树:
 *   特点
 *     1: 二叉树
 *     2: 每一个值可比较、节点值都比他的左子树任意节点大,比右子树任意节点小
 *
 * @param <E>
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;
        public Node(E e, Node left, Node right){
            this.e = e;
            this.left = left;
            this.right = right;
        }
        public Node(E e){
            this(e, null, null);
        }
        public Node(){
            this(null, null, null);
        }
    }
    private class NodeWithLevel {

    }
    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(E e){
        if (root == null) {
            root = new Node(e);
        }else {
            add(root, e);
        }
    }
    private void add(Node node, E e){
        if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
        } else if(e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
        } else if(e.compareTo(node.e) < 0){
           add(node.left, e);
        } else if(e.compareTo(node.e) > 0){
           add(node.right, e);
           return;
        }
    }

    private void preOrder(Node node, ArrayList<Node> arr){
        if(node == null){
            return;
        }
        preOrder(node.left, arr);
        arr.add(node);
        preOrder(node.right, arr);
    }
    public String generatePath(int path){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < path; ++i){
            res.append("--");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        // 先用深度遍历
        ArrayList<Node> arr = new ArrayList<>();
        preOrder(root, arr);
//        Queue<Node> q1 = new
//        while () {
//
//        }
        return "";
    }
}
