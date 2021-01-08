import java.util.PriorityQueue;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int end = 0;

        PriorityQueue<index> heap = new PriorityQueue<>();
        for(int i=0; i<jobs.length; i++){
            heap.add(new index(jobs[i][0], jobs[i][1]));
        }
        ArrayList<index> list = new ArrayList<>();
        while(!heap.isEmpty()){
            list.add(heap.poll());
        }

        while(!list.isEmpty()){
            int i;
            for(i=0; i<list.size(); i++){
                index tmp = list.get(i);
                if(tmp.start <= end){
                    end += tmp.len;
                    answer += end - tmp.start;
                    list.remove(i);
                    break;
                }
                if(i==list.size()-1) end++;
            }
        }
        answer /= jobs.length;

        return answer;
    }
    public class index implements Comparable<index>{
        int start;
        int len;
        public index(int start, int len){
            this.start = start;
            this.len = len;
        }
        public int compareTo(index o){
            if(this.len < o.len) return -1;
            else if(this.len > o.len) return 1;
            else{
                if(this.start < o.start) return -1;
                else return 1;
            }
        }
    }
}