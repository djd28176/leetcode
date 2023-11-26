package lcjiajia.array;

import java.util.List;

public class lc414 {
    public int thirdMax(int[] nums) {
        Integer a = null, b = null, c = null;
        for (int num : nums) {
            if (a == null || num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && (b == null || num > b)) {
                c = b;
                b = num;
            } else if (b != null && b > num && (c == null || num > c)) {
                c = num;
            }
        }
        return c == null ? a : c;
    }

    public static void main(String[] args) {
        lc414 lc414 = new lc414();
        int[] nums = {1,2,-2147483648};
        System.out.println(lc414.thirdMax(nums));
    }
}
