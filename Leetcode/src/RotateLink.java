import java.util.ArrayList;

public class RotateLink<E> {
    private class Node {
        public E e;
        public Node next;
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this.e = e;
        }
    }
    public Node head;
    public int size;
    public RotateLink(E[] list){
        Node dummyHead = new Node(null);
        for(int i = list.length - 1; i >= 0; i--) {
            Node temp = new Node(list[i], dummyHead.next);
            dummyHead.next = temp;
        }
        head = dummyHead.next;
    }

    public void rotateByK(int k){
        Node preNode = null;
        Node currentNode = head;
        ArrayList<Node> startNode = new ArrayList<>();
        ArrayList<Node> endNode = new ArrayList<>();
        int count = 0;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;             currentNode = nextNode;
            currentNode = nextNode;
            count += 1;
            if(count % k == 1){
                startNode.add(preNode);
            }
            if(count % k == 0 || nextNode == null){
                endNode.add(preNode);
            }
            if (nextNode == null) {
                break;
            }
        }
        if (k == 1) {
            head = preNode;
        } else {
            for(int i = 0; i < startNode.size(); ++i){
                Node tempSartNode = startNode.get(i);
                if (startNode.size() - 1 == i) {
                    tempSartNode.next = null;
                    break;
                }
                Node tempEndNode = endNode.get(i+1);
                tempSartNode.next = tempEndNode;
            }
            head = endNode.get(0);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node currentNode = head;
        while (currentNode != null) {
            str.append(currentNode.e);
            str.append("->");
            currentNode = currentNode.next;
        }
        str.append("NULL");
        return str.toString();
    }

    public static void main(String[] args) {
        Integer[] test = {1,2,3,4,5,6,7,8,9,10,11};
        RotateLink node = new RotateLink<Integer>(test);
        node.rotateByK(3);
        System.out.println(node);
    }
}
