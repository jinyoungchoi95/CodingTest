import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14500 {
    public static int n,m;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static boolean[][] visited;
    public static int[][] map;
    public static int answer = 0;

    public static int[] plus1_x = {0,0,1};
    public static int[] plus1_y = {1,2,1};
    public static int[] plus2_x = {0,0,-1};
    public static int[] plus2_y = {1,2,1};
    public static int[] plus3_x = {1,1,2};
    public static int[] plus3_y = {0,1,0};
    public static int[] plus4_x = {1,1,2};
    public static int[] plus4_y = {0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = true;
                dfs(i,j,0,map[i][j]);
                dfs2(i,j);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }
    public static void dfs2(int x, int y){
        int sum = map[x][y];
        for(int i=0; i<3; i++){
            int nx = x + plus1_x[i];
            int ny = y + plus1_y[i];
            if(nx<0 || ny<0 || nx>=n || ny>=m){
                sum=0;
                break;
            }
            sum += map[nx][ny];
        }
        if(sum!=0) answer = Math.max(answer, sum);

        sum = map[x][y];
        for(int i=0; i<3; i++){
            int nx = x + plus2_x[i];
            int ny = y + plus2_y[i];
            if(nx<0 || ny<0 || nx>=n || ny>=m){
                sum=0;
                break;
            }
            sum += map[nx][ny];
        }
        if(sum!=0) answer = Math.max(answer, sum);

        sum = map[x][y];
        for(int i=0; i<3; i++){
            int nx = x + plus3_x[i];
            int ny = y + plus3_y[i];
            if(nx<0 || ny<0 || nx>=n || ny>=m){
                sum=0;
                break;
            }
            sum += map[nx][ny];
        }
        if(sum!=0) answer = Math.max(answer, sum);

        sum = map[x][y];
        for(int i=0; i<3; i++){
            int nx = x + plus4_x[i];
            int ny = y + plus4_y[i];
            if(nx<0 || ny<0 || nx>=n || ny>=m){
                sum=0;
                break;
            }
            sum += map[nx][ny];
        }
        if(sum!=0) answer = Math.max(answer, sum);

    }
    public static void dfs(int x, int y, int count, int sum){
        if(count==3){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]){
                continue;
            }
            visited[nx][ny] = true;
            dfs(nx, ny, count+1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}
