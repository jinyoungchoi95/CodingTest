import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj1717 {
    public static int n, m;
    public static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n+1];
        for(int i=1; i<=n; i++){
            map[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int M=0; M<m; M++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmd==0) union(a,b);
            else sb.append((check_same(a,b)?"YES":"NO") + "\n");
        }
        System.out.println(sb.toString());
    }
    public static int find(int x) {
        if(x == map[x]) {
            return x;
        }

        return map[x] = find(map[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x!=y) {
            if(x>y) {
                map[y] = x;
            }
            else {
                map[x] = y;
            }
        }
    }

    public static boolean check_same(int x, int y){
        if(find(x) == find(y)) return true;

        return false;
    }
}
