package lcjiajia.stack;

import java.util.*;

public class lc394 {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        char[] c = s.toCharArray();
        for(int i = 0; i<c.length; i++){
            if(c[i] == ']'){
                StringBuilder sb = new StringBuilder();
                while(Objects.nonNull(stack.peek())&& !stack.peek().equals("[")){
                    sb.insert(0,stack.pop());
                }
                stack.pop();
                StringBuilder number =  new StringBuilder();
                while(Objects.nonNull(stack.peek())&&isNumber(stack.peek())){
                    number.insert(0,stack.pop());
                }
                int time = Integer.parseInt(number.toString());
                while(time >0){
                    stack.push(sb.toString());
                    time--;
                }
            }
            else stack.push(String.valueOf(c[i]));
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        return res.toString();
    }
    private boolean isNumber(String s){
        if(s.equals("0")||s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")||s.equals("5")||s.equals("6")||
                s.equals("7")||s.equals("8")||s.equals("9"))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        lc394 lc394 = new lc394();
        System.out.println(lc394.decodeString("100[leetcode]"));
    }
}
