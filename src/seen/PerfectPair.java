package seen;

public class PerfectPair {
    static int countPerfectPairs(int[] arr) {
        int perfectPairsCount = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPerfectPair(arr[i], arr[j])) {
                    perfectPairsCount++;
                }
            }
        }

        return perfectPairsCount;
    }
    static boolean isPerfectPair(int x, int y) {
        int minXY = Math.min(Math.abs(x - y), Math.abs(x + y));
        int minXY_abs = Math.min(Math.abs(x), Math.abs(y));

        int maxXY = Math.max(Math.abs(x - y), Math.abs(x + y));
        int maxXY_abs = Math.max(Math.abs(x), Math.abs(y));

        return minXY <= minXY_abs && maxXY >= maxXY_abs;
    }
    public static void main(String[] args) {
        System.out.println(countPerfectPairs(new int[]{2,5,-3}));
    }
}
