import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj2206 {
    public static int N, M;
    public static int[][] map;
    public static boolean[][][] visited;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];
        for(int i=1; i<=N; i++){
            input = br.readLine().split("");
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        Queue<index> queue = new LinkedList<>();
        queue.add(new index(1,1,0,1));
        visited[1][1][0] = true;
        visited[1][1][1] = true;
        while(!queue.isEmpty()){
            index tmp = queue.poll();

            if(tmp.x==N && tmp.y==M){
                System.out.println(tmp.count);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                int wall = tmp.wall;
                int count = tmp.count;

                if(nx<=0 || ny<=0 || nx>N || ny>M){
                    continue;
                }

                if(map[nx][ny]==1){
                    if(wall==0 && !visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        queue.add(new index(nx,ny,1,count+1));
                    }
                }
                else{
                    if(!visited[nx][ny][wall]){
                        visited[nx][ny][wall] = true;
                        queue.add(new index(nx,ny,wall,count+1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
    public static class index{
        int x;
        int y;
        int wall;
        int count;
        public index(int x, int y, int wall, int count){
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.count = count;
        }
    }

}
