import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2589 {
    public static char[][] map;
    public static int N, M;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        for(int i=0; i<N; i++){
            String input2 = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = input2.charAt(j);
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='L') {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(answer);
    }
    public static int bfs(int x, int y){
        Queue<index> queue = new LinkedList<>();
        int answer = 0;
        queue.add(new index(x,y,0));
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            answer = Math.max(answer, tmp.count);
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M){
                    continue;
                }

                if(!visited[nx][ny] && map[nx][ny]=='L'){
                    visited[nx][ny] = true;
                    queue.add(new index(nx,ny,tmp.count+1));
                }
            }
        }
        return answer;
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
