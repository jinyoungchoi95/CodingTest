import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2252 {
    public static int N, M;
    public static ArrayList<Integer>[] map;
    public static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new ArrayList[N+1];
        indegree = new int[N+1];
        for(int i=1; i<=N; i++){
            map[i] = new ArrayList<>();
        }
        for(int m=0; m<M; m++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map[A].add(B);
            indegree[B]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.printf("%d ", tmp);

            for(int i=0; i<map[tmp].size(); i++){
                int next = map[tmp].get(i);
                indegree[next]--;
                if(indegree[next]==0) {
                    queue.add(next);
                }
            }
        }
    }
}
