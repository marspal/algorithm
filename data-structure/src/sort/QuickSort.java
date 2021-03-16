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

    // 双路快排
    public static <E extends Comparable<E>> void sort2Way(E[] arr){
        sort2Way(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2Way(E[] arr, int l, int r){
        if(l >= r) return;
        int p = sort2WayPortion(arr, l, r);
        sort2Way(arr, l, p - 1);
        sort2Way(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int sort2WayPortion(E[] arr, int l, int r){
        int p = l + random.nextInt(r- l + 1);
        swap(arr, l, p);
        int i = l + 1, j =r;

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        while (true) {
            while (i<=j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j --;
            }
            if(i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort3Way(E[] arr){
        sort3Way(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort3Way(E[] arr, int l, int r){
        if(l >= r) return;

        int p = l + random.nextInt(r - l + 1);
        swap(arr, p, l);
        int lt = l, i = l + 1, gt = r + 1;
        // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
        while (i < gt) {
            if(arr[i].compareTo(arr[l]) < 0){
                lt++;
                swap(arr, lt, i);
                i++;
            } else if(arr[i].compareTo(arr[l]) > 0){
                gt--;
                swap(arr, gt, i);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        // 递归调用
        sort3Way(arr, l, lt - 1);
        sort3Way(arr, gt, r);
    }


    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
