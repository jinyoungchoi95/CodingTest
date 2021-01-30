import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj9376 {
    public static int h, w;
    public static char[][] map;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String[] input = br.readLine().split(" ");
            h = Integer.parseInt(input[0]);
            w = Integer.parseInt(input[1]);
            map = new char[h+2][w+2];
            for(int i=0; i<h+2; i++){
                for(int j=0; j<w+2; j++){
                    map[i][j] = '.';
                }
            }
            index help = new index(0,0);
            index per1 = new index(-1,-1);
            index per2 = new index(-1,-1);
            for(int i=1; i<h+1; i++){
                String input2 = br.readLine();
                for(int j=1; j<w+1; j++){
                    map[i][j] = input2.charAt(j-1);
                    if(map[i][j]=='$'){
                        if(per1.x<0){
                            per1.x = i; per1.y = j;
                        }
                        else{
                            per2.x = i; per2.y = j;
                        }
                    }
                }
            }
            int[][] dir1 = bfs(help);
            int[][] dir2 = bfs(per1);
            int[][] dir3 = bfs(per2);

            for(int i=0; i<h+2; i++){
                for(int j=0; j<w+2; j++){
                    dir1[i][j] += dir2[i][j] + dir3[i][j];
                }
            }
            int answer = dir1[0][0];
            for(int i=0; i<h+2; i++){
                for(int j=0; j<w+2; j++){
                    if(map[i][j]=='#'){
                        answer = Math.min(answer, dir1[i][j]-2);
                    }
                }
            }
            System.out.println(answer);
        }
    }
    public static int[][] bfs(index start){
        int[][] result = new int[h+2][w+2];
        for(int i=0; i<h+2; i++){
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }
        Queue<index> queue = new LinkedList<>();
        queue.add(new index(start.x, start.y));
        result[start.x][start.y] = 0;

        while(!queue.isEmpty()){
            index tmp = queue.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=h+2 || ny>=w+2) continue;
                if(map[nx][ny] == '*') continue;

                if(map[nx][ny] =='#'){
                    if(result[nx][ny] > result[tmp.x][tmp.y]+1){
                        result[nx][ny] = result[tmp.x][tmp.y] + 1;
                        queue.add(new index(nx, ny));
                    }
                }
                else{
                    if(result[nx][ny] > result[tmp.x][tmp.y]){
                        result[nx][ny] = result[tmp.x][tmp.y];
                        queue.add(new index(nx, ny));
                    }
                }
            }
        }





        return result;
    }
    public static class index{
        int x, y;
        public index(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
