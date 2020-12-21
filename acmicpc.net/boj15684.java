import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15684 {
    public static int N, M, H;
    public static int[][] map;
    public static int answer = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);
        map = new int[H+1][N+1];
        for(int m=0; m<M; m++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            map[a][b] = 1;
            map[a][b+1] = 2;
        }
        for(int i=0; i<=3; i++){
            dfs(i,0);
        }
        if(answer==4) System.out.println(-1);
        else System.out.println(answer);

    }
    public static void dfs(int x, int count){
        if(answer<count){
            return;
        }
        if(x==count){
            if(check()){
                answer = Math.min(answer, count);
            }
            return;
        }
        for(int i=1; i<=H; i++){
            for(int j=1; j<N; j++){
                if(map[i][j]==0 && map[i][j+1]==0){
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    dfs(x, count+1);
                    map[i][j] = map[i][j+1] = 0;
                }
            }
        }
    }
    public static boolean check(){
        for(int i=1; i<N; i++){
            int start = i;
            for(int j=1; j<=H; j++){
                if(map[j][start]==1){
                    start++;
                }
                else if(map[j][start]==2){
                    start--;
                }
            }
            if(start!=i){
                return false;
            }
        }
        return true;
    }
}
