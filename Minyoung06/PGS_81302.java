import java.util.*;
class Solution {
    boolean inRange(int r, int c){
        return (r>=0&&r<5)&&(c>=0&&c<5);
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0;i<answer.length;i++){
            if(check(places[i])) answer[i]=1;
        }
        return answer;
    }
    boolean check(String[] place){
        for(int r=0;r<5;r++){
            for(int c=0;c<5;c++){
                if(place[r].charAt(c)=='P'){
                    if(!bfs(r,c,place))return false;
                }
            }
        }
        return true;
    }
    boolean bfs(int r, int c, String[] place){
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        
        int[] dr = {0,1,0,-1};
        int[] dc = {-1,0,1,0};
        
        queue.offer(new int[]{r,c,0});
        visited[r][c]=true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[2]>=2)continue;
            
            for(int i=0;i<4;i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                int nd = cur[2]+1;
                
                if(inRange(nr,nc)&&!visited[nr][nc]&&place[nr].charAt(nc)!='X'){
                    if(place[nr].charAt(nc)=='P')return false;
                    visited[nr][nc]=true;
                    queue.offer(new int[]{nr,nc,nd});
                }
            }
        }
        return true;
    }
}