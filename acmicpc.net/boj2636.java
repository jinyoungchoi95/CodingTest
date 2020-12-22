import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj2636 {
    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited;
    public static ArrayList<index> melt = new ArrayList<>();
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        int hour = 0;
        int amount = 0;
        while(true){
            melt.clear();
            bfs();
            if(melt.isEmpty()){
                break;
            }
            hour++;
            amount = melt.size();
            for(int i=0; i<melt.size(); i++){
                index tmp = melt.get(i);
                map[tmp.x][tmp.y] = 0;
            }
        }
        System.out.println(hour);
        System.out.println(amount);
    }

    public static void bfs(){
         visited = new boolean[N][M];
         Queue<index> queue = new LinkedList<>();
         queue.add(new index(0,0));
         visited[0][0] = true;

         while(!queue.isEmpty()){
             index tmp = queue.poll();
             for(int i=0; i<4; i++){
                 int nx = tmp.x + dx[i];
                 int ny = tmp.y + dy[i];
                 if(nx<0 || ny<0 || nx>=N || ny>=M){
                     continue;
                 }
                 if(!visited[nx][ny]){
                     visited[nx][ny] = true;
                     if(map[nx][ny]==1){
                         melt.add(new index(nx,ny));
                     }
                     else if(map[nx][ny]==0){
                         queue.add(new index(nx,ny));
                     }
                 }

             }
         }
    }

    public static class index{
        int x;
        int y;
        public index(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}