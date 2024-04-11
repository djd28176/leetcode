package suanfatongguanshouce.binarysearch;

public class lc34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums.length == 0)
            return res;
        res[0] = findLeft(nums,target);
        res[1] = findRight(nums, target);
        return res;
    }
    public int findLeft(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if (left < nums.length && nums[left] == target)
            return left;
        else
            return -1;
    }
    public int findRight(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if (right >= 0 && nums[right] == target)
            return right;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        int[] res = new lc34().searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
