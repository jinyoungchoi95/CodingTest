import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2178 {
    public static int N, M;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] map;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<index> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new index(0,0,1));
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            if(tmp.x==N-1 && tmp.y==M-1){
                return tmp.count;
            }
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny]==0){
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new index(nx, ny, tmp.count+1));
            }
        }

        return 0;
    }
    public static class index{
        int x;
        int y;
        int count;
        public index(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}