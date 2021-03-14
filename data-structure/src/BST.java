import java.util.*;
import java.util.stream.StreamSupport;

/**
 * 二分搜索树:
 *   特点
 *     1: 二叉树
 *     2: 每一个值可比较、节点值都比他的左子树任意节点大,比右子树任意节点小
 *
 */
public class BST<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = right = null;
        }
        public Node(K key){
            this(key, null);
        }
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
    public void add(K key, V value){
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value){
        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        } else if(key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public V get(K key){
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key + " doesn't exists");
        }
        node.value = newValue;
    }
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    private Node getNode(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.equals(node.key)){
            return node;
        } else if(key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }
        return getNode(node.right, key);
    }

    // 前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    // 后续遍历
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

    // 二分搜索树的非递归遍历
    public void preOrderNR(){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    // 二分搜索树的程序遍历
    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.key);

            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public V minimum(K key){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        Node minNode = minimum(root, key);
        return minNode.value;
    }

    private Node minimum(Node node, K key){
        if(node.left == null){
            return node;
        }
        return minimum(node.left, key);
    }

    public V maximum(K key){
        if(size == 0){
            throw new IllegalArgumentException("BST is Empty");
        }
        Node maxNode = maximum(root, key);
        return maxNode.value;
    }

    private Node maximum(Node node, K key){
        if(node.right == null){
            return node;
        }
        return maximum(node.right, key);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.key + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth +1, res);
    }
    public String generateDepthString(int path){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < path; ++i){
            res.append("--");
        }
        return res.toString();
    }
}
