import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2665 {
    public static int n;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int[][] visited = new int[n][n];
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(input[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<index> queue = new LinkedList<>();
        queue.add(new index(0,0));
        visited[0][0] = 0;
        while(!queue.isEmpty()){
            index tmp = queue.poll();

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if(visited[nx][ny] > visited[tmp.x][tmp.y]){
                    if(map[nx][ny]==1){
                        visited[nx][ny] = visited[tmp.x][tmp.y];
                        queue.add(new index(nx, ny));
                    }
                    else{
                        visited[nx][ny] = visited[tmp.x][tmp.y]+1;
                        queue.add(new index(nx, ny));
                    }
                }
            }
        }
        System.out.println(visited[n-1][n-1]);
    }
    public static class index {
        int x, y;

        public index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}