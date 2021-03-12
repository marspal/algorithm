import java.util.ArrayList;
import java.util.Random;

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
                    rbTree.set(word, rbTree.get(word) + 1);
                } else {
                    rbTree.add(word, 1);
                }
            }
            System.out.println("Total different words: " + rbTree.getSize());
            System.out.println("Frequency of PRIDE: " + rbTree.get("pride"));
            System.out.println("Frequency of prejudice: " + rbTree.get("prejudice"));
        }
    }
    public static void TreePerformance(){
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)){
            long startTime = System.nanoTime();

            // AVLTree
            AVLTree<String, Integer> avl = new AVLTree<>();
            for(String word: words){
                if(avl.contains(word)){
                    avl.set(word, avl.get(word) + 1);
                }else{
                    avl.add(word, 1);
                }
            }
            for(String word: words)
                avl.contains(word);

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");

            // RBTree
            RBTree<String, Integer> rbTree = new RBTree<>();
            for(String word: words){
                if(rbTree.contains(word)){
                    rbTree.set(word, rbTree.get(word) + 1);
                }else{
                    rbTree.add(word, 1);
                }
            }
            for(String word: words)
                avl.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");
        }

    }

    public static void TreePerformance2(){
        // int n = 20000000;
        int n = 20000000;

        Random random = new Random(n);
        ArrayList<Integer> testData = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i ++)
            testData.add(i);
        // Test AVL
        long startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x: testData)
            avl.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x: testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }
    public static void main(String[] args) {
//        Test.AVRTreeTest();
//        Test.RBTressTest();
//        Test.TreePerformance();
        Test.TreePerformance2();
    }
}
