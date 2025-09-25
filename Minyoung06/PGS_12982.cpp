#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> d, int budget) {
    for(int i=1;i<d.size();i++){
        int key=d[i];
        int j=i-1;
        while(j>=0 && d[j]>key){
            d[j+1]=d[j];
            j--;
        }
        d[j+1]=key;
    }
    
    int cnt = 0, sum = 0;
    for(int x:d){
        if(sum+x>budget)break;
        sum+=x;
        cnt++;
    }
    return cnt;
}