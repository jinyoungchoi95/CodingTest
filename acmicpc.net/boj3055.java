import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj3055 {
    public static int N, M;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static char[][] map;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        visited = new boolean[N][M];
        Queue<index> dochi = new LinkedList<>();
        Queue<index> water = new LinkedList<>();
        int start_x, start_y, want_x, want_y;
        for(int i=0; i<N; i++){
            String input2 = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = input2.charAt(j);
                if(map[i][j]=='D'){
                    want_x = i;
                    want_y = j;
                }
                else if(map[i][j]=='S'){
                    start_x = i;
                    start_y = j;
                    visited[i][j] = true;
                    map[i][j] = '.';
                    dochi.add(new index(i,j));
                }
                else if(map[i][j]=='*'){
                    water.add(new index(i,j));
                }
            }
        }
        int answer = 0;
        while(true){
            answer ++;

            int size_water = water.size();
            for(int k=0; k<size_water; k++){
                index tmp = water.poll();
                for(int i=0; i<4; i++){
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if(nx<0 || ny<0 || nx>=N || ny>=M){
                        continue;
                    }

                    if(map[nx][ny]=='.'){
                        map[nx][ny] = '*';
                        water.add(new index(nx,ny));
                    }
                }
            }
            if(dochi.isEmpty()){
                System.out.println("KAKTUS");
                return;
            }
            int size_dochi = dochi.size();
            for(int k=0; k<size_dochi; k++){
                index tmp = dochi.poll();
                for(int i=0; i<4; i++){
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if(nx<0 || ny<0 || nx>=N || ny>=M){
                        continue;
                    }

                    if(map[nx][ny]=='D'){
                        System.out.println(answer);
                        return;
                    }
                    if(map[nx][ny]=='.' && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        dochi.add(new index(nx,ny));
                    }
                }
            }
        }
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
