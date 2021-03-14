package sort;

import java.util.Arrays;

public class SortingHelper {
    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for(int i = 1; i < arr.length; ++i){
            if(arr[i-1].compareTo(arr[i]) > 0){
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr){

        E[] data = Arrays.copyOfRange(arr, 0, arr.length);
        long startTime = System.nanoTime();
        if(sortname.equals("SelectionSort")){
            SelectionSort.sort(data);
        } else if(sortname.equals("InsertionSort")){
            InsertionSort.sort(data);
        } else if(sortname.equals("InsertionSort2")){
            InsertionSort.sort2(data);
        }

        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;

        if(!SortingHelper.isSorted(data)){
            throw new RuntimeException(sortname + " failed");
        }
        System.out.println(String.format("%s, n = %d : %f s", sortname, data.length, time));
    }
}
