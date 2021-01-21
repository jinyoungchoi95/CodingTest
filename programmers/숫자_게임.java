import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> Apq = new PriorityQueue<>();
        PriorityQueue<Integer> Bpq = new PriorityQueue<>();
        for(int i=0; i<A.length; i++){
            Apq.add(A[i]);
            Bpq.add(B[i]);
        }
        while(!Bpq.isEmpty() && !Apq.isEmpty()){
            int a = Apq.poll();
            while(!Bpq.isEmpty()){
                if(a < Bpq.peek()){
                    answer++;
                    Bpq.poll();
                    break;
                }
                else{
                    Bpq.poll();
                }
            }
        }

        return answer;
    }
}