package sort;

/**
 * @Description
 * @Author Created by t.wu on 2017/8/21.
 */
public class QuickSort {

    public void sort(int[] a, int l, int r) {
        if (l < r) {
            int split = partition(a, l, r);
            sort(a, l, split);
            sort(a, split + 1, r);
        }
    }

    public static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l - 1;
        int j;
        for (j = l; j <= r - 1; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        pivot = a[i + 1];
        a[i + 1] = a[r];
        a[r] = pivot;
        return i + 1;
    }
}
