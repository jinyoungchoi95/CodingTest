import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1600 {
    public static int K, w, h;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        for(int i=0; i<map.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<map[i].length; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][][] visited = new boolean[h][w][K+1];
        Queue<index> queue = new LinkedList<>();
        visited[0][0][0] = true;
        queue.add(new index(0, 0, 0, 0));

        while(!queue.isEmpty()){
            index tmp = queue.poll();
            if(tmp.x == h-1 && tmp.y ==w-1){
                System.out.println(tmp.value);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=h || ny>=w) continue;
                if(visited[nx][ny][tmp.k] || map[nx][ny] == 1) continue;
                visited[nx][ny][tmp.k] = true;
                queue.add(new index(nx,ny,tmp.value+1, tmp.k));
            }
            for(int i=0; i<hx.length; i++){
                int nx = tmp.x + hx[i];
                int ny = tmp.y + hy[i];
                if(nx<0 || ny<0 || nx>=h || ny>=w) continue;
                if(tmp.k == K) continue;
                if(visited[nx][ny][tmp.k+1] || map[nx][ny] == 1) continue;
                visited[nx][ny][tmp.k+1] = true;
                queue.add(new index(nx,ny,tmp.value+1, tmp.k+1));
            }
        }
        System.out.println(-1);
    }
    public static class index{
        int x;
        int y;
        int value;
        int k;

        public index(int x, int y, int value, int k) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.k = k;
        }
    }
}
