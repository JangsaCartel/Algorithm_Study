import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char x:s.toCharArray()){
            if(x=='('||x=='{'||x=='['){stack.push(x);}
            else if (x==')'){
                if(stack.isEmpty()||stack.pop()!='(') return false;
            }
            else if (x=='}'){
                if(stack.isEmpty()||stack.pop()!='{') return false;
            }
            else if (x==']'){
                if(stack.isEmpty()||stack.pop()!='[') return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}