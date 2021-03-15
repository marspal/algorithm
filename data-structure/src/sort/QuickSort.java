package sort;

import java.util.Random;

public class QuickSort {

    public static final Random random = new Random();
    private QuickSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if(l >= r){
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p+1, r);
    }

    public static <E extends Comparable<E>> void sort2(E[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        // 使用Insertion Sort优化
        if(r - l <= 7){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);

        sort2(arr, l, p - 1);
        sort2(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r){
        // arr[l+1...j] < v arr[j+1...r] >= v
        // 生成[l, r]之间的随机索引
        int p = l + random.nextInt(r-l+1);
        swap(arr, l, p);

        int j = l;
        for(int i = j + 1; i <= r; ++i){
            if(arr[i].compareTo(arr[l]) < 0)  {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
