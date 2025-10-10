import java.util.*;
class Solution {
    static boolean[][] visited;
    boolean inRange(int r, int c, int row, int col){
        return (r>=0&&r<row)&&(c>=0&&c<col);
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dist = -1;

        if(grid[0][0]==1 || grid[row-1][col-1]==1) return dist;

        visited = new boolean[row][col];
        int[] dr = {0,1,1,1,0,-1,-1,-1};
        int[] dc = {-1,-1,0,1,1,1,0,-1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int curD = cur[2];

            if(curR == row-1 && curC == col-1 ){
                dist = curD;
                break;
            }
            for(int i=0; i<8;i++){
                int nextR = curR+dr[i];
                int nextC = curC+dc[i];

                if(inRange(nextR,nextC,row,col)){
                    if(grid[nextR][nextC]!=1 && !visited[nextR][nextC]){
                        queue.offer(new int[]{nextR,nextC,curD+1});
                        visited[nextR][nextC]= true;
                    }
                }
            }
        }
        return dist;
    }
}