import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class boj2146 {
    public static int N;
    public static int[][] map;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int annotation = 2;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1){
                    annotate(i,j);
                    annotation++;
                }
            }
        }

        boolean[] annotation_visited = new boolean[annotation];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0) continue;
                if(!annotation_visited[map[i][j]]){
                    annotation_visited[map[i][j]] = true;
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer);

    }
    public static void bfs(int x, int y){
        Queue<index> queue = new LinkedList<>();
        queue.add(new index(x,y));
        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;
        ArrayList<index> side = new ArrayList<>();
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N){
                    continue;
                }
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(map[nx][ny] == map[tmp.x][tmp.y]){
                        queue.add(new index(nx,ny));
                    }
                    else if(map[nx][ny] == 0){
                        side.add(new index(nx,ny));
                    }
                }
            }
        }
        Queue<index2> queue2 = new LinkedList<>();
        for(int i=0; i<side.size(); i++){
            index a = side.get(i);
            queue2.add(new index2(a.x, a.y,1));
        }

        while(!queue2.isEmpty()){
            index2 tmp = queue2.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny >=N){
                    continue;
                }
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(map[nx][ny]!=0){
                        answer = Math.min(answer, tmp.count);
                        return;
                    }
                    queue2.add(new index2(nx,ny,tmp.count+1));
                }
            }
        }

    }

    public static void annotate(int x, int y){
        Queue<index> queue = new LinkedList<>();
        queue.add(new index(x,y));
        boolean[][] visited = new boolean[N][N];
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            map[tmp.x][tmp.y] = annotation;
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N){
                    continue;
                }
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(map[nx][ny]==1){
                        queue.add(new index(nx,ny));
                    }
                }
            }
        }


    }
    public static class index2{
        int x;
        int y;
        int count;
        public index2(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
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
