import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3108 {
    public static int N;
    public static index[] map;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new index[N+1];
        visited = new boolean[N+1];
        map[0] = new index(0,0,0,0);
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            map[i+1] = new index(x1,y1,x2,y2);
        }
        int answer = 0;
        for(int i=0; i<=N; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer-1);
    }
    public static void dfs(int index){
        visited[index] = true;
        for(int i=0; i<=N; i++){
            if(visited[i]) continue;

            if(check_cross(index, i)){
                dfs(i);
            }
        }
    }
    public static boolean check_cross(int a, int b){
        if(map[a].x1<map[b].x1 && map[a].y1<map[b].y1 && map[b].x2<map[a].x2 && map[b].y2<map[a].y2) return false;
        else if(map[a].x1>map[b].x1 && map[a].y1>map[b].y1 && map[b].x2>map[a].x2 && map[b].y2>map[a].y2) return false;
        else if(map[a].x2<map[b].x1 || map[a].x1>map[b].x2 || map[a].y2<map[b].y1 || map[a].y1>map[b].y2) return false;

        return true;
    }
    public static class index{
        int x1;
        int y1;
        int x2;
        int y2;
        public index(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
