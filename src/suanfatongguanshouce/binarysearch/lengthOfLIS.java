package suanfatongguanshouce.binarysearch;

public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length + 1];
        arr[1] = nums[0];
        int len = 1;
        for(int num : nums){
            if(num > arr[len]){
                arr[++len] = num;
            }
            else{
                int left = 1, right = len, pos = 0;
                while(left <= right){
                    int mid = (left + right ) >>1;
                    if(arr[mid] < num){
                        pos = mid;
                        left = mid + 1;
                    }
                    else{
                        right = mid - 1;
                    }
                }
                arr[pos + 1] = num;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS l = new lengthOfLIS();
        System.out.println(l.lengthOfLIS(nums));
    }
}
