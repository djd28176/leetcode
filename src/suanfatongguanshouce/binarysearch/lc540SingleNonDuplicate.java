package suanfatongguanshouce.binarysearch;

public class lc540SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length -1;
        //[1 , 1, 2, 3, 3,4,4,8,8]
        // 0   1  2  3  4 5 6 7 8
        //因为mid是偶数一定和右边的奇数要一样，反之同理， 如果都一样证明前面的都是一对 mid^1是改变末尾的01正好是取奇偶相反
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == nums[mid^1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3,4,4,8,8};
        System.out.println(new lc540SingleNonDuplicate().singleNonDuplicate(nums));
    }
}
