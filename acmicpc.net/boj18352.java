import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj18352 {
    public static int n, m, k, x;
    public static ArrayList<Integer>[] road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        x = Integer.parseInt(input[3]);
        road = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            road[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            road[a].add(b);
        }

        int[] value = new int[n+1];
        Arrays.fill(value,  Integer.MAX_VALUE);
        value[x] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=0; i<road[now].size(); i++){
                int next = road[now].get(i);
                if( value[now]+1 < value[next]){
                    value[next] = value[now]+1;
                    queue.add(next);
                }
            }
        }
        boolean check = false;
        for(int i=1; i<=n; i++){
            if(value[i] == k){
                System.out.println(i);
                check = true;
            }
        }
        if(!check) System.out.println(-1);
    }
}