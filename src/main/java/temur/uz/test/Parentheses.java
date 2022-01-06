package temur.uz.test;

import java.util.Stack;

public class Parentheses {
    public static void main(String[] args) {
        String s = ")(";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
//        int count1 = 0, count2 = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.substring(i, i+1).equals("(")){
//                count1 ++;
//            }else {
//                count2 ++;
//            }
//        }
//        if (count1>count2)
//            return  count1;
//        return count2;

        int l = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else ans = Math.max(ans, i - stack.peek());
            }
        return ans;
    }
}
