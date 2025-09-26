class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(rooms, visited, 0);
        
        for(boolean v: visited){
            if (!v) return false;
        }
        return true;
    }
    void dfs(List<List<Integer>> rooms, boolean[] visited, int start){
        visited[start] = true;
        for(int next: rooms.get(start)){
            if(!visited[next]){
                dfs(rooms, visited, next);
            }
        }
    }
}