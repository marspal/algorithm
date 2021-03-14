package sort;

public class SelectionSort {
    private SelectionSort(){};
    public static <E extends Comparable<E>> void sort(E[] arr){
        // [0, ...i)是有序的; arr[i, n)无序的
        for(int i = 0; i < arr.length; ++i){
            // 选择arr[i...n)中的最小值的索引
            int minIndex = i;
            for(int j = i; j < arr.length; ++j){
                if(arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr){
        for(int i = arr.length - 1; i >= 0; i--){
            // 选择arr[0,...i]中的最大值
            int maxIndex = i;
            for(int j = i; j >= 0; j++){
                if(arr[j].compareTo(arr[i]) > 0){
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }
    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        for(int e: arr){
            System.out.println(e + " ");
        }
        System.out.println();
    }
}
