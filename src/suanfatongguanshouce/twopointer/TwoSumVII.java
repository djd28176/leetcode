package suanfatongguanshouce.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumVII {
    /**
     * @param nums:   the input array
     * @param target: the target number
     * @return: return the target pair
     */
    public List<List<Integer>> twoSumVII(int[] nums, int target) {
        // write your code here
        int most = Integer.MIN_VALUE, least = Integer.MAX_VALUE;
        int mostIndex = 0, leastIndex = 0;

//        get the different start point for biggest and smallest elements
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > most) {
                most = nums[index];
                mostIndex = index;
            }
            if (nums[index] < least) {
                least = nums[index];
                leastIndex = index;
            }
        }


        List<List<Integer>> res = new ArrayList<>();

        int start = leastIndex;
        int end = mostIndex;
        while (nums[start] < nums[end]) {
            if (nums[start] + nums[end] == target) {
                res.add(Arrays.asList(Math.min(start, end), Math.max(start, end)));
                end = findNextSmallerPos(nums, end);
                start = findNextBiggerPos(nums, start);
            } else if (nums[start] + nums[end] > target) end = findNextSmallerPos(nums, end);
            else start = findNextBiggerPos(nums, start);
        }
        return res;
    }

    private int findNextSmallerPos(int[] nums, int cur) {
        if (nums[cur] <= 0) {
            while (cur < nums.length - 1) {
                cur++;
                if (nums[cur] < 0) return cur;
            }

        } else {
            while (cur > 0) {
                cur--;
                if (nums[cur] >= 0) return cur;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) return i;
            }
        }
        return cur;
    }

    private int findNextBiggerPos(int[] nums, int cur) {
        if (nums[cur] >= 0) {
            while (cur < nums.length - 1) {
                cur++;
                if (nums[cur] > 0) return cur;
            }
        } else {
            while (cur > 0) {
                cur--;
                if (nums[cur] <= 0) return cur;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) return i;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        TwoSumVII twoSumVII = new TwoSumVII();
        System.out.println(twoSumVII.twoSumVII(new int[]{0,-1,2,-3,4},1));
    }
}
