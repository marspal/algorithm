import java.util.ArrayList;

public class LinkedList<E> {
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
    public LinkedList(E[] list){
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
        Node nextNode = null;
        ArrayList<Node> startNode = new ArrayList<>();
        ArrayList<Node> endNode = new ArrayList<>();
        int count = 0;
        while (currentNode != null) {
            nextNode = currentNode.next;
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

    public void rotateByK2(int k){
        head = rotate(head, null);
    }
    private Node rotate(Node node, Node pre) {
        if(node == null){
            return null;
        }
        Node next = node.next;
        node.next = pre;
        if(next == null){
            return node;
        }
        return rotate(next, node);
    }

    public Node oddEvenList(){
        if (head == null) {
            return null;
        }
        Node odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    // 92号问题
    public void reverseBetween(int m, int n){
        if(head == null){
            return;
        }
        Node preStart = null, start = null;
        Node pre = null, next = null;
        Node current = head;
        int count = 1;
        while(count <= n && current != null){
            if(count + 1 == m){
                preStart = current;
            }
            if(count == m){
                start = current;
            }
            next = current.next;
            if(count >= m && count <= n){
                current.next = pre;
                pre = current;
                if(count == n){
                    start.next = next;
                    if(preStart != null){
                        preStart.next = current;
                        return;
                    }
                    head = pre;
                    return;
                }
            }
            current = next;
            count++;
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
        Integer[] test = {1,2,3,4,5,6};
        LinkedList node = new LinkedList<Integer>(test);
//        node.rotateByK(3);
//        node.rotateByK2(3);
        System.out.println(node);
//        node.oddEvenList();
        node.reverseBetween(2, 4);
        System.out.println(node);
    }
}
