/**
 *  平衡二叉树
 *  特点: 对于任意节点,左子树和右子树的高度差不能超过1
 *       高度和节点数量之间的关系也是O(logn)的
 *
 *       标记高度 -> 计算平衡因子
 */
public class AVLTree<K extends Comparable<K>, V> {
    private class Node {
        public K key;
        public V value;
        public int height;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public int getHeight(Node node) {
        if(node == null)
            return 0;
        return node.height;
    }

    public void add(K key, V value){
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value){
        if(node == null){
            size++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        } else if(key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        // 更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getHeight(node.left) - getHeight(node.right);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println(balanceFactor);
        }
        return node;
    }
}
