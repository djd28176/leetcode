package lcjiajia.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc84 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];
        int[] temp = new int[heights.length + 2];
        for(int i = 0; i < heights.length; ++i){
            temp[i+1] = heights[i];
        }
        heights = temp;
        int area = 0;
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for(int i = 1; i < len; ++i){
            while(heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area,height*width);
            }
            stack.addLast(i);
        }
        return area;
    }
}
