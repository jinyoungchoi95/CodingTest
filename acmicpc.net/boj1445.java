import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1445 {
    public static int n,m;
    public static char[][] map;
    public static boolean[][] visited;
    public static ArrayList<index> list = new ArrayList<>();
    public static index start;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String input2 = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = input2.charAt(j);
                if(map[i][j]=='S'){
                    start = new index(i,j,0,0);
                }
                else if(map[i][j]=='g'){
                    list.add(new index(i,j,0,0));
                }
            }
        }
        for(int i=0; i<list.size(); i++){
            index tmp = list.get(i);
            cal_side(tmp.x, tmp.y);
        }

        PriorityQueue<index> minheap = new PriorityQueue<>();
        minheap.offer(new index(start.x, start.y,0,0));
        visited[start.x][start.y] = true;
        while(!minheap.isEmpty()){
            index tmp = minheap.poll();
            if(map[tmp.x][tmp.y]=='F'){
                System.out.printf("%d %d",tmp.trash,tmp.side);
                return;
            }
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                int t = tmp.trash;
                int s = tmp.side;
                if(map[nx][ny]=='g') t++;
                if(map[nx][ny]=='s') s++;
                minheap.offer(new index(nx, ny, t, s));
            }
        }

    }
    public static void cal_side(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
            if(map[nx][ny]=='.') map[nx][ny] = 's';
        }
    }
    public static class index implements Comparable<index>{
        int x;
        int y;
        int trash;
        int side;
        public index(int x, int y, int trash, int side){
            this.x = x;
            this.y = y;
            this.trash = trash;
            this.side = side;
        }
        public int compareTo(index o){
            if(this.trash==o.trash){
                return this.side-o.side;
            }
            return this.trash-o.trash;
        }
    }
}
