import java.util.*;
class Solution {
    int[] dr = {0,1,0,-1};
    int[] dc = {-1,0,1,0};
    boolean inRange(int r, int c, int row, int col){
        return (r>=0&&r<row)&&(c>=0&&c<col);
    }
    static boolean[][] visited;
    public int solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        int sx=0,sy=0,lx=0,ly=0,ex=0,ey=0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char ch = maps[i].charAt(j);
                if(ch=='S'){sx=i;sy=j;}
                else if(ch=='L'){lx=i;ly=j;}
                else if(ch=='E'){ex=i;ey=j;}
            }
        }
        
        int distL = BFS(sx,sy,maps,'L');
        if(distL==-1)return -1;
        int distE = BFS(lx,ly,maps,'E');
        if(distE==-1)return -1;
        
        return distL+distE;
    }
    int BFS(int r,int c, String[] maps, char target){
        int row = maps.length;
        int col = maps[0].length();
        boolean[][] visited = new boolean[row][col];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c,0});
        visited[r][c]=true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int curD = cur[2];
            
            if(maps[curR].charAt(curC)==target) return curD;
            
            for(int i=0;i<4;i++){
                int nextR = curR+dr[i];
                int nextC = curC+dc[i];
                
                if(inRange(nextR,nextC,row,col)){
                    if(maps[nextR].charAt(nextC)!='X' && !visited[nextR][nextC]){
                        queue.offer(new int[]{nextR,nextC,curD+1});
                        visited[nextR][nextC]=true;
                    }
                }
            }
        }
        return -1;
    }
}