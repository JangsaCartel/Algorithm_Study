import java.util.*;
class Solution {
    public int solution(int n, int m, int[][] hole) {
        boolean[][] trap = new boolean[n+1][m+1];
        for(int[] h: hole){
            trap[h[0]][h[1]]=true;
        }
        boolean[][][] visited = new boolean[n+1][m+1][2];
        Queue<int[]> queue = new LinkedList<>();
        
        visited[1][1][0]=true;
        queue.offer(new int[]{1,1,0,0});
        
        int[] dr = {0,1,0,-1,0,2,0,-2};
        int[] dc = {1,0,-1,0,2,0,-2,0};
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], jumped = cur[2], dist = cur[3];
            
            for(int i=0;i<((jumped==1)?4:8);i++){
                int nr= r+dr[i],nc=c+dc[i];
                int nj = (jumped==1)?1:(i/4);
                
                if(nr>=1&&nr<=n&&nc>=1&&nc<=m &&!visited[nr][nc][nj]&&!trap[nr][nc]){
                    visited[nr][nc][nj]=true;
                    if(nr==n&&nc==m)return dist+1;
                    queue.offer(new int[]{nr,nc,nj,dist+1});
                }
            }
        }
        return -1;
    }
}