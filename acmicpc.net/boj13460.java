import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj13460 {
    public static int N, M;
    public static char[][] map;
    public static boolean[][][][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int want_x, want_y;
    public static Queue<index> queue = new LinkedList<>();
    public static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        int R_x = 0;
        int R_y = 0;
        int B_x = 0;
        int B_y = 0;
        for(int i=0; i<N; i++){
            String input2 = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = input2.charAt(j);
                if(map[i][j]=='R'){
                    R_x = i;
                    R_y = j;
                    map[i][j] = '.';
                }
                else if(map[i][j]=='B'){
                    B_x = i;
                    B_y = j;
                    map[i][j] = '.';
                }
                else if(map[i][j]=='O'){
                    want_x = i;
                    want_y = j;
                }
            }
        }
        queue.add(new index(R_x, R_y, B_x, B_y, 0));
        dfs();
        System.out.println(answer);
    }
    public static void dfs(){
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            if(tmp.count>10){
                return;
            }
            if(tmp.R_x==want_x && tmp.R_y==want_y){
                answer = tmp.count;
                return;
            }

            for(int i=0; i<4; i++){
                int R_nx = tmp.R_x;
                int R_ny = tmp.R_y;
                int B_nx = tmp.B_x;
                int B_ny = tmp.B_y;
                if(who_is_first(tmp.R_x, tmp.R_y, tmp.B_x, tmp.B_y, i)){
                    while(true){
                        R_nx += dx[i];
                        R_ny += dy[i];
                        if(map[R_nx][R_ny]=='O'){
                            break;
                        }
                        if(map[R_nx][R_ny]=='#'){
                            R_nx -= dx[i];
                            R_ny -= dy[i];
                            break;
                        }
                    }
                    while(true){
                        B_nx += dx[i];
                        B_ny += dy[i];
                        if(map[B_nx][B_ny]=='O'){
                            break;
                        }
                        if(map[B_nx][B_ny]=='#' || (B_nx==R_nx && B_ny==R_ny)){
                            B_nx -= dx[i];
                            B_ny -= dy[i];
                            break;
                        }
                    }
                }
                else{
                    while(true){
                        B_nx += dx[i];
                        B_ny += dy[i];
                        if(map[B_nx][B_ny]=='O'){
                            break;
                        }
                        if(map[B_nx][B_ny]=='#'){
                            B_nx -= dx[i];
                            B_ny -= dy[i];
                            break;
                        }
                    }
                    while(true){
                        R_nx += dx[i];
                        R_ny += dy[i];
                        if(map[R_nx][R_ny]=='O'){
                            break;
                        }
                        if(map[R_nx][R_ny]=='#' || (B_nx==R_nx && B_ny==R_ny)){
                            R_nx -= dx[i];
                            R_ny -= dy[i];
                            break;
                        }
                    }
                }
                if(!visited[R_nx][R_ny][B_nx][B_ny] && map[B_nx][B_ny]!='O'){
                    visited[R_nx][R_ny][B_nx][B_ny] = true;
                    queue.add(new index(R_nx, R_ny, B_nx, B_ny, tmp.count+1));
                }
            }

        }
    }
    //true : Red first
    //false : Blue first
    public static boolean who_is_first(int R_x, int R_y, int B_x, int B_y, int di){
        if(di==0){
            if(R_y>=B_y) return true;
            return false;
        }
        else if(di==1){
            if(R_x>=B_x) return true;
            return false;
        }
        else if(di==2){
            if(R_y<=B_y) return true;
            return false;
        }
        else{
            if(R_x<=B_x) return true;
            return false;
        }
    }
    public static class index{
        int R_x;
        int R_y;
        int B_x;
        int B_y;
        int count;
        public index(int R_x, int R_y, int B_x, int B_y, int count){
            this.R_x = R_x;
            this.R_y = R_y;
            this.B_x = B_x;
            this.B_y = B_y;
            this.count = count;
        }
    }
}
