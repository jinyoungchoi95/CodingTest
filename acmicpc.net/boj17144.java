import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj17144 {
    public static int R, C, T;
    public static int[][] map;
    public static int up, down;
    public static ArrayList<index> dust = new ArrayList<>();
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);
        map = new int[R][C];
        ArrayList<Integer> location = new ArrayList<>();
        for(int i=0; i<R; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]>0){
                    dust.add(new index(i,j,map[i][j]));
                }
            }
            if(map[i][0]==-1) location.add(i);
        }
        up = location.get(0);
        down = location.get(1);

        for(int t=0; t<T; t++){
            spread();
            up_clear();
            down_clear();
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j]>0){
                        dust.add(new index(i,j,map[i][j]));
                    }
                }
            }
        }
        int answer = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]>0){
                    answer += map[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    public static void spread(){
        if(dust.isEmpty()){
            return;
        }
        ArrayList<index> dust_tmp = new ArrayList<>();
        for(int i=0; i<dust.size(); i++){
            index tmp = dust.get(i);
            if(tmp.value<5){
                continue;
            }
            int amount = tmp.value/5;
            int count = 0;
            for(int j=0; j<4; j++){
                int nx = tmp.x + dx[j];
                int ny = tmp.y + dy[j];
                if(nx<0 || ny<0 || nx>=R || ny>=C){
                    continue;
                }
                if(map[nx][ny]==-1){
                    continue;
                }
                count++;
                dust_tmp.add(new index(nx,ny,amount));
            }
            map[tmp.x][tmp.y] -= amount * count;
        }
        dust.clear();

        for(int i=0; i<dust_tmp.size(); i++){
            index tmp = dust_tmp.get(i);
            map[tmp.x][tmp.y] += tmp.value;
        }
    }

    public static void up_clear(){
        int nx = up;
        int ny = 2;
        for(int i=nx-1; i>0; i--){
            map[i][0] = map[i-1][0];
        }
        for(int i=0; i<C-1; i++){
            map[0][i] = map[0][i+1];
        }
        for(int i=0; i<up; i++){
            map[i][C-1] = map[i+1][C-1];
        }
        for(int i=C-1; i>1; i--){
            map[up][i] = map[up][i-1];
        }
        map[up][1] = 0;
    }

    public static void down_clear(){
        int ny = down;
        for(int i=down+1; i<R-1; i++){
            map[i][0] = map[i+1][0];
        }
        for(int i=0; i<C-1; i++){
            map[R-1][i] = map[R-1][i+1];
        }
        for(int i=R-1; i>down; i--){
            map[i][C-1] = map[i-1][C-1];
        }
        for(int i=C-1; i>1; i--){
            map[down][i] = map[down][i-1];
        }
        map[down][1] = 0;
    }
    public static class index{
        int x;
        int y;
        int value;
        public index(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}