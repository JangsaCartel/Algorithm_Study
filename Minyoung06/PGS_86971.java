import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;
        
        for(int i=0;i<wires.length;i++){
            List<Integer>[] graph = buildGraph(n,wires,i);
            int size1 = bfs(graph, wires[i][0],n);
            int size2 = n-size1;
            int diff = Math.abs(size1-size2);
            minDiff = Math.min(minDiff,diff);
        }
        return minDiff;
    }
    
    List<Integer>[] buildGraph(int n, int[][] wires, int cut){
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<wires.length;i++){
            if(i==cut)continue;
            
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        return graph;
    }
    
    int bfs(List<Integer>[] graph, int s, int n){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        int count = 1;
        
        queue.offer(s);
        visited[s]=true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next: graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}