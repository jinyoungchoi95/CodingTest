import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    public boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int max = 0;
        int count = 0;
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    int sum = 0;
                    count++;
                    visited[i][j] = true;
                    Queue<index> queue = new LinkedList<>();
                    queue.add(new index(i,j));
                    while(!queue.isEmpty()){
                        index tmp = queue.poll();
                        sum++;
                        for(int t=0; t<4; t++){
                            int nx = tmp.x + dx[t];
                            int ny = tmp.y + dy[t];
                            if(nx<0 || ny<0 || nx>=m || ny>=n){
                                continue;
                            }
                            if(!visited[nx][ny] && picture[nx][ny] == picture[i][j]){
                                visited[nx][ny] = true;
                                queue.add(new index(nx,ny));
                            }
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        int[] answer = {count, max};
        return answer;
    }
    public class index{
        int x;
        int y;
        public index(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}