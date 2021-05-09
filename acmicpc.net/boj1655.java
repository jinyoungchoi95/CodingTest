import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class boj1655 {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(i%2==1) minheap.add(num);
            else maxheap.add(num);

            if(!minheap.isEmpty() && !maxheap.isEmpty()){
                if(maxheap.peek() > minheap.peek()) {
                    int tmp = maxheap.poll();
                    maxheap.add(minheap.poll());
                    minheap.add(tmp);
                }
            }
            sb.append(maxheap.peek() + "\n");
        }
        System.out.println(sb.toString());
    }
}
