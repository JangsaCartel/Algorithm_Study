#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> nums) {
    int N = 3001; // 최댓값; 1000+1000+1000
    vector<bool> isPrime(N,true);
    isPrime[0] = isPrime[1] = false;
    
    //에라토스테네스의 체
    for(int i=2; i*i<N; i++){
        if(isPrime[i]){
            for(int j=i*i; j<=N; j+=i){
                isPrime[j] = false;
            }
        }
    }
    
    int answer = 0;
    int len = nums.size();
    for(int i=0; i<len-2; i++){
        for(int j=i+1; j<len-1; j++){
            for(int k=j+1; k<len; k++){
                if (isPrime[nums[i]+nums[j]+nums[k]]) answer++;
            }
        }
    }
    return answer;
}