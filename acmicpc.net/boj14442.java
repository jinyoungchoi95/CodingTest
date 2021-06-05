import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class boj14442 {
    public static int n, m, k;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        map = new int[n][m];
        for(int i=0; i<n; i++){
            input = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        Queue<index> queue = new ArrayDeque<>();
        visited = new int[n][m][k+1];
        queue.add(new index(0, 0, 0, 0));

        while(!queue.isEmpty()){
            index tmp = queue.poll();
            if(tmp.x == n-1 && tmp.y == m-1){
                System.out.println(tmp.count+1);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

                if(map[nx][ny] == 0){
                    if(visited[nx][ny][tmp.broken] == 0 || tmp.count < visited[nx][ny][tmp.broken]){
                        queue.add(new index(nx, ny, tmp.count+1, tmp.broken));
                    }
                }
                else{
                    if(tmp.broken == k) continue;
                    if(visited[nx][ny][tmp.broken+1] ==0 || tmp.count < visited[nx][ny][tmp.broken+1]){
                        queue.add(new index(nx, ny, tmp.count+1, tmp.broken+1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
    public static class index{
        int x;
        int y;
        int count;
        int broken;
        public index(int x, int y, int count, int broken) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.broken = broken;
        }
    }
}
