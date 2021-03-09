import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj7576 {
    public static int M, N;
    public static int[][] map;
    public static boolean[][] visited;
    public static int answer = 0;
    public static Queue<index> queue = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==1){
                    queue.add(new index(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        bfs();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0) answer = -1;
            }
        }
        System.out.println(answer);
    }
    public static void bfs(){
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            answer = Math.max(answer, tmp.day);

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny]!=0){
                    continue;
                }
                visited[nx][ny] = true;
                map[nx][ny] = 1;
                queue.add(new index(nx, ny, tmp.day+1));
            }
        }
    }
    public static class index{
        int x;
        int y;
        int day;
        public index(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
