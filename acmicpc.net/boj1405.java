import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1405 {
    public static int N;
    public static double[] dir;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static double answer = 0;
    public static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        dir = new double[4];
        for(int i=0; i<4; i++){
            dir[i] = Double.parseDouble(input[i+1]) / 100;
        }
        map = new boolean[2*N+1][2*N+1];
        map[N][N] = true;
        dfs(0, 1, map, N, N);
        System.out.println(answer);
    }
    public static void dfs(int count, double value, boolean[][] map, int x, int y){
        if(count==N){
            answer += value;
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>2*N || ny>2*N){
                continue;
            }
            if(!map[nx][ny]){
                map[nx][ny] = true;
                dfs(count+1, value*dir[i], map, nx, ny);
                map[nx][ny] = false;
            }
        }
    }
}
