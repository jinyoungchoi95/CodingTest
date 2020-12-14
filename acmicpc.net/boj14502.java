import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj14502 {
    public static int N, M;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] map, copyed;
    public static ArrayList<index> virus = new ArrayList<>();
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        copyed = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==2) virus.add(new index(i,j));
            }
        }
        dfs(0);
        System.out.println(answer);
    }
    public static void dfs(int depth){
        if(depth==3){
            copy();
            for(int i=0; i<virus.size(); i++){
                int v_x = virus.get(i).x;
                int v_y = virus.get(i).y;
                bfs(v_x, v_y);
            }

            int value = find_safe();

            answer = Math.max(answer, value);
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(depth+1);
                    map[i][j]=0;
                }
            }
        }
    }
    public static void copy(){
        for(int i=0; i<N; i++){
            copyed [i] = map[i].clone();
        }
        return;
    }
    public static void bfs(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M){
                continue;
            }
            if(copyed[nx][ny]==0){
                copyed[nx][ny] = 2;
                bfs(nx, ny);
            }
        }
    }
    public static int find_safe(){
        int value = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copyed[i][j]==0){
                    value++;
                }
            }
        }
        return value;
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
