import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj15903 {
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        input = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            pq.add(Integer.parseInt(input[i]));
        }
        while(m!=0){
            m--;
            int a = pq.poll();
            int b = pq.poll();
            int num = a+b;
            pq.add(num); pq.add(num);
        }
        int answer = 0;
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
