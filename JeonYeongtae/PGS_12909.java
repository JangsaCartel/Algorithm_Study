import java.util.*;

class Solution {
    public boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        // 문자열 순회
        for (char c : s.toCharArray()) {
            // 열린 괄호 처리
            if (c == '(') {
                stack.push(c);
            } 
            // 닫힌 괄호 처리    
            else { 
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}