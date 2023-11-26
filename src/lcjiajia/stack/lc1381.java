package lcjiajia.stack;

import java.util.Deque;
import java.util.LinkedList;

public class lc1381 {
    Deque<Integer> stack1 = new LinkedList<>();
    Deque<Integer> stack2 = new LinkedList<>();
    int maxSize;
    public lc1381(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(stack1.size() < maxSize){
            stack1.push(x);
        }
    }

    public int pop() {
        return stack1.isEmpty() ? -1:stack1.pop();
    }

    public void increment(int k, int val) {
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());

        while(!stack2.isEmpty()){
            if(k > 0)stack1.push((stack2.pop()+val));
            else stack1.push((stack2.pop()));
            k--;
        }
    }
//    class CustomStack {
//        int[] stack;
//        int[] add;
//        int top;
//
//        public CustomStack(int maxSize) {
//            stack = new int[maxSize];
//            add = new int[maxSize];
//            top = -1;
//        }
//
//        public void push(int x) {
//            if (top != stack.length - 1) {
//                ++top;
//                stack[top] = x;
//            }
//        }
//
//        public int pop() {
//            if (top == -1) {
//                return -1;
//            }
//            int ret = stack[top] + add[top];
//            if (top != 0) {
//                add[top - 1] += add[top];
//            }
//            add[top] = 0;
//            --top;
//            return ret;
//        }
//
//        public void increment(int k, int val) {
//            int limit = Math.min(k - 1, top);
//            if (limit >= 0) {
//                add[limit] += val;
//            }
//        }
//    }
//
}
