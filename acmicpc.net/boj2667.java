import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class boj2667 {
    public static int N;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    answer.add(bfs(i,j));
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }

    }
    public static int bfs(int x, int y){
        Queue<index> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new index(x, y));
        int result = 0;
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            result++;
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny] || map[nx][ny]==0){
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new index(nx, ny));
            }
        }



        return result;
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