package sort;

public class Test {
    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};

        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n , n);
//            SortingHelper.sortTest("SelectionSort", arr);
//            SortingHelper.sortTest("InsertionSort", arr);
//            SortingHelper.sortTest("InsertionSort2", arr);
            SortingHelper.sortTest("MergeSort", arr);
            SortingHelper.sortTest("MergeSort2", arr);
            SortingHelper.sortTest("MergeSort3", arr);
        }
    }
}
