package lcjiajia.stack;

import java.util.Deque;
import java.util.LinkedList;

public class lc150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if(isNumber(s)){
                stack.push(Integer.parseInt(s));
            }else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (s){
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num1-num2);
                        break;
                    case"*":
                        stack.push(num1*num2);
                        break;
                    case"/":
                        stack.push(num1/num2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

    public static void main(String[] args) {
        lc150 lc150 = new lc150();
        System.out.println(lc150.evalRPN(new String[]{"4","13","5","/","+"}));
    }

}
