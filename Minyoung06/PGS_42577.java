import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<>();
        
        for(String n: phone_book){
            map.put(n,true);
        }
        for(String num: phone_book){
            for(int i=1;i<num.length();i++){
                String prefix = num.substring(0,i);
                if(map.containsKey(prefix)){
                    return false;
                }
            }
        }
        return true;
    }
}