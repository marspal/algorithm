import java.util.ArrayList;

public class Test {
    public static final String filename = "./src/pride-and-prejudice";

    public static void AVRTreeTest(){
        System.out.println("AVLTree Test");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)){
            AVLTree<String, Integer> avl = new AVLTree<>();
            for(String word: words){
                if(avl.contains(word)){
                    avl.set(word, avl.get(word) + 1);
                } else {
                    avl.add(word, 1);
                }
            }
            System.out.println("Total words: "+ words.size());
            System.out.println("Total different words: " + avl.getSize());
            System.out.println("isBST: "+ avl.isBST());
            System.out.println("isBalanced: "+ avl.isBalanced());
            System.out.println("Frequency of prejudice : " + avl.get("prejudice"));
        }
    }
    public static void RBTressTest(){
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)){
            System.out.println();
            System.out.println("RBTree Test");
            System.out.println("Total words: " + words.size());
            RBTree<String, Integer> rbTree = new RBTree<>();
            for(String word: words){
                if(rbTree.contains(word)){
                    rbTree.set(word, rbTree.getValue(word) + 1);
                } else {
                    rbTree.add(word, 1);
                }
            }
            System.out.println("Total different words: " + rbTree.getSize());
            System.out.println("Frequency of prejudice: " + rbTree.getValue("prejudice"));
        }
    }
    public static void main(String[] args) {
        Test.AVRTreeTest();
        Test.RBTressTest();
    }
}
