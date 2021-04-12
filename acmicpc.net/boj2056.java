import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj2056 {
    public static int N;
    public static ArrayList<Integer>[] link;
    public static int[] cost;
    public static int[] indegree;
    public static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        link = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            link[i] = new ArrayList<>();
        }
        cost = new int[N+1];
        result = new int[N+1];
        indegree = new int[N+1];
        for(int i=1; i<=N; i++){
            String[] input = br.readLine().split(" ");
            cost[i] = Integer.parseInt(input[0]);
            indegree[i] = Integer.parseInt(input[1]);

            for(int j=2; j<2+indegree[i]; j++){
                link[Integer.parseInt(input[j])].add(i);
            }
        }
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){
                queue.add(i);
                result[i] = cost[i];
            }
        }

        while(!queue.isEmpty()){
            int tmp = queue.poll();

            answer = Math.max(answer, result[tmp]);
            for(int i=0; i<link[tmp].size(); i++){
                int next = link[tmp].get(i);
                indegree[next]--;
                result[next] = Math.max(result[next], cost[next]+result[tmp]);
                if(indegree[next] == 0) queue.add(next);
            }
        }
        System.out.println(answer);
    }
}