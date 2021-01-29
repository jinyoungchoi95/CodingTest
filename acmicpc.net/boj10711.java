import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj10711 {
    public static int[][] map;
    public static int h,w;
    public static int[] dx = {-1,-1,-1,0,0,1,1,1};
    public static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        h = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);
        map = new int[h][w];
        for(int i=0; i<h; i++){
            input = br.readLine().split("");
            for(int j=0; j<w; j++){
                if(input[j].charAt(0)=='.') continue;
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        Queue<index> queue = new LinkedList<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j]==0) continue;
                int wave = cal_wave(i, j);
                if(map[i][j] <= wave) queue.add(new index(i,j,1));
            }
        }
        int answer = 0;
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            if(map[tmp.x][tmp.y]==0) continue;
            answer = Math.max(answer, tmp.count);
            map[tmp.x][tmp.y] = 0;

            for(int i=0; i<8; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=h || ny>=w || map[nx][ny]==0) continue;
                int wave = cal_wave(nx, ny);
                if(map[nx][ny] <= wave) queue.add(new index(nx, ny, tmp.count+1));
            }
        }
        System.out.println(answer);
    }
    public static int cal_wave(int x, int y){
        int result = 0;
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=h || ny>=w) continue;
            if(map[nx][ny]==0) result++;
        }
        return result;
    }
    public static class index{
        int x;
        int y;
        int count;
        public index(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
