package sort;

/**
 * @Description 归并排序
 * 算法思想：想象两叠牌，两叠牌都是有序的，如何让他们合并成一个有序的数列？
 * 1. 首先二分数组 length /2  并下取整。
 * 2. 每次从左右队列中各取一个数，进行比较，小的放进原数组的相应位置。
 * 3. 注意：边界条件，当p>=r时，说明没有可再二分的数。所以一定是最先分到左右数组各有一个数为止，开始合并这两个数组。
 * @Author Created by t.wu on 2017/8/19.
 */
public class MergeSort {

    private void merge(int[] a , int p,int q, int r ){
        int n1 = q-p+1+1;
        int n2 = r-q+1;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0 ; i< left.length-1; i++){
            left[i]= a[p+i];
        }
        for(int i = 0 ; i< right.length-1; i++){
            right[i]= a[q+1+i];
        }
        left[q-p+1] = Integer.MAX_VALUE;   // （1） 最大的数放在这里，方便比较且不会越界
        right[r-q] = Integer.MAX_VALUE;

        int j =0;
        int i =0;
        for(int k = p; k<=r; k++ ){
            if(left[i]<right[j]){   //（1）
                a[k] = left[i];
                i++;
            }else{
                a[k] = right[j];
                j++;
            }
        }
    }
    public void sort(int[] a,int p,int r ){
        if(p<r){
            int middle = (r+p)/2 ;
            sort(a,p,middle);
            sort(a,middle+1,r);
            merge(a,p,middle,r);
        }
    }
    public static void main(String[] args) {
        int[] a = new int[] {17,13,4,51,67,5};
        new MergeSort().sort(a,0,a.length-1);
        for(int i : a){
            System.out.print(i+" ");
        }
    }
}
