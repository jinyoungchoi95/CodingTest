import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<truck> wait = new LinkedList<>();
        Queue<truck> bridge = new LinkedList<>();
        for(int i=0; i<truck_weights.length; i++){
            wait.add(new truck(truck_weights[i], 0));
        }

        int time = 0;
        int sum = 0;
        while(!wait.isEmpty() || !bridge.isEmpty()){
            time++;
            if(!bridge.isEmpty()){
                truck tmp = bridge.peek();
                if(time - tmp.time >= bridge_length){
                    sum -= tmp.weight;
                    bridge.poll();
                }
            }
            if(!wait.isEmpty()){
                if(sum+wait.peek().weight <= weight){
                    truck tmp = wait.poll();
                    sum += tmp.weight;

                    bridge.add(new truck(tmp.weight, time));
                }
            }
        }

        answer = time;

        return answer;
    }
    public class truck{
        int weight;
        int time;
        public truck(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }
}