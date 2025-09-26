import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edge){
            int edge1 = e[0];
            int edge2 = e[1];
            
            graph.get(edge1-1).add(edge2-1);
            graph.get(edge2-1).add(edge1-1);
        }
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        
        bfs(graph, visited, 0, distance);
        
        int max = 0, count=0;
        
        for(int d: distance){
            if(d>max){
                max = d;
                count=1;
            }
            else if(d==max) count++;
        }
        return count;
        
    }
    void bfs(List<List<Integer>> graph, boolean[] visited, int start, int[] distance){
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(start);
        visited[start]=true;
        distance[start] = 0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next: graph.get(cur)){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next]= true;
                    distance[next] = distance[cur]+1;
                }
            }
            
        }
    }
}