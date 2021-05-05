import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1726 {
    public static int m, n;
    public static int[][] map;
    public static boolean[][][] visited;
    public static index start, end;
    public static int[] dx = {0, 0, 0, 1, -1};
    public static int[] dy = {0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n][5];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        start = new index(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), 0);
        st = new StringTokenizer(br.readLine());
        end = new index(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), 0);
        bfs();
    }
    public static void bfs() {
        Queue<index> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][start.d] = true;

        while(!queue.isEmpty()){
            index tmp = queue.poll();
            if(tmp.x == end.x && tmp.y == end.y && tmp.d == end.d){
                System.out.println(tmp.c);
                return;
            }

            int nx = tmp.x;
            int ny = tmp.y;
            for(int i=1; i<=3; i++){
                nx += dx[tmp.d];
                ny += dy[tmp.d];
                if(nx<0 || ny<0 || nx>=m || ny>=n || visited[nx][ny][tmp.d]) continue;
                if(map[nx][ny]==1) break;
                visited[nx][ny][tmp.d] = true;
                queue.add(new index(nx, ny, tmp.d, tmp.c + 1));
            }

            for(int i=1; i<=4; i++){
                if(i==tmp.d || (i+1)/2==(tmp.d+1)/2) continue;
                if(visited[tmp.x][tmp.y][i]) continue;
                visited[tmp.x][tmp.y][i] = true;
                queue.add(new index(tmp.x, tmp.y, i, tmp.c + 1));
            }
        }
    }
    public static class index{
        int x;
        int y;
        int d;
        int c;

        public index(int x, int y, int d, int c) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }
}