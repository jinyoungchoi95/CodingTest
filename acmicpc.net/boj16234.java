import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj16234 {
    public static int N, L, R;
    public static int[][] map;
    public static boolean check_change;
    public static boolean[][] changed,visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        map = new int[N][N];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        check_change = true;
        while(check_change){
            check_change = false;
            changed = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!changed[i][j]){
                        bfs(i, j);
                    }
                }
            }
            if(!check_change) break;
            answer++;
        }
        System.out.println(answer);


    }
    public static void bfs(int x, int y){
        changed[x][y] = true;
        Queue<index> queue = new LinkedList<>();
        ArrayList<index> change_people = new ArrayList<>();
        queue.add(new index(x,y));
        change_people.add(new index(x,y));
        int sum = map[x][y];
        int people = 1;
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N){
                    continue;
                }
                if(changed[nx][ny]){
                    continue;
                }
                if(compare(map[tmp.x][tmp.y], map[nx][ny])){
                    changed[nx][ny] = true;
                    sum += map[nx][ny];
                    people++;
                    change_people.add(new index(nx,ny));
                    queue.add(new index(nx,ny));
                }

            }
        }
        if(people==1) {
            return;
        }
        else{
            sum /= people;
            for(int i=0; i<change_people.size(); i++){
                index a = change_people.get(i);
                map[a.x][a.y] = sum;
            }
            check_change = true;
            return;
        }
    }


    public static boolean compare(int first, int second){
        int compared = Math.abs(first - second);
        if(compared>=L && compared<=R){
            return true;
        }
        return false;
    }
    public static class index{
        int x;
        int y;
        public index(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
