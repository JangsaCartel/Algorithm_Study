import java.util.*;
class Solution {
    boolean solution(String s) {
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push("(");
            else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(stack.isEmpty())return true;
        else return false;
    }
}