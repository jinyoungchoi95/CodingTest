import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14620 {
    public static int N;
    public static int[][] map;
    public static int answer = Integer.MAX_VALUE;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        dfs(0, 0, visited);
        System.out.println(answer);
    }
    public static void dfs(int count, int cost, boolean[][] visited){
        if(count==3){
            answer = Math.min(answer, cost);
            return;
        }
        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                if(check(visited, i, j)){
                    visit(visited, i, j);
                    dfs(count+1, cost+cal_cost(i,j), visited);
                    unvisit(visited, i, j);
                }
            }
        }
    }
    public static boolean check(boolean[][] visited, int x, int y){
        if(visited[x][y]) return false;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(visited[nx][ny]) return false;
        }
        return true;
    }
    public static void visit(boolean[][] visited, int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = true;
        }
        return;
    }
    public static void unvisit(boolean[][] visited, int x, int y){
        visited[x][y] = false;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = false;
        }
        return;
    }
    public static int cal_cost(int x, int y){
        int result = map[x][y];
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            result += map[nx][ny];
        }
        return result;
    }


}
