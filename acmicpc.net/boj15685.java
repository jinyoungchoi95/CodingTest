import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj15685 {
    public static int N;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static boolean[][] map = new boolean[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[2]);
            int g = Integer.parseInt(input[3]);
            ArrayList<Integer> direct = new ArrayList<>();
            direct.add(d);
            for(int i=0; i<g; i++){
                int size = direct.size();
                for(int j=size-1; j>=0; j--){
                    int tmp_d = direct.get(j);
                    direct.add((tmp_d+1)%4);
                }
            }
            map[x][y] = true;
            int nx = x;
            int ny = y;
            for(int i=0; i<direct.size(); i++){
                int nd = direct.get(i);
                nx += dx[nd];
                ny += dy[nd];
                map[nx][ny] = true;
            }
        }
        int answer = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}