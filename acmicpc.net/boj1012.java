import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1012 {
    public static int M, N, K;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);
            map = new int[N][M];
            visited = new boolean[N][M];
            for(int i=0; i<K; i++){
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                map[b][a] = 1;
            }
            int answer = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(!visited[i][j] && map[i][j]==1){
                        bfs(i,j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
    public static void bfs(int x, int y){
        Queue<index> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new index(x, y));
        while(!queue.isEmpty()){
            index tmp = queue.poll();

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny]==0){
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new index(nx, ny));
            }
        }

    }
    public static class index{
        int x,y;
        public index(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
