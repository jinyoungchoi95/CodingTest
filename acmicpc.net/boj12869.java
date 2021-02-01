import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class boj12869 {
    public static int N;
    public static int[] damage = {9, 3, 1};
    public static int answer = 60;
    public static boolean[][][] visited = new boolean[61][61][61];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] map = new int[3];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(input[i]);
        }
        dfs(map[0], map[1], map[2], 0);
        System.out.println(answer);
    }
    public static void dfs(int x, int y, int z, int day){
        x = Math.max(0, x);
        y = Math.max(0, y);
        z = Math.max(0, z);
        int max = Math.max(x,Math.max(y,z));
        int min = Math.min(x,Math.min(y,z));
        int mid = x+y+z-max-min;
        x = max; y = mid; z =min;
        if(x==0 && y==0 && z==0){
            answer = Math.min(answer, day);
            return;
        }

        if(visited[x][y][z]) return;
        visited[x][y][z] = true;
        if(answer < day) return;

        dfs(x-9, y-3, z-1, day+1);
        dfs(x-9, y-1, z-3, day+1);

        dfs(x-3, y-9, z-1, day+1);
        dfs(x-3, y-1, z-9, day+1);

        dfs(x-1, y-9, z-3, day+1);
        dfs(x-1, y-3, z-9, day+1);
    }
}
