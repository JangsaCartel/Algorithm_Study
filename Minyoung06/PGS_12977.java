import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        boolean[] isPrime = new boolean[3001]; // 최악의 경우 1000+1000+1000
        int N = isPrime.length;
        
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2; i<=Math.sqrt(N); i++){
            for(int j=i*i; j<N; j+=i){
                isPrime[j]=false;
            }
        }
        
        int len = nums.length;
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    if(isPrime[nums[i]+nums[j]+nums[k]]) 
                        answer++;
                }
            }
        }
        
        return answer;
    }
}