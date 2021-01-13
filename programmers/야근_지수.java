import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            maxheap.add(works[i]);
        }

        while(!maxheap.isEmpty() && n>0){
            int num = maxheap.poll() - 1;
            if(num>0) maxheap.add(num);
            n--;
        }
        if(maxheap.isEmpty()) return 0;
        while(!maxheap.isEmpty()){
            int num = maxheap.poll();
            answer += num*num;
        }


        return answer;
    }
}