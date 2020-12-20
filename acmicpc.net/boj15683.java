import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj15683 {
    public static int N, M;
    public static int[][] map;
    public static ArrayList<index> camera;
    public static int answer = Integer.MAX_VALUE;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        camera = new ArrayList<>();
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]>0 && map[i][j]<6){
                    camera.add(new index(i,j));
                }
            }
        }
        boolean[][] see = new boolean[N][M];
        if(camera.isEmpty()){
            answer = calculate(see);
            System.out.println(answer);
            return;
        }

        find(0,see);
        System.out.println(answer);
    }
    public static void find(int start, boolean[][] see){
        if(start>=camera.size()){
            answer = Math.min(answer, calculate(see));
            return;
        }

        index tmp = camera.get(start);
        int camera_num = map[tmp.x][tmp.y];
        boolean[][] tmp_see;
        if(camera_num==1){
            for(int i=0; i<4; i++){
                tmp_see = new boolean[N][M];
                copy(tmp_see, see);
                marking(tmp_see, i, tmp.x, tmp.y);
                find(start+1, tmp_see);
            }
        }
        else if(camera_num==2){
            for(int i=0; i<2; i++){
                tmp_see = new boolean[N][M];
                copy(tmp_see, see);
                marking(tmp_see, i, tmp.x, tmp.y);
                marking(tmp_see, i+2, tmp.x, tmp.y);
                find(start+1, tmp_see);
            }
        }
        else if(camera_num==3){
            for(int i=0; i<4; i++){
                tmp_see = new boolean[N][M];
                copy(tmp_see, see);
                marking(tmp_see, i, tmp.x, tmp.y);
                marking(tmp_see, (i+1)%4, tmp.x, tmp.y);
                find(start+1, tmp_see);
            }
        }
        else if(camera_num==4){
            for(int i=0; i<4; i++){
                tmp_see = new boolean[N][M];
                copy(tmp_see, see);
                marking(tmp_see, i, tmp.x, tmp.y);
                marking(tmp_see, (i+1)%4, tmp.x, tmp.y);
                marking(tmp_see, (i+2)%4, tmp.x, tmp.y);
                find(start+1, tmp_see);
            }
        }
        else if(camera_num==5){
            tmp_see = new boolean[N][M];
            copy(tmp_see, see);
            marking(tmp_see, 0, tmp.x, tmp.y);
            marking(tmp_see, 1, tmp.x, tmp.y);
            marking(tmp_see, 2, tmp.x, tmp.y);
            marking(tmp_see, 3, tmp.x, tmp.y);
            find(start+1, tmp_see);
        }
    }
    public static void copy(boolean[][] tmp_see, boolean[][] see){
        for(int i=0; i<N; i++){
            tmp_see[i] = see[i].clone();
        }
    }
    public static void marking(boolean[][] see, int d, int x, int y){
        int nx = x + dx[d];
        int ny = y + dy[d];
        while(nx>=0 && ny>=0 && nx<N && ny<M){
            if(map[nx][ny]==6){
                return;
            }
            if(map[nx][ny]==0){
                see[nx][ny] = true;
            }
            nx += dx[d];
            ny += dy[d];
        }
    }
    public static int calculate(boolean[][] see){
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!see[i][j] && map[i][j]==0){
                    answer++;
                }
            }
        }
        return answer;
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
