import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14499 {
    public static int N, M, x, y, K, d;
    public static int[][] map;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static int[] dice = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);
        y = Integer.parseInt(input[3]);
        K = Integer.parseInt(input[4]);
        map = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        input = br.readLine().split(" ");
        for(int k=0; k<K; k++){
            d = Integer.parseInt(input[k])-1;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0 || ny<0 || nx>=N || ny>=M){
                continue;
            }
            change_dice();
            x = nx;
            y = ny;

            if(map[x][y]==0){
                map[x][y] = dice[6];
            }
            else{
                dice[6] = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(dice[1]);
        }
    }
    public static void change_dice(){
        int[] tmp = dice.clone();
        if(d==0){
            dice[3] = tmp[1];
            dice[6] = tmp[3];
            dice[4] = tmp[6];
            dice[1] = tmp[4];
        }
        else if(d==1){
            dice[4] = tmp[1];
            dice[6] = tmp[4];
            dice[3] = tmp[6];
            dice[1] = tmp[3];
        }
        else if(d==2){
            dice[1] = tmp[5];
            dice[5] = tmp[6];
            dice[6] = tmp[2];
            dice[2] = tmp[1];
        }
        else{
            dice[1] = tmp[2];
            dice[2] = tmp[6];
            dice[6] = tmp[5];
            dice[5] = tmp[1];
        }
    }
}
