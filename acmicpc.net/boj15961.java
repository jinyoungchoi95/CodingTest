import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        int[] num = new int[N];
        int[] visited = new int[d+1];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        int count = 0;
        for(int i=0; i<k; i++){
            if(visited[num[i]]==0) count++;
            visited[num[i]]++;
        }
        max = count;
        for(int i=1; i<N; i++){
            if(visited[c]==0) max = Math.max(max, count+1);
            else max = Math.max(max, count);


            visited[num[i-1]]--;
            if(visited[num[i-1]]==0) count--;

            if(visited[num[(i+k-1)%N]]++==0) count++;
        }
        System.out.println(max);

    }
}
