package sort;

/**
 * @Description 插入排序
 * 算法思想：从数组第二个位置开始，以当前位置的值和其前面所有值进行比较，凡是比当前值大的都向后移一位。
 * @Author Created by t.wu on 2017/8/19.
 */
public class InsertSort {
    /**
     *
     * @param a
     */
    public void sort(int[] a){
        for(int i=1; i<a.length ; i++){
            int pivot = a[i];
            int j = i-1;
            while(j>=0 && a[j]> pivot){
                a[j+1] = a[j];
                j--;
            }
            // 跳出循环，意味着 j=-1<0 or a[j] < pivot,
            // j=-1时，j+1 = 0 ,也就从j >=1 开始的位置逗比 pivot大，则a[0] = pivot
            // a[j] < pivot 意味着 a[j+1] 开始都大于pivot，原来的j+1位置因为大于pivot，所以已经后移了，这时j+1的位置其实是“空”的。
            // 所以pivot 放在j+1 正好，前面都比他小，后面都比他大。
             a[j+1] = pivot;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {17,13,4,51,67,5};
        new InsertSort().sort(a);
        for(int i : a){
            System.out.println(i);
        }
    }
}
