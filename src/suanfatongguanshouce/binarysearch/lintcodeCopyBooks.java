package suanfatongguanshouce.binarysearch;

public class lintcodeCopyBooks {
    public int copyBooks(int[] pages, int k) {
        int left = 0, right = Integer.MAX_VALUE;
        while(left < right){
            int mid = left + (right - left)/2;
            if(isVaid(pages, k, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isVaid(int[] pages, int k, int mid) {
        int count = 1;
        int cur = 0;
        for(int page: pages){
            if(page > mid){
                return false;
            }
            if(cur + page > mid){
                count ++;
                cur = 0;
            }
            cur += page;
        }
        return count <= k;
    }

    public static void main(String[] args) {
        lintcodeCopyBooks lc = new lintcodeCopyBooks();
        int[] pages = {3, 2, 4};
        System.out.println(lc.copyBooks(pages,2));
    }
}
