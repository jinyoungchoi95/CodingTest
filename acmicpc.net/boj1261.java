import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1261 {
    public static int N, M;
    public static int[][] map;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[0]);
        map = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        PriorityQueue<index> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new index(0,0,0));

        while(!queue.isEmpty()){
            index tmp = queue.poll();

            if(tmp.x==N-1 && tmp.y==M-1){
                System.out.println(tmp.cost);
                return;
            }

            if(visited[tmp.x][tmp.y]) continue;
            visited[tmp.x][tmp.y] = true;

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(map[nx][ny]==1){
                    queue.add(new index(nx, ny, tmp.cost+1));
                }
                else{
                    queue.add(new index(nx, ny, tmp.cost));
                }
            }
        }

    }
    public static class index implements Comparable<index>{
        int x;
        int y;
        int cost;
        public index(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        public int compareTo(index o) {
            return this.cost - o.cost;
        }
    }
}
