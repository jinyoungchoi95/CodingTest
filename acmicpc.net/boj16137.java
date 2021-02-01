import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj16137 {
    public static int n, m;
    public static int[][] map;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][n];
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==0 && check_cross(i,j)){
                    map[i][j] = m;
                    bfs();
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(answer);
    }
    public static void bfs(){
        Queue<index> queue = new LinkedList<>();
        queue.add(new index(0,0,0));
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while(!queue.isEmpty()){
            index tmp = queue.poll();
            if(tmp.x==n-1 && tmp.y==n-1){
                answer = Math.min(answer, tmp.time);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n || map[nx][ny]==0 || visited[nx][ny]) continue;

                if(map[nx][ny]==1){
                    visited[nx][ny] = true;
                    queue.add(new index(nx,ny,tmp.time+1));
                }
                else if(map[nx][ny]>1 && map[tmp.x][tmp.y]==1){
                    if((tmp.time+1)%map[nx][ny]==0){
                        visited[nx][ny] = true;
                        queue.add(new index(nx, ny, tmp.time+1));
                    }
                    else{
                        queue.add(new index(tmp.x, tmp.y, tmp.time+1));
                    }
                }
            }
        }
    }

    public static boolean check_cross(int x, int y){
        boolean left = false;
        boolean right = false;
        for(int i=0; i<2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
            if(map[nx][ny]==0) left = true;
        }
        for(int i=2; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
            if(map[nx][ny]==0) right = true;
        }
        if(right&&left) return false;
        return true;
    }
    public static class index{
        int x;
        int y;
        int time;
        public index(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}
