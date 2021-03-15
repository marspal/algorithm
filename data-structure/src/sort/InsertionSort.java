package sort;

public class InsertionSort {
    private InsertionSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for(int i = 0; i < arr.length; ++i){
            for(int j = i; j - 1>= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--){
                swap(arr, j, j -1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for(int i = 0; i < arr.length; i++){
            E t = arr[i];
            int j;
            for(j = i; j - 1 >=0  && t.compareTo(arr[j - 1]) < 0; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        for(int i = l; i <= r; ++i){
            E t = arr[i];
            int j;
            for(j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j -- ){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
