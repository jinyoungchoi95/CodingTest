import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj4485 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int index = 1;
        while(n!=0){
            int[][] map = new int[n][n];
            for(int i=0; i<n; i++){
                String[] input = br.readLine().split(" ");
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }
            int[][] visited = new int[n][n];
            Queue<index> queue = new LinkedList<>();
            for(int i=0; i<n; i++){
                Arrays.fill(visited[i], Integer.MAX_VALUE);
            }
            visited[0][0] = map[0][0];
            queue.add(new index(0,0));
            int answer = 0;
            while(!queue.isEmpty()){
                index tmp = queue.poll();

                if(tmp.x==n-1 && tmp.y==n-1) continue;


                for(int i=0; i<4; i++){
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

                    if(visited[tmp.x][tmp.y] + map[nx][ny] < visited[nx][ny]){
                        visited[nx][ny] = visited[tmp.x][tmp.y] + map[nx][ny];
                        queue.add(new index(nx, ny));
                    }
                }
            }

            System.out.println("Problem " + index++ + ": " + visited[n-1][n-1]);
            n = Integer.parseInt(br.readLine());
        }
    }
    public static class index{
        int x;
        int y;
        public index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
