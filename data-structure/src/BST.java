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
        public Node(E e){
            this.e = e;
            left = right = null;
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
        return getSize() == 0;
    }
}
