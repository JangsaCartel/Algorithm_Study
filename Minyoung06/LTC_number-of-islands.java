import java.util.*;
class Solution {
    static boolean visited[][];
    boolean inRange(int r, int c, int row, int col){
        return (r>=0&&r<row)&&(c>=0&&c<col);
    }

    public int numIslands(char[][] grid) {
        int num = 0;
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if((grid[i][j]=='1'&&(!visited[i][j]))){
                    dfs(i,j,grid);
                    num++;
                }
            }
        }
        return num;
    }
    void dfs(int r,int c,char[][]grid){
        int row = grid.length;
        int col = grid[0].length;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        visited[r][c]=true;

        for(int[] d:dir){
            int nextR = r+d[0];
            int nextC = c+d[1];
            if(inRange(nextR,nextC,row,col)){
                if((grid[nextR][nextC]=='1')&&(!visited[nextR][nextC])){
                    dfs(nextR,nextC,grid);
                }
            }
        }
    }
}