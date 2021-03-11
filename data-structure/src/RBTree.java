import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * 红黑树: 等价于2-3树; 一个红色节点和他父亲节点组合在一起形成三节点
 *    - 特性:
 *    1. 每一个node是Red Or Black
 *    2. 根节点是黑色的
 *    3. 最后的空节点是黑色的
 *    4. 如果一个节点是红色的,那么他的孩子节点都是黑色的
 *    5. 从任意一个节点到叶子节点, 经过的黑色节点是一样的
 *
 * 严格意义上讲: 不是平衡二叉树,最大高度:2logn logn 黑色节点+ logn 红色节点
 */
public class RBTree<K extends Comparable<K>, V> {
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value) {
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
        return node;
    }

    private Node getNode(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        } else if(key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else  {
            return node;
        }
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V getValue(K key){
        Node node = getNode(root, key);
        return node != null ? node.value : null;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key + " doesn't exits");
        }
        node.value = newValue;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public V remove(K key){
        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        } else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        } else {
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }
}
