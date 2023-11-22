package suanfatongguanshouce.binarysearch;

public class lc704 {
    public int search(int[] nums, int target) {
        int left =0, right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
