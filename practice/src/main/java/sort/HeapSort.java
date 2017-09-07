package sort;

/**
 * @Description 堆排序
 * 算法思想：
 * @Author Created by t.wu on 2017/8/21.
 */
public class HeapSort {

    /**
     * 保证任意节点的值都大于其子节点的值
     * 如何保证这个树的中任意节点都有左右两个子节点？
     * 答案就在建树的过程中。
     * 注意 数组索引从0开始，左右子树的索引正确的算法，就应该分别是 2 * 1 + 1 , 2 * i + 2
     * @param a
     * @param heapSize
     * @param index
     */
    public void heapfy(int[] a, int heapSize, int index) {
        int left = 2 * index +1;
        int right = 2 * index + 2;
        int max = index;
        if (left < heapSize && a[max] < a[left]) {
            max = left;
        }
        if (right < heapSize && a[max] < a[right]) {
            max = right;
        }
        if (max != index) {
            int tmp = a[index];
            a[index] = a[max];
            a[max] = tmp;
            heapfy(a, a.length, max);
        }
    }

    public void createHeap(int[] a) {
        int middle = a.length / 2 -1;
        for (int i = middle; i >= 0; i--) {
            heapfy(a, a.length,i);
        }
    }

    /**
     * 取出最大的a[0]，放在最后，再对剩下的数组进行heapfy。
     * @param a
     */
    public void sort(int[] a){
        for(int i = a.length-1 ; i >=0 ; i--){
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp ;

            heapfy(a,i,0);
            System.out.println("====dd====");
            for(int j : a){
                System.out.print(j+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {17,13,4,51,67,5};
        HeapSort hs = new HeapSort();
        hs.createHeap(a);
        hs.sort(a);
        System.out.println("========");
        for(int i : a){
            System.out.print(i+" ");
        }
    }
}
