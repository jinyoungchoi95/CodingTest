import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9663 {
    public static int N;
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];
        for(int i=0; i<N; i++){
            map[0][i] = true;
            dfs(map, 1);
            map[0][i] = false;
        }
        System.out.println(answer);
    }
    public static void dfs(boolean[][] map, int level){
        if(level == N){
            answer++;
            return;
        }
        for(int i=0; i<N; i++){
            if(upCheck(map,level-1, i) && leftCheck(map, level, i) && rightCheck(map, level, i)){
                map[level][i] = true;
                dfs(map, level+1);
                map[level][i] = false;
            }
        }
    }
    public static boolean upCheck(boolean[][] map, int x, int y){
        for(int i=x; i>=0; i--){
            if(map[i][y]) return false;
        }
        return true;
    }
    public static boolean leftCheck(boolean[][] map, int x, int y){
        int nx = x-1;
        int ny = y-1;
        while(nx>=0 && ny>=0){
            if(map[nx][ny]){
                return false;
            }
            nx--;
            ny--;
        }
        return true;
    }
    public static boolean rightCheck(boolean[][] map, int x, int y){
        int nx = x-1;
        int ny = y+1;
        while(nx>=0 && ny<N){
            if(map[nx][ny]){
                return false;
            }
            nx--;
            ny++;
        }
        return true;
    }
}
