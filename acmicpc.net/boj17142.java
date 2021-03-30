import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17142 {
    public static int N, M;
    public static int[][] map;
    public static int zeroSpace = 0;
    public static ArrayList<index> virus = new ArrayList<>();
    public static boolean[] currentVirus;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) zeroSpace++;
                else if(map[i][j] == 2) virus.add(new index(i, j));
            }
        }
        currentVirus = new boolean[virus.size()];
        getVirus(0, 0);
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
    public static void getVirus(int index, int count) {
        if(count == M){
            answer = Math.min(answer,bfs());
            return;
        }
        for(int i=index; i<currentVirus.length; i++){
            if(!currentVirus[i]){
                currentVirus[i] = true;
                getVirus(i+1, count+1);
                currentVirus[i] = false;
            }
        }
    }
    public static int bfs() {
        Queue<index> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for(int i=0; i<currentVirus.length; i++){
            if(currentVirus[i]){
                queue.add(new index(virus.get(i).x, virus.get(i).y));
            }
        }
        int currentZero = 0;
        int vsAnswer = 0;
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;

                if(visited[nx][ny]) continue;
                if(map[nx][ny]==1) continue;

                if(map[nx][ny] != 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        currentZero++;
                        vsAnswer = tmp.time + 1;
                    }
                    queue.add(new index(nx, ny, tmp.time + 1));
                }
            }
        }
        if(currentZero == zeroSpace) return vsAnswer;
        return Integer.MAX_VALUE;
    }
    public static class index{
        int x,y,time;

        public index(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public index(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}