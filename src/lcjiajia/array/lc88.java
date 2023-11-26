package lcjiajia.array;

import java.util.Arrays;

public class lc88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n == 0){
        }
        int i = nums1.length - 1;
        while(i>=0){
            if(m-1 == -1){
                nums1[i] = nums2[n-1];
                n--;
            }else if(n-1 == -1){
                nums1[i] = nums1[m-1];
                m--;
            }else if(nums2[n-1] > nums1[m-1]){
                nums1[i] = nums2[n-1];
                n--;
            }else{
                nums1[i] = nums1[m-1];
                m--;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        lc88 lc88 = new lc88();
        lc88.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
