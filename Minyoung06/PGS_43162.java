import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer=0;
        boolean[] visited = new boolean[n];
        
        for(int cur = 0;cur<n;cur++){
            if(!visited[cur]){
                bfs(computers,visited,cur);
                answer++;
            }
        }
        return answer;
    }
    void bfs(int[][]computers, boolean[] visited, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.remove();
            for(int next=0;next<computers.length;next++){
                if(computers[cur][next]==1&&!visited[next]){
                    queue.add(next);
                    visited[next]=true;
                }
            }
        }
    }
}