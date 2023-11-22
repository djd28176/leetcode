package suanfatongguanshouce.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class lc658FindKClosetElement {
    /**
     Initialization:

     left: Starting index of the potential result subarray.
     right: Ending index of the potential result subarray (arr.length - k to make sure we have enough elements).

     Binary Search:

     Use a binary search to find the starting index of the potential result subarray.
     The condition x - arr[mid] > arr[mid + k] - x compares the differences between
     the elements at indices mid and mid + k with the target x. This helps in narrowing down the search space.
     If the difference on the left side is greater,
     it means we need to move to the right to get closer to the target x. So, update left = mid + 1.
     If the difference on the right side is greater or equal, it means we are closer to the target on the right side.
     So, update right = mid.
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        List<Integer> res = new ArrayList<>();
        while(left < right){
            int mid = left + (right - left)/2;
            if(x - arr[mid] > arr[mid+k] -x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        for(int i = left; i < left + k; i++){
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        lc658FindKClosetElement lc = new lc658FindKClosetElement();
        System.out.println(lc.findClosestElements(new int[]{1,2,3,4,5},4,3));
    }
}
