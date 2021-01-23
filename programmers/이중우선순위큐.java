import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int k=0; k<operations.length; k++){
            char c = operations[k].charAt(0);
            String[] input = operations[k].split(" ");
            int num = Integer.parseInt(input[1]);
            if(c=='I'){
                minheap.add(num);
                maxheap.add(num);
            }
            else{
                if(num==1){
                    minheap.remove(maxheap.poll());
                }
                else if(num==-1){
                    maxheap.remove(minheap.poll());
                }
            }
        }
        if(minheap.isEmpty()){
            return answer;
        }
        answer[0] = maxheap.poll();
        answer[1] = minheap.poll();
        return answer;

    }
}