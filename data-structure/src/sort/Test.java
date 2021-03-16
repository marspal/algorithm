package sort;

public class Test {
    public static void main(String[] args) {
        int[] dataSize = {100000, 10000000};

        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n , 1);
//            SortingHelper.sortTest("SelectionSort", arr);
//            SortingHelper.sortTest("InsertionSort", arr);
//            SortingHelper.sortTest("InsertionSort2", arr);
//            SortingHelper.sortTest("MergeSort", arr);
//            SortingHelper.sortTest("MergeSort2", arr);
//            SortingHelper.sortTest("MergeSort3", arr);
//            SortingHelper.sortTest("QuickSort", arr);
//            SortingHelper.sortTest("QuickSort2", arr);
//            SortingHelper.sortTest("QuickSort3", arr);
            SortingHelper.sortTest("QuickSort4", arr);

//            Integer[] arr1 = ArrayGenerator.generateSortedArray(n);
//            SortingHelper.sortTest("QuickSort2", arr1);
//            SortingHelper.sortTest("QuickSort2", arr1);
        }
    }
}
